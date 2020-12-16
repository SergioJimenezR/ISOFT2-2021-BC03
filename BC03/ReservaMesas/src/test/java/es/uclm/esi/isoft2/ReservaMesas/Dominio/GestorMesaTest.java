package es.uclm.esi.isoft2.ReservaMesas.Dominio;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.swing.JComboBox;

import es.uclm.esi.isoft2.ReservaMesas.Presentacion.IU_JefeSala;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.*;
import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

import org.junit.Test;

public class GestorMesaTest {
	GestorMesa gmesa = new GestorMesa();
	MesaDAO mdao = new MesaDAO();
	int idMesa;
	String dniCliente = null;
	String estado = null;

	@Test
	public void testCambiarEstadoOcupadoNull() throws SQLException {
		try {
			gmesa.cambiarEstadoOcupado(idMesa, dniCliente);
		} catch (NullPointerException e) {
			assertNull("NULL EXCEPTION", dniCliente);
		}
	}

	@Test
	public void testCancelarMesaIdMesa() throws SQLException {
		try {
			gmesa.cancelarMesa(idMesa);
		} catch (NullPointerException | SQLException e) {
			assertTrue("NO INITIALIZATE EXCEPTION", idMesa == 0);
		}
		idMesa = 2;
		JComboBox<Mesa> cBMesas = new JComboBox<Mesa>();
		Mesa m = new Mesa(3);
		IU_JefeSala.setComboBoxReservadas(cBMesas);
		cBMesas.addItem(m);
		assertFalse(gmesa.cancelarMesa(idMesa));
		assertTrue(gmesa.cancelarMesa(idMesa + 1));
		String dni = mdao.devolverDni(6);
		gmesa.cambiarEstadoOcupado(3, dni);
	}

	@Test
	public void testActualizarMesaNull() throws SQLException {
		try {
			gmesa.actualizarMesa(idMesa, estado, dniCliente);
		} catch (NullPointerException e) {
			assertNull("NULL EXCEPTION", estado);
		}
	}

}
