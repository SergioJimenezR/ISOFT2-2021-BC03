package es.uclm.esi.isoft2.ReservaMesas.Dominio;

import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_CamareroMesa;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;
import javax.swing.JComboBox;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.*;
public class GestorMesa {
	public static boolean cambiarEstadoOcupado(int idMesa) {
		JComboBox<Mesa> mesas = IU_CamareroMesa.getComboBoxMesas();
		for (int i = 0; i < mesas.getItemCount(); i++) {
			mesas.setSelectedIndex(i);
			Mesa mesa = (Mesa) mesas.getSelectedItem();
			if (mesa.getId() == idMesa) {
				mesa.setEstadoMesa(EstadosMesas.OCUPADA);
				mesas.setSelectedItem(mesa);
				return true;
			}
		}
		return false;
	}
	
	public static boolean cancelarMesa(int idMesa) {
		JComboBox<Mesa> mesas = IU_CamareroMesa.getComboBoxMesas();
		for (int i = 0; i < mesas.getItemCount(); i++) {
			mesas.setSelectedIndex(i);
			Mesa mesa = (Mesa) mesas.getSelectedItem();
			if (mesa.getId() == idMesa) {
				mesa.setEstadoMesa(EstadosMesas.LIBRE);
				mesas.setSelectedItem(mesa);
				return true;
			}
		}
		return false;
	}
	
}
