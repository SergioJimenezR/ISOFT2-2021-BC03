package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private int numeroConmensales;
	private double [] vectorTiempos;
	
	public int getNumeroConmensales() {
		return numeroConmensales;
	}

	public void setNumeroConmensales(int numeroConmensales) {
		this.numeroConmensales = numeroConmensales;
	}

	public double[] getVectorTiempos() {
		return vectorTiempos;
	}

	private long tiempoEnEstado;
	private int precio;
	private Comanda comanda;

	public Mesa(int id) {
		vectorTiempos = new double[9];
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
		if (estadoMesa != null) {
			double tiempoTranscurrido = System.currentTimeMillis() - this.tiempoEnEstado;
			actualizarTiempos(tiempoTranscurrido);
		}
		
		this.tiempoEnEstado = System.currentTimeMillis();
		this.estadoMesa = estadoMesa;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return Integer.toString(this.id) + " - " + estadoMesa.name();
	}

	public void cerrarCuenta() {
		this.setPrecio(calcularPrecio());
	}

	private int calcularPrecio() {
		return 1;
	}
	
	private void actualizarTiempos(double tiempoTranscurrido) {
		int i=-1;
		switch(this.estadoMesa) {
		case LIBRE:
			i=0;
			break;
		case RESERVADA:
			i=1;
			break;
		case OCUPADA:
			i=2;
			break;
		case PIDIENDO:
			i=3;
			break;
		case ESPERANDOCOMIDA:
			i=4;
			break;
		case SERVIDOS:
			i=5;
			break;
		case ESPERANDOCUENTA:
			i=6;
			break;
		case PAGANDO:
			i=7;
			break;
		case ENSUCIADA:
			i=8;
			break;
		}
		
		this.vectorTiempos[i]=tiempoTranscurrido;
	}
	
	public boolean todosEstadosRecorridos() {
		boolean result = true;
		for(int i=0;i<this.vectorTiempos.length;i++)
			if (this.vectorTiempos[i] == 0)
				result = false;
		return result;
	}
	
}
