package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.AlmacenDAO;
import es.uclm.esi.isoft2.PedidosComandas.Presentacion.Constantes;

public class Almacen {

	private static int[] stockPlatos;
	private static int[] stockBebidas;

	public static void primeraLectura() throws SQLException {
		stockPlatos = AlmacenDAO.leerStockPlatos();
		stockBebidas = AlmacenDAO.leerStockBebidas();
	}

	public static void actualizacionBD() {
		try {
			AlmacenDAO.actualizarStockPlatos(stockPlatos);
			AlmacenDAO.actualizarStockBebidas(stockBebidas);
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al actualizar la base de datos. "
					+ "Posible fallo de la VPN o caída del servicio.\n" + e.getMessage());
		}
	}

	public static void aumentarStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] += ingredientesPlato[i];
	}

	public static boolean comprobarStockPlatos(int[] ingredientesPlato) {
		boolean supuesto = true;
		for (int i = 0; i < stockPlatos.length && supuesto; i++)
			if (stockPlatos[i] < ingredientesPlato[i])
				supuesto = false;
		return supuesto;
	}

	public static void reducirStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] -= ingredientesPlato[i];
	}

	public static void aumentarStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]++;
				encontrado = true;
			}
	}

	public static boolean comprobarStockBebidas(String nombreBebida) {
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length; i++) {
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				if (stockBebidas[i] > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static void reducirStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]--;
				encontrado = true;
			}
	}

	public static void aumentarStock(Comanda c) {
		ArrayList<Plato> listaPlatos = null;
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				listaPlatos = c.getEntrantes();
				break;
			case 1:
				listaPlatos = c.getPrimeros();
				break;
			case 2:
				listaPlatos = c.getSegundos();
				break;
			case 3:
				listaPlatos = c.getPostres();
				break;
			}
			for (int j = 0; j < listaPlatos.size(); j++) {
				aumentarStockPlatos(listaPlatos.get(j).getIngredientes());
			}
		}

		ArrayList<Bebida> listaBebidas = c.getBebidas();
		for (int i = 0; i < listaBebidas.size(); i++) {
			aumentarStockBebidas(listaBebidas.get(i).getNombre());
		}
	}

	public static void reponerStocks() {

		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] = 1000;
		for (int i = 0; i < stockBebidas.length; i++)
			stockBebidas[i] = 50;

		actualizacionBD();

	}

	public static String toStringStockPlatos() {
		String cadena = "";
		for (int i = 0; i < stockPlatos.length - 1; i++)
			cadena += stockPlatos[i] + ", ";
		return cadena + stockPlatos[stockPlatos.length - 1];
	}

	public static String toStringStockBebidas() {
		String cadena = "";
		for (int i = 0; i < stockBebidas.length - 1; i++)
			cadena += stockBebidas[i] + ", ";
		return cadena + stockBebidas[stockBebidas.length - 1];
	}

}
