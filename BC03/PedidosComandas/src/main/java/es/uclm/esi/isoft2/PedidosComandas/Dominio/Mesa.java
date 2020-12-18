package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.Date;

public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private Comanda comanda;
	private int precio;
	private String dni;
	
	/**
	 * Tiempo de cada estado por los que pasa la mesa
	 */
	private double[] vectorTiempos;
	/**
	 * Momento de ejecución en el que la mesa cambia de estado
	 */
	private double tiempoTranscurrido;
	/**
	 * Número de comensales que admite la mesa
	 */
	private int numComensales;
	private Date fecha;

	public Mesa(int id) {
		vectorTiempos = new double[9];
		inicializar();
		setId(id);
		setEstadoMesa(EstadosMesas.LIBRE);
		comanda = null;
		precio = 0;
	}

	public Mesa(int id, EstadosMesas estado) {
		vectorTiempos = new double[9];
		inicializar();
		setId(id);
		setEstadoMesa(estado);
		comanda = null;
		precio = 0;
		this.setNumComensales();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadosMesas getEstadoMesa() {
		return this.estadoMesa;
	}

	public void setEstadoMesa(EstadosMesas estadoMesa) {
		if (this.estadoMesa != null) {
			double tiempoEnEstado = ((System.currentTimeMillis() - this.tiempoTranscurrido) / (double) numComensales)
					/ 60000.0;
			System.out.println(tiempoEnEstado);
			this.actualizarTiempos(tiempoEnEstado);
		}
		this.tiempoTranscurrido = System.currentTimeMillis();
		this.estadoMesa = estadoMesa;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	/**
	 * Asigna el número de comensales a la mesa
	 */
	private void setNumComensales() {
		if (this.id < 3)
			this.numComensales = 2;
		else if (this.id >= 3 && this.id < 5)
			this.numComensales = 4;
		else
			this.numComensales = 6;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public boolean modificarDatosReservado(String dni, Date fecha) {
		setDni(dni);
		setFecha(fecha);
		estadoMesa = EstadosMesas.RESERVADA;
		return true;
	}

	/**
	 * Añade el tiempo de un estado al vector de tiempos
	 * @param tiempoTranscurrido
	 */
	private void actualizarTiempos(double tiempoTranscurrido) {
		int i = -1;
		switch (this.estadoMesa) {
		case LIBRE:
			i = 0;
			break;
		case RESERVADA:
			i = 1;
			break;
		case OCUPADA:
			i = 2;
			break;
		case PIDIENDO:
			i = 3;
			break;
		case ESPERANDOCOMIDA:
			i = 4;
			break;
		case SERVIDOS:
			i = 5;
			break;
		case ESPERANDOCUENTA:
			i = 6;
			break;
		case PAGANDO:
			i = 7;
			break;
		case ENPREPARACION:
			i = 8;
			break;
		}

		this.vectorTiempos[i] = tiempoTranscurrido;
	}

	/**
	 * Comprueba que la mesa haya pasado por todos los estados
	 * @return
	 */
	public boolean todosEstadosRecorridos() {
		boolean result = true;
		for (int i = 0; i < this.vectorTiempos.length && result; i++)
			if (this.vectorTiempos[i] == 0)
				result = false;
		return result;
	}

	/**
	 * Getter del atributo vectorTiempos
	 * @return
	 */
	public double[] getVectorTiempos() {
		return vectorTiempos;
	}
	
	/**
	 * Inicializa a 0 el vectorTiempos
	 */
	private void inicializar() {
		for (int i = 0; i < this.vectorTiempos.length; i++)
			this.vectorTiempos[i] = 0;
	}
}
