package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import es.uclm.esi.isoft2.CocinaAlmacen.Persistencia.Constantes;

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

	public void reducirId() {
		this.id--;
	}

	public String toStringIngredientes() {
		String cadena = "";
		for (int i = 0; i < ingredientes.length - 1; i++)
			cadena += ingredientes[i] + ", ";
		return cadena + ingredientes[ingredientes.length - 1];
	}

}
