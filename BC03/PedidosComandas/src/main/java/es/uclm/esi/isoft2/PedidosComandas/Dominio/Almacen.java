package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.AlmacenDAO;
import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

/**
 * Clase que refleja la figura del Almacen del restaurante. Las informaciones de
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
	 * ingredientes, para el stock de platos, del Almacen.
	 */
	private int[] stockPlatos;
	/**
	 * Vector de enteros que almacena la cantidad de unidades de bebidas, de cada
	 * tipo de bebida, para el stock de bebidas, del Almacen.
	 */
	private int[] stockBebidas;

	/**
	 * Constructor de la instancia Almacen Singleton.
	 */
	private Almacen() {
		primeraLectura();
	}

	/**
	 * Metodo que ayuda a obtener la instancia de la clase Almacen.
	 * 
	 * @return Almacen Instancia singleton
	 */
	public static Almacen getAlmacen() { // Patron Singleton
		if (mInstancia == null)
			mInstancia = new Almacen();
		return mInstancia;
	}

	/**
	 * Metodo que realiza la primera lectura de la base de datos en el programa, al
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
	 * Metodo que realiza la actualizacion de la base de datos cuando pulsamos el
	 * boton Guardar de las interfaces. En lo referido a esto, se lee el stock de la
	 * Base de datos al inicio del programa, y en cualquier momento se puede
	 * escribir contra esta, con el boton Guardar.
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
	 * Metodo que, segun lo que se le pase por parametro de entrada, aumenta la
	 * cantidad de stock de platos que haya en el almacen (atributo stockPlatos de
	 * la instancia Singleton).
	 * 
	 * @param ingredientesPlato Ingredientes de plato a aumentar su stock
	 */
	public void aumentarStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] += ingredientesPlato[i];
	}

	/**
	 * Metodo que, segun lo que se le pase por parametro de entrada, comprueba si
	 * hay stock suficiente para satisfacerlo, segun el stock de ingredientes de
	 * platos que haya en el almacen, devolviendo un boolean que indica la
	 * suficiencia.
	 * 
	 * @param ingredientesPlato Ingredientes de plato a comprobar su stock
	 * @return Booleano Comprobante de la suficiencia de stock de ingredientes
	 */
	public boolean comprobarStockPlatos(int[] ingredientesPlato) {
		boolean supuesto = true;
		for (int i = 0; i < stockPlatos.length && supuesto; i++)
			if (stockPlatos[i] < ingredientesPlato[i])
				supuesto = false;
		return supuesto;
	}

	/**
	 * Metodo que, segun lo que se le indique por parametro de entrada, reduce el
	 * stock de Platos que haya en el almacen.
	 * 
	 * @param ingredientesPlato Ingredientes del plato a reducir su stock
	 */
	public void reducirStockPlatos(int[] ingredientesPlato) {
		for (int i = 0; i < stockPlatos.length; i++)
			stockPlatos[i] -= ingredientesPlato[i];
	}

	/**
	 * Metodo que, segun lo que se le indique por parametro de entrada, aumenta el
	 * stock de Bebidas que haya en el almacen.
	 * 
	 * @param nombreBebida Nombre de la bebida a aumentar su stock
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
	 * Metodo que, segun lo que se le indica por parametro, se comprueba si hay
	 * suficiencia de stock de Bebidas en el Almacen (instancia Singleton sobre la
	 * que se invoca el metodo), devolviendo un boolean que indica dicha
	 * suficiencia.
	 * 
	 * @param nombreBebida Nombre de la bebida a comprobar su stock
	 * @return Booleano Comprobante de la suficiencia de stock de bebidas
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
	 * Metodo que, segun lo que se le indica por parametro, reduce el stock de
	 * bebdias del Almacen.
	 * 
	 * @param nombreBebida Nombre de la bebida a reducir su stock
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
	 * Metodo que, segun la comanda que se le indique por parametro de entrada,
	 * aumenta el stock de todos sus platos y bebidas contra los stocks del Almacen.
	 * 
	 * @param c Comanda de la cual se aumenta el stock
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
	 * Metodo que avisa e indica a la Cocina de que se ha descendido del umbral
	 * minimo de cantidad de ingredientes del stock de platos del Almacen,
	 * devolviendo un boolean false en caso de insuficiencia.
	 * 
	 * @return Booleano Comprobante del umbral de ingredientes
	 */
	public boolean comprobarUmbralIngredientes() {

		boolean suficiente = true;

		for (int i = 0; i < stockPlatos.length && suficiente; i++)
			if (stockPlatos[i] < UMBRAL * STOCK_MAXIMO_INGREDIENTES)
				suficiente = false;

		return suficiente;
	}

	/**
	 * Metodo que avisa e indica a los camareros de la barra de que se ha descendido
	 * del umbral minimo de cantidad de bebidas del stock de bebdias del Almacen,
	 * devolviendo un boolean false en caso de insuficiencia.
	 * 
	 * @return Booleano Comprobante del umbral de bebidas
	 */
	public boolean comprobarUmbralBebidas() {

		boolean suficiente = true;

		for (int i = 0; i < stockBebidas.length && suficiente; i++)
			if (stockBebidas[i] < UMBRAL * STOCK_MAXIMO_BEBIDAS)
				suficiente = false;

		return suficiente;
	}

	/**
	 * Metodo que repone los stocks del Almacen segun lo que se fija en la interface
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
	 * Metodo que devuelve la informacion del stock de ingredientes de platos del
	 * Almacen, indicando la cantidad de gramos de cada ingrediente (stockPlatos).
	 * 
	 * @return Informacion del stock de platos
	 */
	public String toStringStockPlatos() {
		String cadena = "";
		for (int i = 0; i < stockPlatos.length - 1; i++)
			cadena += stockPlatos[i] + ", ";
		return cadena + stockPlatos[stockPlatos.length - 1];
	}

	/**
	 * Metodo que devuelve la informacion del stock de bebidas del Almacen,
	 * indicando la cantidad de unidades de bebidas, de cada tipo de bebida
	 * (stockBebidas).
	 * 
	 * @return String Informacion del stock de bebidas
	 */
	public String toStringStockBebidas() {
		String cadena = "";
		for (int i = 0; i < stockBebidas.length - 1; i++)
			cadena += stockBebidas[i] + ", ";
		return cadena + stockBebidas[stockBebidas.length - 1];
	}

}
