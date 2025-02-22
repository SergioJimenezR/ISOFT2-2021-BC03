package es.uclm.esi.isoft2.Estadisticas.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Agente;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;

public class EstadisticasDAO {

	/**
	 * Recupera de la base de datos el tiempo medio de cada estado
	 * 
	 * @return devuelve los tiempos medios
	 * @throws SQLException excepcion que salta si no estamos conectados a la BBDD
	 */
	public double[] obtenerMedias() throws SQLException {
		double[] medias = new double[9];
		ResultSet result = Agente.getAgente().select("SELECT * FROM ESTADISTICAS WHERE version = 1");
		result.next();
		medias[0] = result.getDouble(EstadosMesas.LIBRE.name());
		medias[1] = result.getDouble(EstadosMesas.RESERVADA.name());
		medias[2] = result.getDouble(EstadosMesas.OCUPADA.name());
		medias[3] = result.getDouble(EstadosMesas.PIDIENDO.name());
		medias[4] = result.getDouble(EstadosMesas.ESPERANDOCOMIDA.name());
		medias[5] = result.getDouble(EstadosMesas.SERVIDOS.name());
		medias[6] = result.getDouble(EstadosMesas.ESPERANDOCUENTA.name());
		medias[7] = result.getDouble(EstadosMesas.PAGANDO.name());
		medias[8] = result.getDouble(EstadosMesas.ENPREPARACION.name());

		return medias;

	}

	/**
	 * Recupera de la base de datos el numero total de mesas atendidas
	 * 
	 * @return devuelve el numero de mesas
	 * @throws SQLException excepcion que salta si no estamos conectados a la BBDD
	 */
	public int obtenerNMesas() throws SQLException {
		int nMesas;
		ResultSet result = Agente.getAgente().select("SELECT NMesas FROM ESTADISTICAS WHERE version = 1");
		result.next();
		nMesas = result.getInt("NMesas");
		return nMesas;
	}

	/**
	 * Acutaliza el tiempo de cada estado y el numero de mesas atentidas en la base
	 * de datos
	 * 
	 * @param vectorTiemposMediosTotales vector de tiempos medios totales
	 * @param nMesas numero de mesas
	 * @return entero
	 * @throws SQLException excepcion que salta si no estamos conectados a la BBDD
	 */
	public int anyadirTiemposMedios(double[] vectorTiemposMediosTotales, int nMesas) throws SQLException {
		return Agente.getAgente()
				.update("UPDATE ESTADISTICAS SET NMesas = " + nMesas + ", " + EstadosMesas.LIBRE.name() + " = "
						+ vectorTiemposMediosTotales[0] + ", " + EstadosMesas.RESERVADA.name() + "= "
						+ vectorTiemposMediosTotales[1] + ", " + EstadosMesas.OCUPADA.name() + "="
						+ vectorTiemposMediosTotales[2] + ", " + EstadosMesas.PIDIENDO.name() + "="
						+ vectorTiemposMediosTotales[3] + ", " + EstadosMesas.ESPERANDOCOMIDA.name() + "="
						+ vectorTiemposMediosTotales[4] + ", " + EstadosMesas.SERVIDOS.name() + "="
						+ vectorTiemposMediosTotales[5] + "," + EstadosMesas.ESPERANDOCUENTA.name() + "="
						+ vectorTiemposMediosTotales[6] + ", " + EstadosMesas.PAGANDO.name() + "="
						+ vectorTiemposMediosTotales[7] + ", " + EstadosMesas.ENPREPARACION.name() + " ="
						+ vectorTiemposMediosTotales[8] + " WHERE version = 1;");
	}

}