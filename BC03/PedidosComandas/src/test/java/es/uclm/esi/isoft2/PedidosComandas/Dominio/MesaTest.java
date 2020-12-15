package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.EstadosMesas;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

public class MesaTest {
	Mesa mesa;
	Comanda comanda;

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
		estado= estado.ENPREPARACION;
		Mesa mesa2= new Mesa(2,estado);
		comanda= new Comanda(2, mesa2, null, null, null, null,
				null);
		Date fecha = new Date();
		mesa.setComanda(comanda);
		mesa.setPrecio(100);
		mesa.setDni("01234567A");
		mesa.setFecha(fecha);
		assertNotNull(mesa.getComanda());
		assertNotNull(mesa.getPrecio());
		assertNotNull(mesa.getDni());
		assertNotNull(mesa.getFecha());
		mesa.cerrarCuenta();
		assertTrue(mesa.modificarDatosReservado(mesa.getDni(),fecha));
	}
	
}
