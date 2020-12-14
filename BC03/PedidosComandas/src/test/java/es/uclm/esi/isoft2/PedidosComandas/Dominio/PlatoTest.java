package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import static org.junit.Assert.*;

import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;

public class PlatoTest {
	Plato plato;
	
	@Test
	public void testCalcularIngredientes() {
		int[] ingredientes = new int[200];
		plato= new Plato(2,"PRUEBA");
		ingredientes= plato.calcularIngredientes(null);
		assertNull("NULL EXCEPTION",ingredientes);
		
	}
	
	@Test
	public void testConseguirInfoPlato() {
		int[] ingredientes = new int[200];
		plato= new Plato(2,"PRUEBA");
		assertNotNull(plato.getNombre());
		for(int i=0;i<ingredientes.length;i++) {
			ingredientes[i]=100*i;
		}
		plato.setIngredientes(ingredientes);
		plato.getIngredientes();
		assertNotNull(plato.toString());
		assertNotNull(plato.toStringIngredientes());
	}
	@Test
	public void reducirIdTest() {
		plato= new Plato(1,"Plato");
		plato.reducirId();
		assertFalse("NEGATIVE EXCEPTION",plato.getId()>0);
	}
	
	@Test
	public void testIdNegativoPlato() {
		plato= new Plato(-2,"PRUEBA");
		int id= plato.getId();
		assertFalse("NEGATIVE EXCEPTION",id>0);
	}
}
