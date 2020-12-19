package es.uclm.esi.isoft2.Estadisticas.Dominio;

import es.uclm.esi.isoft2.Estadisticas.Persistencia.EstadisticasDAO;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

import java.sql.SQLException;

public class Estadisticas {

	/**
	 * Contiene los tiempos medios de cada estado en todos los servicios del
	 * restaurante
	 */
	private double[] vectorTiemposMediosTotales;
	/**
	 * Contiene el numero total de mesas atendidas en todos los servicios del
	 * restaurante
	 */
	private int nMesas;
	/**
	 * Estancia de EstadisticasDAO que proporciona acceso a la capa de Persistencia
	 */
	private static EstadisticasDAO dao;

	/**
	 * Constructor de la clase estadisticas
	 * 
	 * @throws SQLException excepcion por no estar conectado a la BBDD
	 */
	public Estadisticas() throws SQLException {
		dao = new EstadisticasDAO();
		this.leerVectorTiemposMediosTotales();
		this.leerNMesas();
	}

	/**
	 * Devuelve el vector que contiene los tiempos medios de cada calculados a lo
	 * largo del tiempo.
	 * 
	 * @return double[] vector de tiempos
	 */
	public double[] getVectorTiemposMediosTotales() {
		return vectorTiemposMediosTotales;
	}

	/**
	 * Carga en el vectorTiemposMediosTotales los tiempos medios de todos los
	 * servicios del restaurante, que se obtienen de la base de datos.
	 * 
	 * @throws SQLException excepcion por no estar conectado a la BBDD
	 */
	private void leerVectorTiemposMediosTotales() throws SQLException {
		this.vectorTiemposMediosTotales = dao.obtenerMedias();
	}

	/**
	 * Lee de la base de datos el valor de nMesas
	 * 
	 * @throws SQLException excepcion por no estar conectado a la BBDD
	 */
	private void leerNMesas() throws SQLException {
		this.nMesas = dao.obtenerNMesas();
	}

	/**
	 * Anyade los tiempos de cada estado de la mesa y recalcula el tiempo medio
	 * general de cada estado.
	 * 
	 * @param mesa mesa de la que medimos los tiempos
	 */
	public void enviarTiemposMediosMesa(Mesa mesa) {
		double[] tiemposMesa = mesa.getVectorTiempos();
		++nMesas;
		for (int i = 0; i < tiemposMesa.length; i++) {
			vectorTiemposMediosTotales[i] = ((vectorTiemposMediosTotales[i]) + tiemposMesa[i]) / (double) this.nMesas;
		}
	}

	/**
	 * Envia el estado del vector de tiempos a EstadisticaDAO para actualizar su
	 * estado en la base de datos y comprueba que se haya realizado correctamente.
	 * 
	 * @throws SQLException excepcion que salta si no estamos conectados a la BBDD
	 */
	public void enviarTiemposPersistencia() throws SQLException {
		int ejecucionCorrecta = dao.anyadirTiemposMedios(vectorTiemposMediosTotales, nMesas);
		if (ejecucionCorrecta == 1)
			new SQLException();
	}

	/**
	 * Devuelve una descripcion del estado del vectorTiemposMediosTotales
	 * 
	 * @return devuelve los tiempos en formato String
	 */
	public String getTiemposEstadistica() {
		return "Ocupada=" + vectorTiemposMediosTotales[2] + ", Pidiendo=" + vectorTiemposMediosTotales[3]
				+ ", EsperandoComida=" + vectorTiemposMediosTotales[4] + ", Servidos=" + vectorTiemposMediosTotales[5]
				+ ", EsperandoCuenta=" + vectorTiemposMediosTotales[6] + ", Paganado=" + vectorTiemposMediosTotales[7]
				+ ", EnPreparacion =" + vectorTiemposMediosTotales[8] + ".";
	}

}