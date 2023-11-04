package uo.cpm.examen.model;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.examen.util.FileUtil;

public class Juego {
	
	private static final String path = "files/premios.dat";
	private float points;
	private List<Articulo> productos = new ArrayList<>();
	private Ruleta ruleta = new Ruleta();
	private List<Articulo> pedido = new ArrayList<>();
	
	public Juego() {
		points = 0;
		cargarLista();
	}
	
	private void cargarLista() {
		FileUtil.loadFile(path, productos);
	}
	
	public void lanzar() {
		points = ruleta.lanzamiento();
	}
	
	public float getPoints() {
		return points;
	}
	
	public Articulo[] articulos() {
		return productos.toArray(new Articulo[productos.size()]);
	}
	
	public Articulo[] articulosDenominacion(String denominacion) {
		List<Articulo> result = new ArrayList<Articulo>();
		for(Articulo articulo: productos) {
			if(articulo.getType().equals(denominacion)) {
				result.add(articulo);
			}
		}
		return result.toArray(new Articulo[result.size()]);
	}
	
	public String pedido() {
		StringBuilder sb = new StringBuilder();
		for(Articulo art:pedido) {
			sb.append(art.toStringWithCantidad()+"\n");
		}
		return sb.toString();
	}
	
	public int addArticulo(Articulo articulo,int units) {
		float points = getPoints()-articulo.getPoints()*units;
		if(points<0) return -1;
		if(pedido.contains(articulo)) {
			int index =pedido.indexOf(articulo);
			pedido.get(index).setCantidad(pedido.get(index).getCantidad()+units);
			this.points=points;
		}else {
			articulo.setCantidad(units);
			pedido.add(articulo);
			this.points=points;
		}
		return 0;
	}

	public void inicializar() {
		pedido.clear();
		points=0;
		
	}
	
	
}
