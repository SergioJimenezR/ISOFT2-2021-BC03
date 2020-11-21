package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Menu {

	private int idComanda;
	private Bebida idBebida;
	private Plato entrantes;
	private Plato primerPlato;
	private Plato segundoPlato;
	private Plato postre;

	/**
	 * 
	 * @param idComanda
	 * @param idBebida
	 * @param entrantes
	 * @param primerPlato
	 * @param segundoPlato
	 * @param postre
	 */
	public Menu(int idComanda, Bebida idBebida, Plato entrantes, 
		Plato primerPlato, Plato segundoPlato, Plato postre) {

		this.idComanda = idComanda;
		this.idBebida = idBebida;
		this.entrantes = entrantes;
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.postre = postre;
		
		throw new UnsupportedOperationException();
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public Bebida getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(Bebida idBebida) {
		this.idBebida = idBebida;
	}

	public Plato getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(Plato entrantes) {
		this.entrantes = entrantes;
	}

	public Plato getPrimerPlato() {
		return primerPlato;
	}

	public void setPrimerPlato(Plato primerPlato) {
		this.primerPlato = primerPlato;
	}

	public Plato getSegundoPlato() {
		return segundoPlato;
	}

	public void setSegundoPlato(Plato segundoPlato) {
		this.segundoPlato = segundoPlato;
	}

	public Plato getPostre() {
		return postre;
	}

	public void setPostre(Plato postre) {
		this.postre = postre;
	}
	
	
	
}
