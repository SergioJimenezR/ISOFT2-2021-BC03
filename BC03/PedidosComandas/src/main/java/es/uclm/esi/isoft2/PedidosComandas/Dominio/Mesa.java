package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private int numeroConmensales;
	private double [] vectorTiempos;
	private long tiempoEnEstado;

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
		if(this.estadoMesa != null) {
			long tiempoTranscurrido = System.currentTimeMillis() - this.tiempoEnEstado;
			guardarTiempoVector(tiempoTranscurrido, estadoMesa);
		}
		this.tiempoEnEstado = System.currentTimeMillis();
		this.estadoMesa = estadoMesa;
	}
	
	public double[] calcularTiemposMediosMesa() {
		for(int i=0;i<vectorTiempos.length;i++)
			this.vectorTiempos[i]/=this.numeroConmensales;
		return this.vectorTiempos;
	}
	private void guardarTiempoVector(long tiempoTranscurrido, EstadosMesas estado) {
		int i = -1;
		switch (estado) {
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
		this.vectorTiempos[i]=(double)tiempoTranscurrido;
	}
	
	
	public int getNumeroConmensales() {
		return numeroConmensales;
	}

	public void setNumeroConmensales(int numeroConmensales) {
		this.numeroConmensales = numeroConmensales;
	}

	@Override
	public String toString() {
		return Integer.toString(this.id) + " - " + estadoMesa.name();
	}

}
