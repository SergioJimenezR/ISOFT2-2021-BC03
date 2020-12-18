package es.uclm.esi.isoft2.PedidosComandas.Dominio;

/**
 * Clase que representa la figura de Aviso, para superacion de tiempos limite,
 * entre otras cosas.
 * 
 * @author BC03
 *
 */
public class Aviso {

	/**
	 * Atributo de identificador unico del aviso o clases que heredan de esta
	 * (Comanda).
	 */
	protected int id;
	/**
	 * Mesa asociada al aviso o comanda.
	 */
	protected Mesa mesa;
	/**
	 * Tiempo maximo de espera para el lanzamiento del aviso.
	 */
	private int tiempoEspera;
	/**
	 * Valor booleano que refleja si el aviso se ha atendido.
	 */
	private boolean atendido;

	/**
	 * Metodo constructor de la clase Aviso. Resulta ser una clase padre en relacion
	 * de Herencia, heredada.
	 * 
	 * @param id
	 * @param mesa
	 */
	public Aviso(int id, Mesa mesa) {
		setId(id);
		setMesa(mesa);
		tiempoEspera = 10000;
		atendido = false;
	}

	/**
	 * Metodo que devuelve el identificador unico del aviso o clases hijas
	 * (comanda).
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que da valor al identificador unico del aviso o comanda.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que devuelve la Mesa asociada a la instancia Aviso o clases hijas.
	 * 
	 * @return mesa
	 */
	public Mesa getMesa() {
		return mesa;
	}

	/**
	 * Metodo que fija la mesa a la instancia en concreto de Aviso o comandas.
	 * 
	 * @param mesa
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	/**
	 * Metodo que obtiene el tiempo de espera fijado para el aviso.
	 * 
	 * @return tiempoEspera
	 */
	public int getTiempoEspera() {
		return tiempoEspera;
	}

	/**
	 * Metodo que accede a la informacion de si dicho aviso se ha atendido ya.
	 * 
	 * @return atendido
	 */
	public boolean getAtendido() {
		return atendido;
	}

	/**
	 * Metodo que fija a true el atributo atendido, indicando que se ha atendido,
	 * cuando se atiende un aviso.
	 */
	public void setAtendidoTrue() {
		atendido = true;
	}

	/**
	 * Metodo que fija el tiempo de espera de un aviso.
	 * 
	 * @param tiempoEspera
	 */
	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	/**
	 * Metodo que devuelve la informacion del aviso, que se muestra al personal del
	 * restaurante.
	 * 
	 * @return String
	 */
	public String toString() {
		return "Se ha superado el tiempo de espera. Avisar a los clientes.";
	}

}
