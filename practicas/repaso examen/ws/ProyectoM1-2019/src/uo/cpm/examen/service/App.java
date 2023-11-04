package uo.cpm.examen.service;

import uo.cpm.examen.model.Articulo;
import uo.cpm.examen.model.Juego;

public class App {
	
	private Juego game = new Juego();
	
	public void lanzar() {
		game.lanzar();
	}
	
	public float getPoitns() {
		return game.getPoints();
	}
	
	public Articulo[] getArticulos() {
		return game.articulos();
	}
	
	public Articulo[] getArticulos(String denominacion) {
		return game.articulosDenominacion(denominacion);
	}
	
	public String pedido() {
		return game.pedido();
	}
	
	public int add(Articulo art, int units) {
		return game.addArticulo(art, units);
	}
	
	public String getPedido() {
		return game.pedido();
	}
	
	public void inicializar() {
		game.inicializar();
	}


}
