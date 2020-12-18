package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

/**
 * Interface de constantes que mantiene toda la informacion reglamentada del
 * programa.
 * 
 * @author BC03
 *
 */

public interface Constantes {

	/**
	 * Indice en el que comienza los identificadores unicos.
	 */
	public final int INDICE_INICIAL_PRODUCTOS = 1;

	/**
	 * Numero de mesas del programa.
	 */
	public final int NUM_MESAS = 6;

	/**
	 * Stock maximo reglamentado de bebidas, al momento de la reposicion.
	 */
	public final int STOCK_MAXIMO_BEBIDAS = 50;

	/**
	 * Stock maximo reglamentado de cantidad de gramos de cada ingredientes, al
	 * momento de la reposicion.
	 */
	public final int STOCK_MAXIMO_INGREDIENTES = 1000;

	/**
	 * Umbral sobre el que se avisa, cuando los stocks descienden de este umbral
	 * sobre las maximas cantidades.
	 */
	public final double UMBRAL = 0.2;

	/**
	 * Nombres de las bebidas.
	 */
	public final String[] NOMBRES_BEBIDAS = { "Bebida1", "Bebida2", "Bebida3", "Bebida4", "Bebida5" };

	/**
	 * Nombres de los tipos de ingredientes de los platos. Cada plato reune estos 3
	 * ingredientes.
	 */
	public final String[] NOMBRES_INGREDIENTES = { "Ingrediente1", "Ingrediente2", "Ingrediente3" };

	/**
	 * Nombres de los platos entrantes.
	 */
	public final String[] NOMBRES_ENTRANTES = { "Entrante1", "Entrante2", "Entrante3", "Entrante4", "Entrante5" };
	/**
	 * Cantidad de ingredientes de los platos entrantes respectivamente.
	 */
	public final int[][] INGR_ENTRANTES = { { 300, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	/**
	 * Nombres de los primeros platos.
	 */
	public final String[] NOMBRES_PRIMEROS = { "Primero1", "Primero2", "Primero3", "Primero4", "Primero5" };
	/**
	 * Cantidad de ingredientes de los primeros platos respectivamente.
	 */
	public final int[][] INGR_PRIMEROS = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	/**
	 * Nombres de los segundos platos.
	 */
	public final String[] NOMBRES_SEGUNDOS = { "Segundo1", "Segundo2", "Segundo3", "Segundo4", "Segundo5" };
	/**
	 * Cantidad de ingredientes de los segundos platos respectivamente.
	 */
	public final int[][] INGR_SEGUNDOS = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	/**
	 * Nombres de los postres.
	 */
	public final String[] NOMBRES_POSTRES = { "Postre1", "Postre2", "Postre3", "Postre4", "Postre5" };
	/**
	 * Cantidad de ingredientes de los postres respectivamente.
	 */
	public final int[][] INGR_POSTRES = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

}
