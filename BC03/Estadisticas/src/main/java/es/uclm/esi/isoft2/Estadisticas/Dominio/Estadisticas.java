package es.uclm.esi.isoft2.Estadisticas.Dominio;


import java.sql.SQLException;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.Estadisticas.Persistencia.EstadisticaDAO;

public class Estadisticas {
	
	private static double[] vectorTiemposMediosTotales;
	private EstadisticaDAO dao;
	
	
	public Estadisticas() throws SQLException {
		dao = new EstadisticaDAO();
		this.setVectorTiemposMediosTotales();
		
	}
	
	
	
	public double[] getVectorTiemposMediosTotales() {
		return vectorTiemposMediosTotales;
	}



	public void setVectorTiemposMediosTotales() throws SQLException {
		this.vectorTiemposMediosTotales = dao.obtenerMedias();
	}



	public static void enviarTiemposMediosMesa(Mesa mesa) {
		double[] tiemposMesa = mesa.getVectorTiempos();
		for(int i=0; i< tiemposMesa.length;i++) {
			vectorTiemposMediosTotales[i] = (vectorTiemposMediosTotales[i] + tiemposMesa[i])/2;
		}		
	}

}
