package es.uclm.esi.isoft2.Estadisticas.Persistencia;

import java.sql.SQLException;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Agente;

public class EstadisticaDAO {
	
	public void anyadirTiemposMedios() {
		
	}
	
	/*public double[] leerTiemposMedios() {
		
	}*/
	
	public double[] obtenerMedias() throws SQLException {
		double[] medias = null;
		Agente.getAgente();
		
		return medias;
	}

}
