package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class CamareroMesa {

	private String nombre;
	private String apellidos;
	private int edad;
	private int dni;
	private double horaAtencion;
	private Mesa[] nMesas;

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param dni
	 * @param tiempoCortesia
	 * @param nMesas
	 * @param horaAtencion_double
	 */
	public CamareroMesa(String nombre, String apellidos, int edad, int dni, double tiempoCortesia, Mesa[] nMesas, int horaAtencion_double) {
		// TODO - implement CamareroMesa.CamareroMesa
		throw new UnsupportedOperationException();
	}
	
	public CamareroMesa(String nombre, String apellidos, int edad, int dni, double tiempoCortesia, int horaAtencion_double, boolean bebidaLista) {
		
	}

	/**
	 * 
	 * @param horaAtencion_double
	 */
	public void seleccionarHoraMesa(int horaAtencion_double) {
		// TODO - implement CamareroMesa.seleccionarHoraMesa
		throw new UnsupportedOperationException();
	}

	public void anotarComanda() {
		// TODO - implement CamareroMesa.anotarComanda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param almacen
	 */
	public boolean obtenerDisponibilidad(Almacen almacen) {
		// TODO - implement CamareroMesa.obtenerDisponibilidad
		throw new UnsupportedOperationException();
	}

	public void apuntarComidaEntregada() {
		// TODO - implement CamareroMesa.apuntarComidaEntregada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param horaAtencion
	 */
	public void seleccionarNumMesa(double horaAtencion) {
		// TODO - implement CamareroMesa.seleccionarNumMesa
		throw new UnsupportedOperationException();
	}

}