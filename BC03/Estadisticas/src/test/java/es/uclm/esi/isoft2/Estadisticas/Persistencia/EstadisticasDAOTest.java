package es.uclm.esi.isoft2.Estadisticas.Persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstadisticasDAOTest {

	private static EstadisticasDAO dao;
	
	@Test
	public void testObtenerMedias() throws Exception {
		dao = new EstadisticasDAO();
		dao.obtenerMedias();
	}

	@Test
	public void testObtenerNMesas() throws Exception {
		dao = new EstadisticasDAO();
		int n = dao.obtenerNMesas();
		assertFalse("NEGATIVE EXCEPTION", n < 0);
	}

	@Test
	public void testAnyadirTiemposMedios() throws Exception {
		double [] vector = new double [10];
		dao = new EstadisticasDAO();
		assertEquals("NO ES IGUAL A 1", dao.anyadirTiemposMedios(vector, 0), 1);
	}

}
