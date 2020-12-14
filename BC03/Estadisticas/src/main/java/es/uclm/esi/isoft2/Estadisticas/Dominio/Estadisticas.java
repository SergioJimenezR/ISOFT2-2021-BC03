package es.uclm.esi.isoft2.Estadisticas.Dominio;

import es.uclm.esi.isoft2.Estadisticas.Persistencia.EstadisticasDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

import java.sql.SQLException;

public class Estadisticas {

	
	private  double[] vectorTiemposMediosTotales;
	private int nMesas;
	private static EstadisticasDAO dao;
	
	
	public Estadisticas() throws SQLException {
		dao = new EstadisticasDAO();
		this.leerVectorTiemposMediosTotales();
		this.leerNMesas();
	}
	
	
	
	public double[] getVectorTiemposMediosTotales() {
		return vectorTiemposMediosTotales;
	}



	private void leerVectorTiemposMediosTotales() throws SQLException {
		this.vectorTiemposMediosTotales = dao.obtenerMedias();
	}
	
	private void leerNMesas() throws SQLException {
		this.nMesas = dao.obtenerNMesas();
	}

	public void enviarTiemposMediosMesa(Mesa mesa) {
		double[] tiemposMesa = mesa.getVectorTiempos();
		for(int i=0; i< tiemposMesa.length;i++) {
			++nMesas;
			vectorTiemposMediosTotales[i] = ((vectorTiemposMediosTotales[i]) + tiemposMesa[i])/(double)this.nMesas;
		}		
	}

	public void enviarTiemposPersistencia() throws SQLException {
		for(int i=0; i<this.vectorTiemposMediosTotales.length;i++)
			System.out.println(this.vectorTiemposMediosTotales[i]+" ");
		int ejecucionCorrecta = dao.anyadirTiemposMedios(vectorTiemposMediosTotales, nMesas);
		if (ejecucionCorrecta == 1)
			new SQLException();
	}
	
	public String getTiemposEstadistica() {
		return "Ocupada="+ vectorTiemposMediosTotales[2] +", Pidiendo="+ vectorTiemposMediosTotales[3] +", EsperandoComida="+ vectorTiemposMediosTotales[4] +", Servidos="+ vectorTiemposMediosTotales[5] +", EsperandoCuenta="+ vectorTiemposMediosTotales[6] +", Paganado="+ vectorTiemposMediosTotales[7] +", EnPreparacion ="+ vectorTiemposMediosTotales[8]+".";
	}
	
}