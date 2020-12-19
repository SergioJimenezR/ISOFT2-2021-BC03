package es.uclm.esi.isoft2.PedidosComandas.Dominio;

/**
 * Clase que representa el objeto Bebida.
 * 
 * @author BC03
 *
 */
public class Bebida {

	/**
	 * Identificador unico de la bebida reclamada. Cada bebida (recipiente)
	 * solicitada tiene un id.
	 */
	private int id;
	/**
	 * Nombre de la bebida, comun para todas las bebidas de ese tipo de bebida.
	 */
	private String nombre;

	/**
	 * Metodo constructor de la instancia Bebida.
	 * 
	 * @param id     Identificador unico de la bebida
	 * @param nombre Nombre de la bebida
	 */
	public Bebida(int id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	/**
	 * Metodo que devuelve el identificador unico de la bebida.
	 * 
	 * @return id Identificador unico de la bebida
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que fija el identificador unico de la bebida.
	 * 
	 * @param id Identificador unico fijado a la bebida
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que recupera el nombre de la bebida de dicha instancia.
	 * 
	 * @return nombre Nombre de la bebida
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que fija el nombre de la bebida, de dicha instancia sobre la que se
	 * aplica.
	 * 
	 * @param nombre Nombre fijado a la Bebida
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la informacion de dicha Bebida.
	 */
	@Override
	public String toString() {
		return nombre + " (id: " + id + ")";
	}

	/**
	 * Metodo que reduce en una unidad el id de la bebida.
	 */
	public void reducirId() {
		this.id--;
	}

}
