package uo.cpm.p4.model;

import java.util.*;

import uo.cpm.p4.util.FileUtil;

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

}
