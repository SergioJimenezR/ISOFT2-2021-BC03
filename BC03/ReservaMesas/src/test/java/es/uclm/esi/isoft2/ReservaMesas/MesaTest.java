package es.uclm.esi.isoft2.ReservaMesas;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.PedidosComandas.Dominio.Mesa;

import org.junit.Test;

public class MesaTest {
	Mesa m;
	String dniCliente=null;
	Date fecha;
	
	@Test
	public void testModificarDatosReservadoNull() {
		try {
			m.modificarDatosReservado(dniCliente, fecha); 
		}catch(NullPointerException e){
			assertNull("NULL EXCEPTION",dniCliente);
			assertNull("NULL EXCEPTION",fecha);
		}
	}
}
