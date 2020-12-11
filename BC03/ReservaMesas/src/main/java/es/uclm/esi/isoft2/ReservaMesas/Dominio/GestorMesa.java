package es.uclm.esi.isoft2.ReservaMesas.Dominio;

import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_CamareroMesa;
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
			if (mesa.getId() == idMesa && dniCliente.equals(mesa.getDni())) {
				mesa.setEstadoMesa(EstadosMesas.OCUPADA);
				mesas.setSelectedItem(mesa);
				IU_JefeSala.setComboBoxReservadas(mesas);
				String estado = mesa.getEstadoMesa().toString();
				System.out.println(estado);
				MesaDAO.actualizarNumMesa(mesa.getId(), estado);
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
				MesaDAO.actualizarNumMesa(mesa.getId(), estado);
				return true;
			}
		}
		return false;
	}
	
}
