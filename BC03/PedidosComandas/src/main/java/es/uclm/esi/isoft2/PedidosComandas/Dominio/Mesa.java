package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.Date;


public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private Comanda comanda;
	private int precio;
	private String dni;
	private Date dia;
	private double[] vectorTiempos;
	private double tiempoTranscurrido;

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
		if(this.estadoMesa != null) {
			double tiempoEnEstado = System.currentTimeMillis() - this.tiempoTranscurrido;
			System.out.println(tiempoEnEstado);
			this.actualizarTiempos(tiempoEnEstado);
		}
		if(this.estadoMesa == null)
			System.out.println("NULL");
		this.tiempoTranscurrido = System.currentTimeMillis();
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
	
	public boolean modificarDatosReservado(String dni, Date fecha) {
		setDni(dni);
		setDia(fecha);
		estadoMesa=EstadosMesas.RESERVADA;
		return true;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
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
		case ENPREPARACION:
			i=8;
			break;
		}
		
		this.vectorTiempos[i]=tiempoTranscurrido;
	}
	
	public boolean todosEstadosRecorridos() {
		boolean result = true;
		for(int i=0;i<this.vectorTiempos.length && result;i++)
			if (this.vectorTiempos[i] == 0)
				result = false;
		return result;
	}
	
	public double[] getVectorTiempos() {
		return vectorTiempos;
	}
	
	private void inicializar() {
		for(int i=0; i<this.vectorTiempos.length;i++)
			this.vectorTiempos[i]=0;
	}
	
}
