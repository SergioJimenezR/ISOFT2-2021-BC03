package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import static org.junit.Assert.assertNotNull;

import javax.swing.JList;

import org.junit.Test;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Aviso;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Plato;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Bebida;

public class IU_CamareroMesaTest {

	@Test
	public void testGetInterfaz() throws Exception {
		IU_CamareroMesa.getInterfaz();
	}

	@Test
	public void testCrearComanda() throws Exception {
		IU_CamareroMesa.getInterfaz().crearComanda(0);
	}

	@Test
	public void testObtenerArrayListBebida() throws Exception {
		JList<Bebida> b = new JList<>();
		assertNotNull(IU_CamareroMesa.getInterfaz().obtenerArrayListBebida(b));
	}

	@Test
	public void testObtenerArrayListPlato() throws Exception {
		JList<Plato> c = new JList<>();
		assertNotNull(IU_CamareroMesa.getInterfaz().obtenerArrayListPlato(c));
	}

	@Test
	public void testLimpiarAnotacionComanda() throws Exception {
		IU_CamareroMesa.getInterfaz().limpiarAnotacionComanda();
	}

	@Test
	public void testEnlistarComanda() throws Exception {
		Mesa m = new Mesa(8);
		Comanda c = new Comanda(0, m, null, null, null, null, null);
		IU_CamareroMesa.getInterfaz().enlistarComanda(c);
	}

	@Test
	public void testIniciarTimer() throws Exception {
		Mesa m = new Mesa(13);
		Aviso a = new Aviso(0, m);
		IU_CamareroMesa.getInterfaz().iniciarTimer(a);
	}

	@Test
	public void testAnyadirAviso() throws Exception {
		Mesa m = new Mesa(13);
		Aviso a = new Aviso(0, m);
		IU_CamareroMesa.getInterfaz().anyadirAviso(a);
	}

	@Test
	public void testRellenarCbMesas() throws Exception {
		IU_CamareroMesa.getInterfaz().rellenarCbMesas();
	}

	@Test
	public void testGetMesaEstadisticas() throws Exception {
		IU_CamareroMesa.getInterfaz().getMesaEstadisticas();
	}

	@Test
	public void testRestartMesas() throws Exception {
		IU_CamareroMesa.getInterfaz().restartMesas();
	}

}
