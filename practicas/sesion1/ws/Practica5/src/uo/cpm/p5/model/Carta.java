package uo.cpm.p5.model;

import java.util.*;


import uo.cpm.p5.util.FileUtil;

public class Carta {

	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;

	
	/**
	 * Inicializa la clase Carta con una lista de productos 
	 */
	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	/**
	 * Carga los archivos del fichero
	 */
	private void cargarArticulos() {
		FileUtil.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}
	
	
	/**
	 * Obtiene los productos que se encuentran en la carta
	 * @return articulos
	 */
	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}

	public Articulo[] getArticulos(String denominacion) {
		if(denominacion.equals("Todo")) return getArticulos();
		Articulo[] art = getArticulos();
		List<Articulo> retorno = new ArrayList<Articulo>();
		for(int i=0;i<art.length;i++) {
			if(art[i].getTipo().equals(denominacion)) {
				retorno.add(art[i]);
			}
		}
		int size = retorno.size();
		return retorno.toArray(new Articulo[size]);
	}

}
