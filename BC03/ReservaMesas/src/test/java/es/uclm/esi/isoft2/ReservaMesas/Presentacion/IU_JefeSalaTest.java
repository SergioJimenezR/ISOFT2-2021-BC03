package es.uclm.esi.isoft2.ReservaMesas.Presentacion;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;

public class IU_JefeSalaTest {

	@Test
	public void testIU_JefeSala() throws Exception {
		JFrame window = new IU_JefeSala();
	}

	@Test
	public void testGetComboBoxReservadas() throws Exception {
		JFrame window = new IU_JefeSala();
		assertNotNull(((IU_JefeSala) window).getComboBoxReservadas());
	}

	@Test
	public void testSetComboBoxReservadas() throws Exception {
		JFrame window = new IU_JefeSala();
		((IU_JefeSala) window).setComboBoxReservadas(null);
	}

}
