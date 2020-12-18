package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

/**
 * Clase que representa al Plato en cuestión.
 * 
 * @author BC03
 *
 */
public class Plato {

	/**
	 * Identificador único del plato.
	 */
	private int id;
	/**
	 * Nombre asociado al plato.
	 */
	private String nombre;
	/**
	 * Vector de números enteros que almacenan respectivamente las cantidades de
	 * gramos, de cada ingrediente del plato en cuestión.
	 */
	private int[] ingredientes;

	/**
	 * Constructor del plato.
	 * 
	 * @param id
	 * @param nombre
	 */
	public Plato(int id, String nombre) {
		setId(id);
		setNombre(nombre);
		setIngredientes(calcularIngredientes(nombre));
	}

	/**
	 * Método que devuelve el identificador único del plato.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método que fija el valor del identificador único del plato.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método que devuelve el nombre del plato.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que fija el nombre del plato.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve la cantidad de ingredientes del plato.
	 * 
	 * @return ingredientes
	 */
	public int[] getIngredientes() {
		return ingredientes;
	}

	/**
	 * Método que fija la cantidad de ingredientes del plato.
	 * 
	 * @param ingredientes
	 */
	public void setIngredientes(int[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * Método que devuelve la información del plato, indicando su nombre e
	 * identificador único.
	 */
	public String toString() {
		return nombre + " (id: " + id + ")";
	}

	/**
	 * Método que ayuda a calcular los números de cantidades de ingredientes sobre
	 * las constantes prefijadas, del plato.
	 * 
	 * @param nombre
	 * @return
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
	 * Método que reduce el identificador único del plato.
	 */
	public void reducirId() {
		this.id--;
	}

	/**
	 * Método que devuelve la lista de ingredientes del plato.
	 * 
	 * @return
	 */
	public String toStringIngredientes() {
		String cadena = "";
		for (int i = 0; i < ingredientes.length - 1; i++)
			cadena += ingredientes[i] + ", ";
		return cadena + ingredientes[ingredientes.length - 1];
	}

}
