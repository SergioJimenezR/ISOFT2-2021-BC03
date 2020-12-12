package es.uclm.esi.isoft2.PedidosComandas.Modulo1Test;

import static org.junit.Assert.*;
import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Almacen;


public class AlmacenTest {
	Almacen almacen;
	@Test
	public void testAumentarStockPlatos() {
		int[] ingredientesPlato=null; 
		try {
			almacen.aumentarStockPlatos(ingredientesPlato);
		} catch(NullPointerException e) {
			assertArrayEquals("NULL EXCEPTION",ingredientesPlato,null);
		}
		
		
	}
	
	@Test
	public void testComprobarStockPlatos() {
		int[] ingredientesPlato=null; 
		try {
			almacen.comprobarStockPlatos(ingredientesPlato);
		} catch(NullPointerException e) {
			assertArrayEquals("NULL EXCEPTION",ingredientesPlato,null);
		}
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
		String nombreBebida= null;
		try {
			almacen.comprobarStockBebidas(nombreBebida);
		} catch(NullPointerException e) {
			assertEquals("NULL EXCEPTION",nombreBebida,null);
		}
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
	
	
}
