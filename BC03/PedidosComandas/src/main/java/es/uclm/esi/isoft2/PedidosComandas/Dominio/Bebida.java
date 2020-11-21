package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Bebida {

	private int idBebida;
	private String nombre;
	private boolean disponible;
	
	public Bebida(int idBebida, String nombre, boolean disponible) {
		this.idBebida = idBebida;
		this.nombre = nombre;
		this.disponible = disponible;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getIdBebida() {
		return idBebida;
	}

	public String getNombre() {
		return nombre;
	}	
	
}
