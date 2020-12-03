package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AlmacenDAO  {

	public static int[] leerStockPlatos() throws SQLException {

		int[] stockIngredientesPlatos = new int[3];

		String instruccion = "SELECT * FROM STOCK_PLATOS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		while (RS.next()) {
			stockIngredientesPlatos[RS.getInt("id")] = RS.getInt("cantidad");
		}

		return stockIngredientesPlatos;
	}

	public static int[] leerStockBebidas() throws SQLException {
		int[] stockBebidas = new int[5];

		String instruccion = "SELECT * FROM STOCK_BEBIDAS;";
		ResultSet RS = Agente.getAgente().select(instruccion);
		while (RS.next()) {
			stockBebidas[RS.getInt("id")] = RS.getInt("cantidad");
		}

		return stockBebidas;
	}

	public static void actualizarStockPlatos(int[] stockPlatos) throws SQLException {
		for (int i = 0; i < stockPlatos.length; i++) {
			String instruccion = "UPDATE STOCK_PLATOS SET cantidad = " + stockPlatos[i] + " WHERE (id = '" + i + "');";
			Agente.getAgente().update(instruccion);
		}
	}

	public static void actualizarStockBebidas(int[] stockBebidas) throws SQLException {
		for (int i = 0; i < stockBebidas.length; i++) {
			String instruccion = "UPDATE STOCK_BEBIDAS SET cantidad = " + stockBebidas[i] + " WHERE (id = '" + i
					+ "');";
			Agente.getAgente().update(instruccion);
		}
	}

}
