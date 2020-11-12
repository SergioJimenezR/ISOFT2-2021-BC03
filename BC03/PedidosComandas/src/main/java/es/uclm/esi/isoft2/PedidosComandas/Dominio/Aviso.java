package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Aviso {

	protected int id;
	protected Mesa mesa;
	
	public Aviso(int id, Mesa mesa) {
		setId(id);
		setMesa(mesa);
	}
	
	protected int getId() {
		return id;
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	protected Mesa getMesa() {
		return mesa;
	}

	protected void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public String toString() {
		return "Aviso: ";
	}
	
}
