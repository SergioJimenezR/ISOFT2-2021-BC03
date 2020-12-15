package es.uclm.esi.isoft2.PedidosComandas.Presentacion;

import javax.swing.JFrame;

import org.junit.Test;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Comanda;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

public class IU_CamareroBarraTest {

	@Test
	public void testGetInterfaz() throws Exception {
		IU_CamareroBarra window = IU_CamareroBarra.getInterfaz();
	}

	@Test
	public void testIU_CamareroBarra() throws Exception {
		JFrame window = new IU_CamareroBarra();
	}

	@Test
	public void testEnlistarComanda() throws Exception {
		JFrame window = new IU_CamareroBarra();
		Mesa m = new Mesa(8);
		Comanda c = new Comanda(0, m, null, null, null, null, null);
		((IU_CamareroBarra) window).enlistarComanda(c);
	}

}
