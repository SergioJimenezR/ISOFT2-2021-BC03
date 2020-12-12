package es.uclm.esi.isoft2.Estadisticas.Dominio;


import java.sql.SQLException;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Agente;
import es.uclm.esi.isoft2.Estadisticas.Persistencia.EstadisticaDAO;

public class Estadisticas {
	
	private static double[] vectorTiemposMediosTotales;
	private static EstadisticaDAO dao;
	
	
	public Estadisticas() throws SQLException {
		dao = new EstadisticaDAO();
		this.setVectorTiemposMediosTotales();
	}
	
	
	
	public double[] getVectorTiemposMediosTotales() {
		return vectorTiemposMediosTotales;
	}



	private void setVectorTiemposMediosTotales() throws SQLException {
		this.vectorTiemposMediosTotales = dao.obtenerMedias();
	}

	public static void enviarTiemposMediosMesa(Mesa mesa) {
		double[] tiemposMesa = mesa.getVectorTiempos();
		for(int i=0; i< tiemposMesa.length;i++) {
			vectorTiemposMediosTotales[i] = (vectorTiemposMediosTotales[i] + tiemposMesa[i])/2;
		}		
	}
	
	public static void enviarTiemposPersistencia() throws SQLException {
		int ejecucionCorrecta = dao.anyadirTiemposMedios(vectorTiemposMediosTotales);
		if (ejecucionCorrecta == 1)
			new SQLException();
	}
	
	public String getTiemposEstadistica() {
		return "Libre = "+ vectorTiemposMediosTotales[0] +", Reservada= "+ vectorTiemposMediosTotales[1] +", Ocupada="+ vectorTiemposMediosTotales[2] +", Pidiendo="+ vectorTiemposMediosTotales[3] +", EsperandoComida="+ vectorTiemposMediosTotales[4] +", Servidos="+ vectorTiemposMediosTotales[5] +", EsperandoCuenta="+ vectorTiemposMediosTotales[6] +", Paganado="+ vectorTiemposMediosTotales[7] +", Ensuciada ="+ vectorTiemposMediosTotales[8]+".";
	}
	
}
