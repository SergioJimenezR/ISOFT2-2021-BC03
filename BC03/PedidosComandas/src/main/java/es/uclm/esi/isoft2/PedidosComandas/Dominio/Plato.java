package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Plato {

	private int id;
	private String nombre;
	
	public Plato(int id, String nombre) {
		setId(id);
		setNombre(nombre);
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

	public String toString() {
		return nombre;
	}
	
}
