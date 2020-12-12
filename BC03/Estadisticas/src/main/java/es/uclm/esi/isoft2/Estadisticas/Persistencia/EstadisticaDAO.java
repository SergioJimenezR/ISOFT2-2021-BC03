package es.uclm.esi.isoft2.Estadisticas.Persistencia;

import java.sql.SQLException;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Agente;

public class EstadisticaDAO {
	

	
	/*public double[] leerTiemposMedios() {
		
	}*/
	
	public double[] obtenerMedias() throws SQLException {
		double[] medias = null;
		Agente.getAgente().select("SELECT * FROM ESTADISTICAS WHERE Version = 1");
		
		return medias;
	}
	
	public int anyadirTiemposMedios(double[] vectorTiemposMediosTotales) throws SQLException {
		return Agente.getAgente().update("UPDATE ESTADISTICAS SET Libre = "+ vectorTiemposMediosTotales[0] +", Reservada= "+ vectorTiemposMediosTotales[1] +", Ocupada="+ vectorTiemposMediosTotales[2] +", Pidiendo="+ vectorTiemposMediosTotales[3] +", EsperandoComida="+ vectorTiemposMediosTotales[4] +", Servidos="+ vectorTiemposMediosTotales[5] +", EsperandoCuenta="+ vectorTiemposMediosTotales[6] +", Paganado="+ vectorTiemposMediosTotales[7] +", Ensuciada ="+ vectorTiemposMediosTotales[8]+";");
	}

}