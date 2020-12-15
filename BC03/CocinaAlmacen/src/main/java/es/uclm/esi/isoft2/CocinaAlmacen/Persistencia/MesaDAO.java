package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {
	
	public static void actualizarNumMesa(int id, String estado, String dni) throws SQLException {
		String instruccion = "UPDATE MESAS SET estado = '" + estado + "', dni = '" + dni + "' WHERE (id = '" + id + "');";
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
	
	public static String devolverDni(int id) throws SQLException {
		String instruccion = "SELECT * FROM MESAS WHERE (id = '" + id + "');";
		ResultSet RS = Agente.getAgente().select(instruccion);
		String dni = "";
		while (RS.next())
			if(RS.getString("estado").equals("RESERVADA")) {
				dni = RS.getString("dni");
			}
		return dni;
	}
}
