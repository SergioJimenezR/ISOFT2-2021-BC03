package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Bebida {

	private int idBebida;
	private String nombre;
	
	public Bebida(int idBebida, String nombre) {
		this.idBebida = idBebida;
		this.nombre = nombre;
	}

	public int getIdBebida() {
		return idBebida;
	}

	public String getNombre() {
		return nombre;
	}	
	
}
