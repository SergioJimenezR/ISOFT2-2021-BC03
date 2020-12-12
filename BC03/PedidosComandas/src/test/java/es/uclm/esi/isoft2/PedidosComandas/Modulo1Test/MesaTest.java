package es.uclm.esi.isoft2.PedidosComandas.Modulo1Test;

import static org.junit.Assert.*;

import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

public class MesaTest {
	Mesa mesa;

	@Test
	public void testIdNegativoMesa() {
		mesa= new Mesa(-2);
		int id= mesa.getId();
		assertFalse("NEGATIVE EXCEPTION",id>0);
	}
	
	
	@Test
	public void testEstadoMesaOtro() {
		boolean contenido=false;
		EstadosMesas[] estados=new EstadosMesas[10];
		EstadosMesas estado= null;
		mesa= new Mesa(2);
		mesa.setEstadoMesa(estado);
		for(int i=0;i<9;i++) {
			estados[i]= EstadosMesas.values()[i];
			System.out.println(estados[i]);
			if(estados[i]==mesa.getEstadoMesa())
		{
				contenido=true;
			}
		}
		assertFalse("NOT FOUND EXCEPTION",contenido);
	}
	
}
