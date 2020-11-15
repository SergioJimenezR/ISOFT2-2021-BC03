package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Aviso {

	protected int id;
	protected Mesa mesa;
	private int tiempoEspera;
	private boolean atendido;

	public Aviso(int id, Mesa mesa) {
		setId(id);
		setMesa(mesa);
		tiempoEspera = 10000;
		atendido = false;
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

	public int getTiempoEspera() {
		return tiempoEspera;
	}

	public boolean getAtendido() {
		return atendido;
	}

	public void setAtendidoTrue() {
		atendido = true;
	}

	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	public String toString() {
		return "Se ha superado el tiempo de espera. Avisar a los clientes.";
	}

}
