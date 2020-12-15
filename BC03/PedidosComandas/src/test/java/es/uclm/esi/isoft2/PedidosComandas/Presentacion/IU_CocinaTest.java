package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import org.junit.Test;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

public class IU_CocinaTest {

	@Test
	public void testGetInterfaz() throws Exception {
		IU_Cocina window = IU_Cocina.getInterfaz();
	}

	@Test
	public void testEnlistarComanda() throws Exception {
		IU_Cocina window = IU_Cocina.getInterfaz();
		Mesa m = new Mesa(8);
		Comanda c = new Comanda(0, m, null, null, null, null, null);
		window.enlistarComanda(c);
	}

}
