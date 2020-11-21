package es.uclm.esi.isoft2.PedidosComandas.Dominio;

import es.uclm.esi.isoft2.PedidosComandas.Presentacion.Constantes;

public class Almacen {

	public static boolean comprobarStockVirtualPlatos(int[] stockVirtualPlatos, int[] ingredientesPlato) {
		boolean supuesto = true;
		for (int i = 0; i < stockVirtualPlatos.length && supuesto; i++)
			if (stockVirtualPlatos[i] < ingredientesPlato[i])
				supuesto = false;
		return supuesto;
	}

	public static int[] reducirStockVirtualPlatos(int[] stockVirtualPlatos, int[] ingredientesPlato) {
		for (int i = 0; i < stockVirtualPlatos.length; i++)
			stockVirtualPlatos[i] -= ingredientesPlato[i];
		return stockVirtualPlatos;
	}

	public static int[] aumentarStockVirtualPlatos(int[] stockVirtualPlatos, int[] ingredientesPlato) {
		for (int i = 0; i < stockVirtualPlatos.length; i++)
			stockVirtualPlatos[i] += ingredientesPlato[i];
		return stockVirtualPlatos;
	}

	public static boolean comprobarStockVirtualBebidas(int[] stockVirtualBebidas, String nombreBebida) {
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length; i++) {
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				if (stockVirtualBebidas[i] > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static int[] reducirStockVirtualBebidas(int[] stockVirtualBebidas, String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockVirtualBebidas[i]--;
				encontrado = true;
			}
		return stockVirtualBebidas;
	}

	public static int[] aumentarStockVirtualBebidas(int[] stockVirtualBebidas, String nombreBebida) {
		boolean encontrado = false;
		for (int i = 0; i < Constantes.NOMBRES_BEBIDAS.length && !encontrado; i++)
			if (Constantes.NOMBRES_BEBIDAS[i].equals(nombreBebida)) {
				stockVirtualBebidas[i]++;
				encontrado = true;
			}
		return stockVirtualBebidas;
	}

}
