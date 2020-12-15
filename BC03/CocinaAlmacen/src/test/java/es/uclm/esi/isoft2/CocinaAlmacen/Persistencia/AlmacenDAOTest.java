package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlmacenDAOTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLeerStockPlatos() throws Exception {
		AlmacenDAO.leerStockPlatos();
	}

	@Test
	public void testLeerStockBebidas() throws Exception {
		AlmacenDAO.leerStockBebidas();
		
	}

	@Test
	public void testActualizarStockPlatos() throws Exception {
		int [] stockPlatos = null;
		try {
			AlmacenDAO.actualizarStockPlatos(stockPlatos);
		}
		catch (NullPointerException ex) {
			assertArrayEquals("NULL EXCEPTION", stockPlatos, null);
		}
		int [] stockPlatos1 = {100, 0, 0};
		AlmacenDAO.actualizarStockPlatos(stockPlatos1);
	}

	@Test
	public void testActualizarStockBebidas() throws Exception {
		int [] stockBebidas = null;
		try {
			AlmacenDAO.actualizarStockBebidas(stockBebidas);
		}
		catch (NullPointerException ex) {
			assertArrayEquals("NULL EXCEPTION", stockBebidas, null);
		}
		int [] stockBebidas1 = {100, 0, 0};
		AlmacenDAO.actualizarStockBebidas(stockBebidas1);
	}

}
