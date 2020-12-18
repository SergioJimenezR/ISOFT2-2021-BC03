package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.ArrayList;

/**
 * Clase que representa a la Comanda, que hereda de la clase Aviso.
 * 
 * @author BC03
 *
 */
public class Comanda extends Aviso {

	/**
	 * Lista dinamica que contiene las bebidas que se han solicitado en esta
	 * comanda.
	 */
	private ArrayList<Bebida> bebidas;

	/**
	 * Lista dinamica que contiene los entrantes que se han solicitado en esta
	 * comanda.
	 */
	private ArrayList<Plato> entrantes;
	/**
	 * Lista dinamica que contiene los primeros que se han solicitado en esta
	 * comanda.
	 */
	private ArrayList<Plato> primeros;
	/**
	 * Lista dinamica que contiene los segundos que se han solicitado en esta
	 * comanda.
	 */
	private ArrayList<Plato> segundos;
	/**
	 * Lista dinamica que contiene los postres que se han solicitado en esta
	 * comanda.
	 */
	private ArrayList<Plato> postres;

	/**
	 * Metodo constructor de la comanda, con relacion de herencia sobre Aviso.
	 * 
	 * @param id
	 * @param mesa
	 * @param bebidas
	 * @param entrantes
	 * @param primeros
	 * @param segundos
	 * @param postres
	 */
	public Comanda(int id, Mesa mesa, ArrayList<Bebida> bebidas, ArrayList<Plato> entrantes, ArrayList<Plato> primeros,
			ArrayList<Plato> segundos, ArrayList<Plato> postres) {
		super(id, mesa);
		setBebidas(bebidas);
		setEntrantes(entrantes);
		setPrimeros(primeros);
		setSegundos(segundos);
		setPostres(postres);
	}

	/**
	 * Metodo que devuelve una lista dinamica con todos los platos, de todos los
	 * tipos de platos, de la comanda.
	 * 
	 * @return comidas
	 */
	public ArrayList<ArrayList<Plato>> getComida() {
		ArrayList<ArrayList<Plato>> comidas = new ArrayList<ArrayList<Plato>>();
		comidas.add(entrantes);
		comidas.add(primeros);
		comidas.add(segundos);
		comidas.add(postres);
		return comidas;
	}

	/**
	 * Metodo que devuelve una lista dinamica con todas las bebidas de la comanda.
	 * 
	 * @return bebidas
	 */
	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	/**
	 * Metodo que fija las bebidas asociadas a una comanda en concreto.
	 * 
	 * @param bebidas
	 */
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	/**
	 * Metodo que recupera el listado de platos entrantes de la comanda.
	 * 
	 * @return entrantes
	 */
	public ArrayList<Plato> getEntrantes() {
		return entrantes;
	}

	/**
	 * Metodo que fija los entrantes a una comanda en concreto, que se pasan por
	 * parametro.
	 * 
	 * @param entrantes
	 */
	public void setEntrantes(ArrayList<Plato> entrantes) {
		this.entrantes = entrantes;
	}

	/**
	 * Metodo que recupera el listado de primeros platos de la comanda.
	 * 
	 * @return primeros
	 */
	public ArrayList<Plato> getPrimeros() {
		return primeros;
	}

	/**
	 * Metodo que fija los primeros platos a una comanda en concreto.
	 * 
	 * @param primeros
	 */
	public void setPrimeros(ArrayList<Plato> primeros) {
		this.primeros = primeros;
	}

	/**
	 * Metodo que recupera el listado de segundos platos de la comanda.
	 * 
	 * @return segundos
	 */
	public ArrayList<Plato> getSegundos() {
		return segundos;
	}

	/**
	 * Metodo que fija los segundos platos a una comanda en concreto.
	 * 
	 * @param segundos
	 */
	public void setSegundos(ArrayList<Plato> segundos) {
		this.segundos = segundos;
	}

	/**
	 * Metodo que recupera el listado de postres de la comanda.
	 * 
	 * @return postres
	 */
	public ArrayList<Plato> getPostres() {
		return postres;
	}

	/**
	 * Metodo que fija los postres a una comanda en concreto.
	 * 
	 * @param postres
	 */
	public void setPostres(ArrayList<Plato> postres) {
		this.postres = postres;
	}

	/**
	 * Metodo que devuelve la informacion de dicha comanda.
	 */
	@Override
	public String toString() {
		return "Comanda " + id + " de la mesa n.º " + mesa.getId() + " preparada.";
	}

	/**
	 * Metodo que devuelve la informacion de la lista de todos los platos de la
	 * comanda.
	 * 
	 * @return comidas
	 */
	public String toStringPlatos() {
		String cadena = "Platos:";
		ArrayList<Plato> lista = new ArrayList<Plato>();
		String tipo = "";
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				lista = entrantes;
				tipo = "Entrantes";
				break;
			case 1:
				lista = primeros;
				tipo = "Primeros";
				break;
			case 2:
				lista = segundos;
				tipo = "Segundos";
				break;
			case 3:
				lista = postres;
				tipo = "Postres";
				break;
			}
			if (lista.size() > 0) {
				cadena += "\n" + tipo + ": ";
				for (int j = 0; j < lista.size(); j++)
					cadena += lista.get(j).getNombre() + " ";
			}
		}
		return cadena;
	}

	/**
	 * Metodo que devuelve la informacion de la lista de todas las bebidas de la
	 * comanda.
	 * 
	 * @return bebidas
	 */
	public String toStringBebidas() {
		String cadena = "Bebidas: ";
		for (int i = 0; i < bebidas.size(); i++)
			cadena += bebidas.get(i).getNombre() + " ";
		return cadena;
	}

	/**
	 * Metodo que desvela si la comanda tiene bebidas.
	 * 
	 * @return boolean
	 */
	public boolean tieneBebidas() {
		return bebidas.size() > 0;
	}

	/**
	 * Metodo que desvela si la comanda dispone de platos.
	 * 
	 * @return
	 */
	public boolean tienePlatos() {
		return entrantes.size() > 0 || primeros.size() > 0 || segundos.size() > 0 || postres.size() > 0;
	}

}
