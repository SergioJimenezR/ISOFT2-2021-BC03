package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import java.util.ArrayList;
import java.util.Date;


public class Mesa {

	private int id;
	private EstadosMesas estadoMesa;
	private Comanda comanda;
	private int precio;
	private Cliente cliente;
	private ArrayList<Date> listaDeDias;

	public Mesa(int id) {
		setId(id);
		setEstadoMesa(EstadosMesas.LIBRE);
		comanda = null;
		precio = 0;
	}
	public Mesa(int id, EstadosMesas estado) {
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

	public ArrayList<Date> getListaDeDias() {
		return listaDeDias;
	}

	public void setListaDeDias(ArrayList<Date> listaDeDias, Date fecha) {	
		listaDeDias.add(fecha);
	}
	
	public boolean modificarDatosReservado(String nombre, String apellidos) {
		cliente.setNombre(nombre);
		cliente.setApellido(apellidos);
		estadoMesa=EstadosMesas.RESERVADA;
		return true;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
