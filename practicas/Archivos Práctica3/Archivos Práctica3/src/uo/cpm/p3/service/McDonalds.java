package uo.cpm.p3.service;

import uo.cpm.p3.model.*;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	
	public McDonalds() {
		inicializarPedido();
	}

	public Articulo[] getArticulosCarta() {
		return carta.getArticulos();
	}
	
	public void inicializarPedido() {
		pedido.inicializar();
	}
	
	public String getCodigoPedido() {
		return pedido.getCodigo();
	}

	public void añadirAPedido(Articulo articulo, int unidades) {
		pedido.add(articulo, unidades);
	}

	public float getTotalPedido() {
		return pedido.getTotal();
	}
 
	public void grabarPedido() {
		pedido.grabarPedido();
	}



}
