package es.uclm.esi.isoft2.PedidosComandas.Modulo1Test;

import static org.junit.Assert.*;

import java.util.ArrayList;



import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;

public class ComandaTest {
	Comanda comanda;
	Bebida bebida;
	Plato plato;

	static ArrayList<Bebida> arrayListBebidas;
	static ArrayList<Plato> arrayListEntrantes;
	static ArrayList<Plato> arrayListPrimeros;
	static ArrayList<Plato> arrayListSegundos;
	static ArrayList<Plato> arrayListPostres;

	
	@Test
	public void testComanda() {
		
		int id=1;
		Mesa m = new Mesa(2);
		try {
			comanda= new Comanda(id, m, arrayListBebidas, arrayListEntrantes, arrayListPrimeros, arrayListSegundos,
					arrayListPostres);
		}catch(NullPointerException e) {
			assertEquals("NULL EXCEPTION",comanda.getEntrantes().toString(),"["+null+"]");
		}
	}
	
	@Test
	public void testTieneBebidas() {

		try {
			comanda.tieneBebidas();
		}catch(NullPointerException e) {
			assertNull("NULL EXCEPTION",comanda);
		}
	}
	
	@Test
	public void testTienePlatos() {

		try {
			comanda.tienePlatos();
		}catch(NullPointerException e) {
			assertNull("NULL EXCEPTION",comanda);
		}
	}
	
}
