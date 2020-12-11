package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.ArrayList;

public class Comanda extends Aviso {

	private ArrayList<Bebida> bebidas;

	private ArrayList<Plato> entrantes;
	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;

	public Comanda(int id, Mesa mesa, ArrayList<Bebida> bebidas, ArrayList<Plato> entrantes, ArrayList<Plato> primeros,
			ArrayList<Plato> segundos, ArrayList<Plato> postres) {
		super(id, mesa);
		setBebidas(bebidas);
		setEntrantes(entrantes);
		setPrimeros(primeros);
		setSegundos(segundos);
		setPostres(postres);
	}

	public ArrayList<ArrayList<Plato>> getComida() {
		ArrayList<ArrayList<Plato>> comidas = new ArrayList<ArrayList<Plato>>();
		comidas.add(entrantes);
		comidas.add(primeros);
		comidas.add(segundos);
		comidas.add(postres);
		return comidas;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public ArrayList<Plato> getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(ArrayList<Plato> entrantes) {
		this.entrantes = entrantes;
	}

	public ArrayList<Plato> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<Plato> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<Plato> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<Plato> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Plato> getPostres() {
		return postres;
	}

	public void setPostres(ArrayList<Plato> postres) {
		this.postres = postres;
	}

	@Override
	public String toString() {
		return "Comanda " + id + " de la mesa n.º " + mesa.getId() + " preparada.";
	}

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

	public String toStringBebidas() { // Puede haber un problema a la hora de llamar
		String cadena = "Bebidas: ";
		for (int i = 0; i < bebidas.size(); i++)
			cadena += bebidas.get(i).getNombre() + " ";
		return cadena;
	}

	public boolean tieneBebidas() {
		return bebidas.size() > 0;
	}

	public boolean tienePlatos() {
		return entrantes.size() > 0 || primeros.size() > 0 || segundos.size() > 0 || postres.size() > 0;
	}
	
}
