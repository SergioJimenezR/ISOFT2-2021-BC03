package es.uclm.esi.isoft2.ReservaMesas.Dominio;

import es.uclm.esi.isoft2.ReservaMesas.Presentacion.IU_JefeSala;

import java.sql.SQLException;

import javax.swing.JComboBox;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.MesaDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.*;


public class GestorMesa {
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
	
}
