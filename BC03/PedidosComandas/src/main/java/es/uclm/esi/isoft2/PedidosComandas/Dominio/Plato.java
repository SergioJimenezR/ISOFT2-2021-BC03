package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import es.uclm.esi.isoft2.PedidosComandas.Presentacion.Carta;
import es.uclm.esi.isoft2.PedidosComandas.Presentacion.Ingredientes;

public class Plato {

	private int id;
	private String nombre;
	private int[] ingredientes;

	public Plato(int id, String nombre) {
		setId(id);
		setNombre(nombre);
		setIngredientes(calcularIngredientes(nombre));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(int[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String toString() {
		return nombre + " (id: " + id + ")";
	}

	public static int[] calcularIngredientes(String nombre) {
		int[] ingredientes = null;

		boolean encontrado = false;
		for (int i = 0; i < 4 && !encontrado; i++) {
			String[] auxplatos = null;
			int[][] auxingredientes = null;
			switch (i) {
			case 0:
				auxplatos = Carta.entrantes;
				auxingredientes = Ingredientes.entrantes;
				break;
			case 1:
				auxplatos = Carta.primeros;
				auxingredientes = Ingredientes.primeros;
				break;
			case 2:
				auxplatos = Carta.segundos;
				auxingredientes = Ingredientes.segundos;
				break;
			case 3:
				auxplatos = Carta.postres;
				auxingredientes = Ingredientes.postres;
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

	public void reducirId() {
		this.id--;
	}

}
