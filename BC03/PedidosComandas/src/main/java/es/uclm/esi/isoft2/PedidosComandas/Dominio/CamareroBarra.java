package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class CamareroBarra extends CamareroMesa {

	private boolean bebidaLista;
	private String status;

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param dni
	 * @param tiempoCortesia
	 * @param horaAtencion_double
	 * @param bebidaLista
	 */
	public CamareroBarra(String nombre, String apellidos, int edad, int dni, double tiempoCortesia, int horaAtencion_double, boolean bebidaLista) {
		super(nombre, apellidos, edad, dni, tiempoCortesia, horaAtencion_double, bebidaLista);
		throw new UnsupportedOperationException();
	}

	public void avisarCamareroMesa() {
		// TODO - implement CamareroBarra.avisarCamareroMesa
		throw new UnsupportedOperationException();
	}

}