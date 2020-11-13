package es.uclm.esi.isoft2.PedidosComandas.Dominio;

public class Auxiliar {

	public static void imprimirVectorStockVirtual(int[] stock) {
		String cadena = "";
		for(int i = 0; i < stock.length; i++) {
			cadena += stock[i] + " ";
		}
		System.out.println(cadena);
	}
	
}
