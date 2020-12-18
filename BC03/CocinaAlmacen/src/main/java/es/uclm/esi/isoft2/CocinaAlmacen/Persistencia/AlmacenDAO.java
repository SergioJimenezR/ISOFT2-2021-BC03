package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Clase DAO intermediaria entre la clase Almacen y el Agente, que ayuda a
 * realizar acciones relacionadas con el Almacen en la base de datos por medio
 * del Agente.
 * 
 * @author BC03
 *
 */

public class AlmacenDAO implements Constantes {

	/**
	 * Metodo que realiza una lectura de los platos del estado actual de la base de
	 * datos.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static int[] leerStockPlatos() throws SQLException {

		int[] stockIngredientesPlatos = new int[Constantes.NOMBRES_INGREDIENTES.length];

		String instruccion = "SELECT * FROM STOCK_PLATOS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		while (RS.next())
			stockIngredientesPlatos[RS.getInt("id")] = RS.getInt("cantidad");

		return stockIngredientesPlatos;
	}

	/**
	 * Metodo que realiza una lectura de las bebidas del estado actual de la base de
	 * datos.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static int[] leerStockBebidas() throws SQLException {
		int[] stockBebidas = new int[Constantes.NOMBRES_BEBIDAS.length];

		String instruccion = "SELECT * FROM STOCK_BEBIDAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		while (RS.next())
			stockBebidas[RS.getInt("id")] = RS.getInt("cantidad");

		return stockBebidas;
	}

	/**
	 * Metodo que actualiza el stock de los platos del Almacen sobre la base de
	 * datos (boton Guardar).
	 * 
	 * @param stockPlatos
	 * @throws SQLException
	 */
	public static void actualizarStockPlatos(int[] stockPlatos) throws SQLException {
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().update(instruccion);
		}
	}

	/**
	 * Metodo que actualiza el stock de las bebidas del Almacen sobre la base de
	 * datos (boton Guardar).
	 * 
	 * @param stockBebidas
	 * @throws SQLException
	 */
	public static void actualizarStockBebidas(int[] stockBebidas) throws SQLException {
		for (int i = 0; i < stockBebidas.length; i++) {
			String instruccion = "UPDATE STOCK_BEBIDAS SET cantidad = " + stockBebidas[i] + " WHERE (id = '" + i
					+ "');";
			Agente.getAgente().update(instruccion);
		}
	}

}
