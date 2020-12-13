package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgenteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAgente() throws Exception {
		Agente.getAgente();
	}

	@Test
	public void testCreate() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testInsert() throws Exception {
		int [] stockPlatos = {1000, 1000, 1000};
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().insert(instruccion);
		}
	}

	@Test
	public void testDelete() throws Exception {
		int [] stockPlatos = {1000, 1000, 1000};
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().delete(instruccion);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		int [] stockPlatos = {1000, 1000, 1000};
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().update(instruccion);
		}
	}

	@Test
	public void testEjecutar() throws Exception {
		int [] stockPlatos = {1000, 1000, 1000};
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().ejecutar(instruccion);
		}
	}

	@Test
	public void testSelect() throws Exception {
		String instruccion = "SELECT * FROM STOCK_BEBIDAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
	}
}
