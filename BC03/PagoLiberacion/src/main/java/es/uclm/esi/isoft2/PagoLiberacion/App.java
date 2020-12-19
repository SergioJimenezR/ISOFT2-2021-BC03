package es.uclm.esi.isoft2.PagoLiberacion;

import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_CamareroMesa;
import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_Cocina;
import es.uclm.esi.isoft2.PedidosComandas.Presentacion.IU_CamareroBarra;
import es.uclm.esi.isoft2.ReservaMesas.Presentacion.IU_JefeSala;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;

public class App {

	/**
	 * Metodo principal del programa.
	 * 
	 * @param args Argumentos de la linea de ordenes
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Almacen.getAlmacen();

				try {
					IU_CamareroMesa.getInterfaz();
					IU_JefeSala frame = new IU_JefeSala();
					frame.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				IU_Cocina.getInterfaz();
				IU_CamareroBarra.getInterfaz();

			}
		});
	}
}
