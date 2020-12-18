package es.uclm.esi.isoft2.PedidosComandas.Dominio;

/**
 * Clase que representa el objeto Bebida.
 * 
 * @author BC03
 *
 */
public class Bebida {

	/**
	 * Identificador único de la bebida reclamada. Cada bebida (recipiente)
	 * solicitada tiene un id.
	 */
	private int id;
	/**
	 * Nombre de la bebida, común para todas las bebidas de ese tipo de bebida.
	 */
	private String nombre;

	/**
	 * Método constructor de la instancia Bebida.
	 * 
	 * @param id
	 * @param nombre
	 */
	public Bebida(int id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	/**
	 * Método que devuelve el identificador único de la bebida.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método que fija el identificador único de la bebida.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método que recupera el nombre de la bebida de dicha instancia.
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que fija el nombre de la bebida, de dicha instancia sobre la que se
	 * aplica.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve la información de dicha Bebida.
	 */
	@Override
	public String toString() {
		return nombre + " (id: " + id + ")";
	}

	/**
	 * Método que reduce en una unidad el id de la bebida.
	 */
	public void reducirId() {
		this.id--;
	}

}
