package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

/**
 * Clase que representa al Plato en cuestion.
 * 
 * @author BC03
 *
 */
public class Plato {

	/**
	 * Identificador unico del plato.
	 */
	private int id;
	/**
	 * Nombre asociado al plato.
	 */
	private String nombre;
	/**
	 * Vector de numeros enteros que almacenan respectivamente las cantidades de
	 * gramos, de cada ingrediente del plato en cuestion.
	 */
	private int[] ingredientes;

	/**
	 * Constructor del plato.
	 * 
	 * @param id     Identificador unico del plato
	 * @param nombre Nombre del plato
	 */
	public Plato(int id, String nombre) {
		setId(id);
		setNombre(nombre);
		setIngredientes(calcularIngredientes(nombre));
	}

	/**
	 * Metodo que devuelve el identificador unico del plato.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que fija el valor del identificador unico del plato.
	 * 
	 * @param id Identificador unico del plato
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que devuelve el nombre del plato.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que fija el nombre del plato.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la cantidad de ingredientes del plato.
	 * 
	 * @return ingredientes
	 */
	public int[] getIngredientes() {
		return ingredientes;
	}

	/**
	 * Metodo que fija la cantidad de ingredientes del plato.
	 * 
	 * @param ingredientes
	 */
	public void setIngredientes(int[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * Metodo que devuelve la informacion del plato, indicando su nombre e
	 * identificador unico.
	 */
	public String toString() {
		return nombre + " (id: " + id + ")";
	}

	/**
	 * Metodo que ayuda a calcular los numeros de cantidades de ingredientes sobre
	 * las constantes prefijadas, del plato.
	 * 
	 * @param nombre Nombre del plato
	 * @return int[] Ingredientes del plato
	 */
	public static int[] calcularIngredientes(String nombre) {
		int[] ingredientes = null;

		boolean encontrado = false;
		for (int i = 0; i < 4 && !encontrado; i++) {
			String[] auxplatos = null;
			int[][] auxingredientes = null;
			switch (i) {
			case 0:
				auxplatos = Constantes.NOMBRES_ENTRANTES;
				auxingredientes = Constantes.INGR_ENTRANTES;
				break;
			case 1:
				auxplatos = Constantes.NOMBRES_PRIMEROS;
				auxingredientes = Constantes.INGR_PRIMEROS;
				break;
			case 2:
				auxplatos = Constantes.NOMBRES_SEGUNDOS;
				auxingredientes = Constantes.INGR_SEGUNDOS;
				break;
			case 3:
				auxplatos = Constantes.NOMBRES_POSTRES;
				auxingredientes = Constantes.INGR_POSTRES;
			}
			for (int j = 0; j < auxplatos.length && !encontrado; j++) {
				if (auxplatos[j].equals(nombre)) {
					ingredientes = auxingredientes[j];
					encontrado = true;
				}
			}
		}
		return ingredientes;
	}

	/**
	 * Metodo que reduce el identificador unico del plato.
	 */
	public void reducirId() {
		this.id--;
	}

	/**
	 * Metodo que devuelve la lista de ingredientes del plato.
	 * 
	 * @return String Informacion de los ingredientes
	 */
	public String toStringIngredientes() {
		String cadena = "";
		for (int i = 0; i < ingredientes.length - 1; i++)
			cadena += ingredientes[i] + ", ";
		return cadena + ingredientes[ingredientes.length - 1];
	}

}
