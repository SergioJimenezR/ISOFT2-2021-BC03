package es.uclm.esi.isoft2.PedidosComandas.Modulo1Test;

import static org.junit.Assert.*;

import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

public class BebidaTest {
	Bebida bebida;
	
	@Test
	public void testIdNegativoBebida() {
		bebida= new Bebida(-2,"PRUEBA");
		int id= bebida.getId();
		assertFalse("NEGATIVE EXCEPTION",id>0);
	}
	@Test
	public void testNombreBebidaOtro() {
		boolean contenido=false;
		String[] vectorNomBebidas= new String[5];
		bebida= new Bebida(2,"Bebida7");
		for(int i=0;i<vectorNomBebidas.length;i++) {
			if(Constantes.NOMBRES_BEBIDAS[i].contains(bebida.getNombre()))
			{
				contenido=true;
			}
		}
		assertFalse("NOT FOUND EXCEPTION",contenido);
		bebida.toString();
	}
	
	@Test
	public void testBebidaNull() {
		try {
			bebida.getId();
		} catch(NullPointerException e) {
			assertNull("NULL EXCEPTION",bebida);
		}
	}
	
	@Test
	public void reducirIdTest() {
		bebida= new Bebida(1,"Bebida7");
		bebida.reducirId();
		assertFalse("NEGATIVE EXCEPTION",bebida.getId()>0);
	}
	
}
