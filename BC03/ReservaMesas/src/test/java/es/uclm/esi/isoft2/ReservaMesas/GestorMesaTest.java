package es.uclm.esi.isoft2.ReservaMesas;

import static org.junit.Assert.*;

import java.sql.SQLException;

import es.uclm.esi.isoft2.ReservaMesas.Dominio.*;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.*;
import org.junit.Test;

public class GestorMesaTest {
	GestorMesa gmesa = new GestorMesa();
	MesaDAO mdao;
	int idMesa;
	String dniCliente=null;
	String estado= null;
	@Test
	public void testCambiarEstadoOcupadoNull() {
		try {
			gmesa.cambiarEstadoOcupado(idMesa, dniCliente); 
		}catch(NullPointerException | SQLException e){
			assertNull("NULL EXCEPTION",dniCliente);
		}
	}

		@Test
		public void testCancelarMesaIdMesa() {
			try {
				gmesa.cancelarMesa(idMesa); 
			}catch(NullPointerException | SQLException e){
				assertTrue("NO INITIALIZATE EXCEPTION",idMesa==0);
			}
		}
		
		@Test
		public void testActualizarMesaNull() {
			try {
				gmesa.actualizarMesa(idMesa,estado,dniCliente); 
			}catch(NullPointerException | SQLException e){
				assertNull("NULL EXCEPTION",estado);
			}
		}
		
}
