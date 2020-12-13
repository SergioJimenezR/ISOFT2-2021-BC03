package es.uclm.esi.isoft2.PedidosComandas.Modulo1Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;

public class AlmacenTest {
	Almacen almacen = new Almacen();
	@Test
	public void testAumentarStockPlatos() {
		int[] ingredientesPlato=null; 
		try {
			almacen.aumentarStockPlatos(ingredientesPlato);
		} catch(NullPointerException e) {
			assertArrayEquals("NULL EXCEPTION",ingredientesPlato,null);
		}
		almacen.getAlmacen();
		almacen.primeraLectura();
		int[] ingredientesPlato1 = {900, 0, 0};
		almacen.aumentarStockPlatos(ingredientesPlato1);
	}
	
	@Test
	public void testComprobarStockPlatos() {
		int[] ingredientesPlato=null; 
		try {
			almacen.comprobarStockPlatos(ingredientesPlato);
		} catch(NullPointerException e) {
			assertArrayEquals("NULL EXCEPTION",ingredientesPlato,null);
		}
		int[] ingredientesPlato1 = {900, 0, 0};
		almacen.comprobarStockPlatos(ingredientesPlato1);
	}
	
	@Test
	public void testReducirStockPlatos() {
		int[] ingredientesPlato=null; 
		try {
			almacen.reducirStockPlatos(ingredientesPlato);
		} catch(NullPointerException e) {
			assertArrayEquals("NULL EXCEPTION",ingredientesPlato,null);
		}
	}
	
	@Test
	public void testAumentarStockBebidas() {
		String nombreBebida= null;
		try {
			almacen.aumentarStockBebidas(nombreBebida);
		} catch(NullPointerException e) {
			assertEquals("NULL EXCEPTION",nombreBebida,null);
		}
	}
	
	@Test
	public void testComprobarStockBebidas() {
		almacen.getAlmacen();
		almacen.primeraLectura();
		String nombreBebida= null;
		try {
			almacen.comprobarStockBebidas(nombreBebida);
		} catch(NullPointerException e) {
			assertEquals("NULL EXCEPTION",nombreBebida,null);
		}
		String nombreB = "Bebida1";
		almacen.comprobarStockBebidas(nombreB);
		for (int i = 0; i < 50; i++) {
			almacen.reducirStockBebidas(nombreB);
		}
		almacen.comprobarStockBebidas(nombreB);
	}
	
	@Test
	public void testReducirStockBebidas() {
		String nombreBebida= null;
		try {
			almacen.reducirStockBebidas(nombreBebida);
		} catch(NullPointerException e) {
			assertEquals("NULL EXCEPTION",nombreBebida,null);
		}
	}
	
	@Test
	public void testactualizacionBD() {
		almacen.actualizacionBD();
	}
	
	@Test
	public void testPrimeraLectura() {
		almacen.primeraLectura();
	}
	
	@Test
	public void testAumentarStock() {
		Comanda c = new Comanda(0, null, null, null, null, null, null);
		Almacen.getAlmacen();
		almacen.primeraLectura();
		
		try {
			almacen.aumentarStock(c);
		} catch (NullPointerException e) {
			assertEquals("NULL EXCEPTION",c.getBebidas(), null);
		}	
		
		Bebida b = new Bebida(1, "Bebida1");
		Plato p = new Plato(1, "Entrante1");
		Plato p1 = new Plato(1, "Primero1");
		Plato p2 = new Plato(1, "Segundo1");
		Plato p3 = new Plato(1, "Postre1");
		ArrayList<Bebida> arrayListBebidas = new ArrayList<Bebida>();
		arrayListBebidas.add(b);
		ArrayList<Plato> arrayListEntrantes = new ArrayList<Plato>();
		arrayListEntrantes.add(p);
		ArrayList<Plato> arrayListPrimeros = new ArrayList<Plato>();
		arrayListPrimeros.add(p1);
		ArrayList<Plato> arrayListSegundos = new ArrayList<Plato>();
		arrayListSegundos.add(p2);
		ArrayList<Plato> arrayListPostres = new ArrayList<Plato>();
		arrayListPostres.add(p3);
		Mesa m = new Mesa(5);
		
		Comanda c1 = new Comanda(1, m, arrayListBebidas, arrayListEntrantes, arrayListPrimeros, arrayListSegundos, arrayListPostres);
		almacen.aumentarStock(c1);
	}
	
	@Test
	public void testcomprobarUmbralIngredientes() {
		almacen.getAlmacen();
		almacen.primeraLectura();
		almacen.comprobarUmbralIngredientes();
		int[] ingredientesPlato = {900, 100, 100};
		almacen.reducirStockPlatos(ingredientesPlato);
		almacen.comprobarUmbralIngredientes();
	}
	
	@Test
	public void testcomprobarUmbralBebidas() {
		almacen.getAlmacen();
		almacen.primeraLectura();
		almacen.comprobarUmbralBebidas();
		String nombreBebida = "Bebida1";
		for (int i = 0; i < 46; i++) {
			almacen.reducirStockBebidas(nombreBebida);
		}
		almacen.comprobarUmbralBebidas();
	}
	
	@Test
	public void testReponerStock() {	
		almacen.reponerStocks();
	}
	
	@Test
	public void testToStringStockBebidas() {
		almacen.toStringStockBebidas();
	}
	
	@Test
	public void testToStringStockPlatos() {
		almacen.toStringStockPlatos();
	}
}
