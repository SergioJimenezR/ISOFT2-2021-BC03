package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.Date;

/**
 * Clase que representa la Mesa.
 * 
 * @author BC03
 *
 */
public class Mesa {

	/**
	 * Identificador unico de la mesa.
	 */
	private int id;
	/**
	 * Estado de la mesa en concreto.
	 */
	private EstadosMesas estadoMesa;
	/**
	 * Comanda asociada a la mesa. Cada mesa solo puede pedir una comanda a lo largo
	 * de su estancia en el restaurante.
	 */
	private Comanda comanda;
	/**
	 * Importe del coste de la comanda, de dicha mesa, al momento de pagar.
	 */
	private int precio;
	/**
	 * Documentacion de identificacion DNI del cliente que reserva la mesa.
	 */
	private String dni;

	/**
	 * Tiempo de cada estado por los que pasa la mesa
	 */
	private double[] vectorTiempos;
	/**
	 * Momento de ejecucion en el que la mesa cambia de estado
	 */
	private double tiempoTranscurrido;
	/**
	 * Numero de comensales que admite la mesa
	 */
	private int numComensales;
	/**
	 * Fecha en la que se reserva la Mesa por un cliente.
	 */
	private Date fecha;

	/**
	 * Constructor 1 de la instancia Mesa.
	 * 
	 * @param id Identificador unico de la mesa
	 */
	public Mesa(int id) {
		vectorTiempos = new double[9];
		inicializar();
		setId(id);
		setEstadoMesa(EstadosMesas.LIBRE);
		comanda = null;
		precio = 0;
	}

	/**
	 * Constructor 2 de la instancia Mesa, por sobreescritura con diferenciacion de
	 * metodos, que satisface otras necesidades.
	 * 
	 * @param id     Identificador unico de la mesa
	 * @param estado Estado de la mesa
	 */
	public Mesa(int id, EstadosMesas estado) {
		vectorTiempos = new double[9];
		inicializar();
		setId(id);
		setEstadoMesa(estado);
		comanda = null;
		precio = 0;
		this.setNumComensales();
	}

	/**
	 * Metodo que devuelve el identificador unico de la Mesa.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que fija el identificador unico de la Mesa.
	 * 
	 * @param id Identificador unico de la mesa
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que devuelve el estado que esta atravesando una mesa en concreto en el
	 * momento de la llamada, de la enumeracion EstadosMesas.
	 * 
	 * @return estado
	 */
	public EstadosMesas getEstadoMesa() {
		return this.estadoMesa;
	}

	/**
	 * Metodo que fija o modifica el estado de la Mesa, a otro estado.
	 * 
	 * @param estadoMesa Estado de la mesa
	 */
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

	/**
	 * Metodo que devuelve la instancia de Comanda subasociada a la Mesa.
	 * 
	 * @return comanda
	 */
	public Comanda getComanda() {
		return comanda;
	}

	/**
	 * Metodo que fija una Comanda en concreto a la Mesa.
	 * 
	 * @param comanda Comanda asociada a la mesa
	 */
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	/**
	 * Asigna el numero de comensales a la mesa
	 */
	private void setNumComensales() {
		if (this.id < 3)
			this.numComensales = 2;
		else if (this.id >= 3 && this.id < 5)
			this.numComensales = 4;
		else
			this.numComensales = 6;
	}

	/**
	 * Metodo que devuelve el importe del coste de la comanda, de la Mesa.
	 * 
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Metodo que fija el importe del coste de la comanda, de la Mesa.
	 * 
	 * @param precio Importe de la mesa
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Metodo que devuelve el DNI del cliente que ha reservado una mesa en concreto.
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo que fija el DNI de un cliente sobre la reserva de una mesa.
	 * 
	 * @param dni DNI del cliente de la reserva
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo que devuelve la fecha de la reserva de la mesa.
	 * 
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo que fija la fecha de la reserva.
	 * 
	 * @param fecha Fecha de la reserva
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo que devuelve la informacion de la Mesa (toString), con el
	 * identificador unico y el estado de la misma.
	 */
	@Override
	public String toString() {
		return Integer.toString(this.id) + " - " + estadoMesa.name();
	}

	/**
	 * Metodo que cierra la cuenta de la Mesa, calculando el importe.
	 */
	public void cerrarCuenta() {
		this.setPrecio(calcularPrecio());
	}

	/**
	 * Metodo que calcula el importe de la Mesa, y que sirve para fijarlo cuando se
	 * cierra la cuenta.
	 * 
	 * @return importe
	 */
	private int calcularPrecio() {
		return 100;
	}

	/**
	 * Metodo que modifica los datos personales del cliente de la reserva de la
	 * mesa.
	 * 
	 * @param dni   DNI del cliente de la reserva
	 * @param fecha Fecha de la reserva
	 * @return boolean Realizado correctamente
	 */
	public boolean modificarDatosReservado(String dni, Date fecha) {
		setDni(dni);
		setFecha(fecha);
		estadoMesa = EstadosMesas.RESERVADA;
		return true;
	}

	/**
	 * Anyade el tiempo de un estado al vector de tiempos
	 * 
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
	 * 
	 * @return boolean Comprobante
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
	 * 
	 * @return double[] Vector de tiempos
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
