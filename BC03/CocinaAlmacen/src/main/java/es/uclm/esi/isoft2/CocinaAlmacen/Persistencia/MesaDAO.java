package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {

	public static void addMesa (int id, String estado)  throws SQLException {
		//String instruccion = "INSERT MESAS WHERE (id = '" + id + "');";
		//Agente.getAgente().insert(instruccion);
	}
	
	public static void eliminarMesa(int id, String estado) throws SQLException {
		String instruccion = "DELETE MESAS WHERE (id = '" + id + "');";
		Agente.getAgente().delete(instruccion);
	}
	
	public static void actualizarNumMesa(int id, String estado) throws SQLException {
		String instruccion = "UPDATE MESAS SET estado = " + estado + " WHERE (id = '" + id + "');";
		Agente.getAgente().update(instruccion);
	}
	
	public static ArrayList<Integer> consultarMesasDisponibles() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();

		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		
		while (RS.next())
			if(RS.getString("estado").equals("LIBRE")) {
				listIdMesas.add(RS.getInt("id"));
			}
		
		return listIdMesas;
	}
	
	public static ArrayList<Integer> consultarMesasOcupadas() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();
		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		
		while (RS.next())
			if(RS.getString("estado").equals("OCUPADA")) {
				listIdMesas.add(RS.getInt("id"));
			}
		return listIdMesas;
	}
	
	public static ArrayList<Integer> consultarMesasReservadas() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();
		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		
		while (RS.next())
			if(RS.getString("estado").equals("RESERVADA")) {
				listIdMesas.add(RS.getInt("id"));
			}
		return listIdMesas;
	}
	
}
