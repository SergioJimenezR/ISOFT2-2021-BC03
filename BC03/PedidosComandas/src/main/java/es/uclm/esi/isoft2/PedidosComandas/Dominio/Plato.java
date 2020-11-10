package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Plato {

	private int idPlato;
	private String nombre;
	private boolean disponible;
	
	public Plato (int idPlato, String nombre, boolean disponible) {
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.disponible = disponible;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
