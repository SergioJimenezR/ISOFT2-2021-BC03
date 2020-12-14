package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IU_CamareroMesaTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
		//IU_CamareroMesa.getInterfaz().obtenerArrayListBebida(null);
	}

	@Test
	public void testObtenerArrayListPlato() throws Exception {
		//IU_CamareroMesa.getInterfaz().obtenerArrayListPlato(null);
	}

	@Test
	public void testLimpiarAnotacionComanda() throws Exception {
		IU_CamareroMesa.getInterfaz().limpiarAnotacionComanda();
	}

	@Test
	public void testEnlistarComanda() throws Exception {
		//IU_CamareroMesa.getInterfaz().enlistarComanda(null);
	}

	@Test
	public void testIniciarTimer() throws Exception {
		//IU_CamareroMesa.getInterfaz().iniciarTimer(null);
	}

	@Test
	public void testAñadirAviso() throws Exception {
	//	IU_CamareroMesa.getInterfaz().añadirAviso(null);
	}

	@Test
	public void testRellenarCbMesas() throws Exception {
		IU_CamareroMesa.getInterfaz().rellenarCbMesas();
	}

}
