package es.uclm.esi.isoft2.ReservaMesas.Dominio;

import es.uclm.esi.isoft2.ReservaMesas.Presentacion.IU_JefeSala;

import java.sql.SQLException;

import javax.swing.JComboBox;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.MesaDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.*;

/**
 * Asume la comunicación con la clase MesaDAO de la capa de persistencia
 * @author 
 *
 */
public class GestorMesa {
	/**
	 * Modifica el estado de la mesa en la base de datos cambiando su estado a ocupada y modificando
	 * el DNI al que se asocia la mesa
	 * @param idMesa
	 * @param dniCliente
	 * @return
	 * @throws SQLException
	 */
	public static boolean cambiarEstadoOcupado(int idMesa, String dniCliente) throws SQLException {
		JComboBox<Mesa> mesas = IU_JefeSala.getComboBoxReservadas();
		for (int i = 0; i < mesas.getItemCount(); i++) {
			mesas.setSelectedIndex(i);
			Mesa mesa = (Mesa) mesas.getSelectedItem();
			if (mesa.getId() == idMesa && dniCliente.equals(MesaDAO.devolverDni(idMesa))) {
				mesa.setEstadoMesa(EstadosMesas.OCUPADA);
				mesas.setSelectedItem(mesa);
				IU_JefeSala.setComboBoxReservadas(mesas);
				String estado = mesa.getEstadoMesa().toString();
				MesaDAO.actualizarNumMesa(mesa.getId(), estado, mesa.getDni());
				return true;
			}
		}
		return false;
	}

	/**
	 * Modifica el estado de la mesa en la base de datos cambiando su estado a libre y modificando
	 * el DNI al que se asocia la mesa
	 * @param idMesa
	 * @return
	 * @throws SQLException
	 */
	public static boolean cancelarMesa(int idMesa) throws SQLException {
		JComboBox<Mesa> mesas = IU_JefeSala.getComboBoxReservadas();
		for (int i = 0; i < mesas.getItemCount(); i++) {
			mesas.setSelectedIndex(i);
			Mesa mesa = (Mesa) mesas.getSelectedItem();
			if (mesa.getId() == idMesa) {
				mesa.setEstadoMesa(EstadosMesas.LIBRE);
				mesas.setSelectedItem(mesa);
				IU_JefeSala.setComboBoxReservadas(mesas);
				String estado = mesa.getEstadoMesa().toString();
				MesaDAO.actualizarNumMesa(mesa.getId(), estado, mesa.getDni());
				return true;
			}
		}
		return false;
	}

	/**
	 * Actualiza el estado de la mesa en la base de datos
	 * @param id: el id de la mesa a modificar
	 * @param estado: el nuevo estado de la mesa
	 * @param dni: número al que se le asocia la mesa
	 * @throws SQLException
	 */
	public static void actualizarMesa(int id, String estado, String dni) throws SQLException {
		MesaDAO.actualizarNumMesa(id, estado, dni);
	}

}
