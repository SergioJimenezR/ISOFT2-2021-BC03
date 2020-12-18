package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.AlmacenDAO;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

/**
 * Clase que refleja la figura del Almacén del restaurante. Las informaciones de
 * los stocks se mantienen almacenados en esta clase.
 * 
 * @author BC03
 *
 */
public class Almacen implements Constantes {

	/**
	 * Instancia Singleton.
	 */
	private static Almacen mInstancia = null;
	/**
	 * Vector de enteros que almacena la cantidad de gramos, de cada tipo de
	 * ingredientes, para el stock de platos, del Almacén.
	 */
	private int[] stockPlatos;
	/**
	 * Vector de enteros que almacena la cantidad de unidades de bebidas, de cada
	 * tipo de bebida, para el stock de bebidas, del Almacén.
	 */
	private int[] stockBebidas;

	/**
	 * Constructor de la instancia Almacen Singleton.
	 */
	private Almacen() {
		primeraLectura();
	}

	/**
	 * Método que ayuda a obtener la instancia de la clase Almacen.
	 * 
	 * @return
	 */
	public static Almacen getAlmacen() { // Patron Singleton
		if (mInstancia == null)
			mInstancia = new Almacen();
		return mInstancia;
	}

	/**
	 * Método que realiza la primera lectura de la base de datos en el programa, al
	 * inicio.
	 */
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

	/**
	 * Método que realiza la actualización de la base de datos cuando pulsamos el
	 * botón Guardar de las interfaces. En lo referido a ésto, se lee el stock de la
	 * Base de datos al inicio del programa, y en cualquier momento se puede
	 * escribir contra ésta, con el botón Guardar.
	 */
	public void actualizacionBD() {
		try {
			AlmacenDAO.actualizarStockPlatos(stockPlatos);
			AlmacenDAO.actualizarStockBebidas(stockBebidas);
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al actualizar la base de datos. "
					+ "Posible fallo de la VPN o caida del servicio.\n" + e.getMessage());
		}
	}

	/**
	 * Método que, según lo que se le pase por parámetro de entrada, aumenta la
	 * cantidad de stock de platos que haya en el almacén (atributo stockPlatos de
	 * la instancia Singleton).
	 * 
	 * @param ingredientesPlato
	 */
	public void aumentarStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] += ingredientesPlato[i];
	}

	/**
	 * Método que, según lo que se le pase por parámetro de entrada, comprueba si
	 * hay stock suficiente para satisfacerlo, según el stock de ingredientes de
	 * platos que haya en el almacén, devolviendo un boolean que indica la
	 * suficiencia.
	 * 
	 * @param ingredientesPlato
	 * @return
	 */
	public boolean comprobarStockPlatos(int[] ingredientesPlato) {
		boolean supuesto = true;
		for (int i = 0; i < stockPlatos.length && supuesto; i++)
			if (stockPlatos[i] < ingredientesPlato[i])
				supuesto = false;
		return supuesto;
	}

	/**
	 * Método que, según lo que se le indique por parámetro de entrada, reduce el
	 * stock de Platos que haya en el almacén.
	 * 
	 * @param ingredientesPlato
	 */
	public void reducirStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] -= ingredientesPlato[i];
	}

	/**
	 * Método que, según lo que se le indique por parámetro de entrada, aumenta el
	 * stock de Bebidas que haya en el almacén.
	 * 
	 * @param nombreBebida
	 */
	public void aumentarStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]++;
				encontrado = true;
			}
	}

	/**
	 * Método que, según lo que se le indica por parámetro, se comprueba si hay
	 * suficiencia de stock de Bebidas en el Almacén (instancia Singleton sobre la
	 * que se invoca el método), devolviendo un boolean que indica dicha
	 * suficiencia.
	 * 
	 * @param nombreBebida
	 * @return
	 */
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

	/**
	 * Método que, según lo que se le indica por parámetro, reduce el stock de
	 * bebdias del Almacen.
	 * 
	 * @param nombreBebida
	 */
	public void reducirStockBebidas(String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockBebidas[i]--;
				encontrado = true;
			}
	}

	/**
	 * Método que, según la comanda que se le indique por parámetro de entrada,
	 * aumenta el stock de todos sus platos y bebidas contra los stocks del Almacén.
	 * 
	 * @param c
	 */
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

	/**
	 * Método que avisa e indica a la Cocina de que se ha descendido del umbral
	 * mínimo de cantidad de ingredientes del stock de platos del Almacén,
	 * devolviendo un boolean false en caso de insuficiencia.
	 * 
	 * @return
	 */
	public boolean comprobarUmbralIngredientes() {

		boolean suficiente = true;

		for (int i = 0; i < stockPlatos.length && suficiente; i++)
			if (stockPlatos[i] < UMBRAL * STOCK_MAXIMO_INGREDIENTES)
				suficiente = false;

		return suficiente;
	}

	/**
	 * Método que avisa e indica a los camareros de la barra de que se ha descendido
	 * del umbral mínimo de cantidad de bebidas del stock de bebdias del Almacén,
	 * devolviendo un boolean false en caso de insuficiencia.
	 * 
	 * @return
	 */
	public boolean comprobarUmbralBebidas() {

		boolean suficiente = true;

		for (int i = 0; i < stockBebidas.length && suficiente; i++)
			if (stockBebidas[i] < UMBRAL * STOCK_MAXIMO_BEBIDAS)
				suficiente = false;

		return suficiente;
	}

	/**
	 * Método que repone los stocks del Almacén según lo que se fija en la interface
	 * de Constantes, en el caso de insuficiencia.
	 */
	public void reponerStocks() {

		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] = Constantes.STOCK_MAXIMO_INGREDIENTES;
		for (int i = 0; i < stockBebidas.length; i++)
			stockBebidas[i] = Constantes.STOCK_MAXIMO_BEBIDAS;

		actualizacionBD();

	}

	/**
	 * Método que devuelve la información del stock de ingredientes de platos del
	 * Almacén, indicando la cantidad de gramos de cada ingrediente (stockPlatos).
	 * 
	 * @return
	 */
	public String toStringStockPlatos() {
		String cadena = "";
		for (int i = 0; i < stockPlatos.length - 1; i++)
			cadena += stockPlatos[i] + ", ";
		return cadena + stockPlatos[stockPlatos.length - 1];
	}

	/**
	 * Método que devuelve la información del stock de bebidas del Almacén,
	 * indicando la cantidad de unidades de bebidas, de cada tipo de bebida
	 * (stockBebidas).
	 * 
	 * @return
	 */
	public String toStringStockBebidas() {
		String cadena = "";
		for (int i = 0; i < stockBebidas.length - 1; i++)
			cadena += stockBebidas[i] + ", ";
		return cadena + stockBebidas[stockBebidas.length - 1];
	}

}
