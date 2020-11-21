package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;

	public Mesa(int id) {
		setId(id);
		setEstadoMesa(EstadosMesas.LIBRE);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadosMesas getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(EstadosMesas estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	@Override
	public String toString() {
		return Integer.toString(this.id) + " - " + estadoMesa.name();
	}

}
