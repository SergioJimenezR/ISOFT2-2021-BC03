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
	@Test
	public void testConstructor() {
		arrayListBebidas = new ArrayList<Bebida>();
		arrayListEntrantes= new ArrayList<Plato>();
		arrayListPrimeros = new ArrayList<Plato>();
		arrayListSegundos = new ArrayList<Plato>();
		arrayListPostres = new ArrayList<Plato>();
		bebida= new Bebida(2,"Nombre");
		plato = new Plato(2,"Nombre2");
		arrayListBebidas.add(bebida);
		arrayListEntrantes.add(plato);
		arrayListPrimeros.add(plato);
		arrayListSegundos.add(plato);
		arrayListPostres.add(plato);
		int id=1;
		Mesa m = new Mesa(2);
		comanda = new Comanda(id, m, arrayListBebidas, arrayListEntrantes, arrayListPrimeros, arrayListSegundos,
				arrayListPostres);
		assertNotNull(comanda.getBebidas());
		assertNotNull(comanda.getComida());
		assertNotNull(comanda.getEntrantes());
		assertNotNull(comanda.getPrimeros());
		assertNotNull(comanda.getSegundos());
		assertNotNull(comanda.getPostres());
		assertNotNull(comanda.toString());
		assertNotNull(comanda.toStringPlatos());
		assertNotNull(comanda.toStringBebidas());
		assertTrue(comanda.tieneBebidas());
		assertTrue(comanda.tienePlatos());
	}
	
}
