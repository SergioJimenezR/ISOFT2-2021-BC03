package es.uclm.esi.isoft2.ReservaMesas.Presentacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class IU_JefeSalaTest {

	@Test
	public void testIU_JefeSala() throws Exception {
		IU_JefeSala.getInterfaz();
	}

	@Test
	public void testGetComboBoxReservadas() throws Exception {
		assertNull(IU_JefeSala.getInterfaz().getComboBoxReservadas());
	}

	@Test
	public void testSetComboBoxReservadas() throws Exception {
		IU_JefeSala.getInterfaz().setComboBoxReservadas(null);
	}

}
