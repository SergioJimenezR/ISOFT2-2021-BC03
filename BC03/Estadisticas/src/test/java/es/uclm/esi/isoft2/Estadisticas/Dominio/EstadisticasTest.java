package es.uclm.esi.isoft2.Estadisticas.Dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

public class EstadisticasTest {


	@Test
	public void testEstadisticas() throws Exception {
		Estadisticas es = new Estadisticas();
	}

	@Test
	public void testGetVectorTiemposMediosTotales() throws Exception {
		Estadisticas es = new Estadisticas();
		es.getVectorTiemposMediosTotales();
	}

	@Test
	public void testEnviarTiemposMediosMesa() throws Exception {
		Mesa m = new Mesa(5);
		Estadisticas es = new Estadisticas();
		es.enviarTiemposMediosMesa(m);
		
	}

	@Test
	public void testEnviarTiemposPersistencia() throws Exception {
		Estadisticas es = new Estadisticas();
		es.enviarTiemposPersistencia();
	}

	@Test
	public void testGetTiemposEstadistica() throws Exception {
		Estadisticas es = new Estadisticas();
		assertFalse("STRING VACIO", (es.getTiemposEstadistica()).equals(""));
	}

}
