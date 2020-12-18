package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDAO {
	
	/**
	 * Actualiza el estado de una mesa en la base de datos
	 * @param id
	 * @param estado
	 * @param dni
	 * @throws SQLException
	 */
	public static void actualizarNumMesa(int id, String estado, String dni) throws SQLException {
		String instruccion = "UPDATE MESAS SET estado = '" + estado + "', dni = '" + dni + "' WHERE (id = '" + id
				+ "');";
		Agente.getAgente().update(instruccion);
	}

	/**
	 * Lee en la base de datos las mesas que estan en estado "Libre" y devuelve
	 * sus id
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Integer> consultarMesasDisponibles() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();

		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);

		while (RS.next())
			if (RS.getString("estado").equals("LIBRE")) {
				listIdMesas.add(RS.getInt("id"));
			}

		return listIdMesas;
	}
	
	/**
	 * Lee en la base de datos las mesas que estan en estado "Ocupada" y devuelve
	 * sus id
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Integer> consultarMesasOcupadas() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();
		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);

		while (RS.next())
			if (RS.getString("estado").equals("OCUPADA")) {
				listIdMesas.add(RS.getInt("id"));
			}
		return listIdMesas;
	}

	/**
	 * Lee en la base de datos las mesas que estan en estado "Reservada" y devuelve
	 * sus id
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Integer> consultarMesasReservadas() throws SQLException {
		ArrayList<Integer> listIdMesas = new ArrayList<>();
		String instruccion = "SELECT * FROM MESAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);

		while (RS.next())
			if (RS.getString("estado").equals("RESERVADA")) {
				listIdMesas.add(RS.getInt("id"));
			}
		return listIdMesas;
	}

	/**
	 * Lee el DNI asignado a la mesa con el id indicado
	 * @param id: atributo id de la mesa
	 * @return
	 * @throws SQLException
	 */
	public static String devolverDni(int id) throws SQLException {
		String instruccion = "SELECT * FROM MESAS WHERE (id = '" + id + "');";
		ResultSet RS = Agente.getAgente().select(instruccion);
		String dni = "";
		while (RS.next())
			if (RS.getString("estado").equals("RESERVADA")) {
				dni = RS.getString("dni");
			}
		return dni;
	}
}
