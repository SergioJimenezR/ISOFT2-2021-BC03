package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private int numeroConmensales;
	private double [] vectorTiempos;
	private long tiempoEnEstado;
	private Comanda comanda;
	private int precio;
	


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

	public int getNumeroConmensales() {
		return numeroConmensales;
	}

	public void setNumeroConmensales(int numeroConmensales) {
		this.numeroConmensales = numeroConmensales;
	}

	public double[] getVectorTiempos() {
		return vectorTiempos;
	}
	
	

}
