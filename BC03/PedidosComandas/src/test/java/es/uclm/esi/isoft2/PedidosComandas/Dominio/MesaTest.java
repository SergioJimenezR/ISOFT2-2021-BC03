package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

public class MesaTest {
	Mesa mesa;
	Comanda comanda;

	@Test
	public void testIdNegativoMesa() {
		mesa = new Mesa(-2);
		int id = mesa.getId();
		assertFalse("NEGATIVE EXCEPTION", id > 0);
	}

	@Test
	public void testEstadoMesaOtro() {
		boolean contenido = false;
		EstadosMesas[] estados = new EstadosMesas[10];
		EstadosMesas estado = null;
		mesa = new Mesa(2);
		mesa.setEstadoMesa(estado);
		for (int i = 0; i < 9; i++) {
			estados[i] = EstadosMesas.values()[i];
			System.out.println(estados[i]);
			if (estados[i] == mesa.getEstadoMesa()) {
				contenido = true;
			}
		}
		assertFalse("NOT FOUND EXCEPTION", contenido);
		estado = estado.ENPREPARACION;
		Mesa mesa2 = new Mesa(2, estado);
		comanda = new Comanda(2, mesa2, null, null, null, null, null);
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
		assertTrue(mesa.modificarDatosReservado(mesa.getDni(), fecha));
	}

	@Test
	public void testActualizarTiempos() throws Exception {
		Mesa m1 = new Mesa(3, EstadosMesas.LIBRE);
		m1.setEstadoMesa(EstadosMesas.RESERVADA);
		m1.setEstadoMesa(EstadosMesas.OCUPADA);
		m1.setEstadoMesa(EstadosMesas.PIDIENDO);
		m1.setEstadoMesa(EstadosMesas.ESPERANDOCOMIDA);
		m1.setEstadoMesa(EstadosMesas.SERVIDOS);
		m1.setEstadoMesa(EstadosMesas.ESPERANDOCUENTA);
		m1.setEstadoMesa(EstadosMesas.PAGANDO);
		m1.setEstadoMesa(EstadosMesas.ENPREPARACION);
		m1.setEstadoMesa(EstadosMesas.LIBRE);
	}

	@Test
	public void testToString() throws Exception {
		Mesa m = new Mesa(3, EstadosMesas.LIBRE);
		assertNotNull(m.toString());
	}

	@Test
	public void testTodosEstadosRecorridos() throws Exception {
		Mesa m = new Mesa(3, EstadosMesas.LIBRE);
		assertTrue("Debe ser True",m.todosEstadosRecorridos());
	}

	@Test
	public void testGetVectorTiempos() throws Exception {
		Mesa m = new Mesa(3, EstadosMesas.LIBRE);
		assertNotNull(m.getVectorTiempos());
	}

	@Test
	public void testSetNumComensales() throws Exception {
		Mesa m1 = new Mesa(2, EstadosMesas.LIBRE);
		Mesa m2 = new Mesa(4, EstadosMesas.LIBRE);
		Mesa m3 = new Mesa(6, EstadosMesas.LIBRE);
	}

}
