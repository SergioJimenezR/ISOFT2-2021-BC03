package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import org.junit.Test;

public class AgenteTest {

	@Test
	public void testGetAgente() throws Exception {
		Agente.getAgente();
	}

	@Test
	public void testUpdate() throws Exception {
		int[] stockPlatos = { 1000, 1000, 1000 };
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().update(instruccion);
		}
	}

	@Test
	public void testSelect() throws Exception {
		String instruccion = "SELECT * FROM STOCK_BEBIDAS;";
		Agente.getAgente().select(instruccion);
	}
}
