package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Comensal {

	private String nombre;
	private Menu idMenu;
	
	public Comensal (String nombre, Menu idMenu) {
		this.nombre = nombre;
		this.idMenu = idMenu;
	}

	public Menu getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Menu idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
