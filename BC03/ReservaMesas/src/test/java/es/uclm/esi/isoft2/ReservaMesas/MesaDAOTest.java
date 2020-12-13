package es.uclm.esi.isoft2.ReservaMesas;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.*;
import org.junit.Test;

public class MesaDAOTest {
	MesaDAO mdao;
	int idMesa;
	String dniCliente=null;
	String estado= null;
	
		@Test
		public void testActualizarNumMesaNull() {
			try {
				mdao.actualizarNumMesa(idMesa,estado,dniCliente); 
			}catch(NullPointerException | SQLException e){
				assertNull("NULL EXCEPTION",estado);
			}
		}
		
		@Test
		public void testActualizarNumMesaIdNotExists() {
			estado= "RESERVADA";
			idMesa= 100;
			try {
				mdao.actualizarNumMesa(idMesa,estado,dniCliente); 
			}catch(SQLException e){
				assertTrue("TOO BIG ID EXCEPTION",idMesa>6);
			}
		}
		
		@Test
		public void testActualizarNumMesaBBDDSQL() {
			ArrayList<Integer> listIdMesas = new ArrayList<>();
			try {
				listIdMesas=mdao.consultarMesasDisponibles(); 
			}catch(SQLException e){
				assertNull("SQL EXCEPTION",listIdMesas);
			}
		}
		
		@Test
		public void testConsultarMesasOcupadasBBDDSQL() {
			ArrayList<Integer> listIdMesas = new ArrayList<>();
			try {
				listIdMesas=mdao.consultarMesasOcupadas(); 
			}catch(SQLException e){
				assertNull("SQL EXCEPTION",listIdMesas);
			}
		}
		
		@Test
		public void testConsultarMesasReservadasBBDDSQL() {
			ArrayList<Integer> listIdMesas = new ArrayList<>();
			try {
				listIdMesas=mdao.consultarMesasReservadas(); 
			}catch(SQLException e){
				assertNull("SQL EXCEPTION",listIdMesas);
			}
		}
		
		@Test
		public void testDevolverDniBBDDSQL() {
			idMesa=2;
			try {
				dniCliente=mdao.devolverDni(idMesa); 
			}catch(SQLException e){
				assertNull("SQL EXCEPTION",dniCliente);
			}
		}
		
		@Test
		public void testDevolverDniNull() {
			try {
				dniCliente=mdao.devolverDni(idMesa); 
			}catch(SQLException | NullPointerException e){
				assertNull("NULL EXCEPTION",idMesa);
			}
		}
		
}
