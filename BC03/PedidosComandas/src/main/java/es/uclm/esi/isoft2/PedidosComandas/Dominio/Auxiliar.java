package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Auxiliar {

	public static String imprimirVector(int[] vector) {
		String cadena = "";
		for (int i = 0; i < vector.length - 1; i++)
			cadena += vector[i] + ", ";
		return cadena + vector[vector.length - 1];
	}

}
