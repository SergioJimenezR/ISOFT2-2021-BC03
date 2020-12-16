package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.AlmacenDAO;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

public class Almacen implements Constantes {

	private static Almacen mInstancia = null;
	private int[] stockPlatos;
	private int[] stockBebidas;

	private Almacen() {
		primeraLectura();
	}

	public static Almacen getAlmacen() { // Patron Singleton
		if (mInstancia == null)
			mInstancia = new Almacen();
		return mInstancia;
	}

	public void primeraLectura() {
		try {
			stockPlatos = AlmacenDAO.leerStockPlatos();
			stockBebidas = AlmacenDAO.leerStockBebidas();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectarse con la base de datos. "
					+ "Posible fallo de la VPN o caida del servicio.\n" + e.getMessage());
			System.exit(1);
		}
	}

	public void actualizacionBD() {
		try {
			AlmacenDAO.actualizarStockPlatos(stockPlatos);
			AlmacenDAO.actualizarStockBebidas(stockBebidas);
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al actualizar la base de datos. "
					+ "Posible fallo de la VPN o caida del servicio.\n" + e.getMessage());
		}
	}

	public void aumentarStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] += ingredientesPlato[i];
	}

	public boolean comprobarStockPlatos(int[] ingredientesPlato) {
		boolean supuesto = true;
		for (int i = 0; i < stockPlatos.length && supuesto; i++)
			if (stockPlatos[i] < ingredientesPlato[i])
				supuesto = false;
		return supuesto;
	}

	public void reducirStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] -= ingredientesPlato[i];
	}

	public void aumentarStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]++;
				encontrado = true;
			}
	}

	public boolean comprobarStockBebidas(String nombreBebida) {
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

	public void reducirStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]--;
				encontrado = true;
			}
	}

	public void aumentarStock(Comanda c) {
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

	public boolean comprobarUmbralIngredientes() {

		boolean suficiente = true;

		for (int i = 0; i < stockPlatos.length && suficiente; i++)
			if (stockPlatos[i] < UMBRAL * STOCK_MAXIMO_INGREDIENTES)
				suficiente = false;

		return suficiente;
	}

	public boolean comprobarUmbralBebidas() {

		boolean suficiente = true;

		for (int i = 0; i < stockBebidas.length && suficiente; i++)
			if (stockBebidas[i] < UMBRAL * STOCK_MAXIMO_BEBIDAS)
				suficiente = false;

		return suficiente;
	}

	public void reponerStocks() {

		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] = Constantes.STOCK_MAXIMO_INGREDIENTES;
		for (int i = 0; i < stockBebidas.length; i++)
			stockBebidas[i] = Constantes.STOCK_MAXIMO_BEBIDAS;

		actualizacionBD();

	}

	public String toStringStockPlatos() {
		String cadena = "";
		for (int i = 0; i < stockPlatos.length - 1; i++)
			cadena += stockPlatos[i] + ", ";
		return cadena + stockPlatos[stockPlatos.length - 1];
	}

	public String toStringStockBebidas() {
		String cadena = "";
		for (int i = 0; i < stockBebidas.length - 1; i++)
			cadena += stockBebidas[i] + ", ";
		return cadena + stockBebidas[stockBebidas.length - 1];
	}

}
