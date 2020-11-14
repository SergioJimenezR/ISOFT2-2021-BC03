package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Aviso {

	protected int id;
	protected Mesa mesa;
	
	public Aviso(int id, Mesa mesa) {
		setId(id);
		setMesa(mesa);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public String toString() {
		return "Aviso: ";
	}
	
}
