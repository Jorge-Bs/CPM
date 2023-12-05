package uo.cpm.p11.service;

import uo.cpm.p11.model.*;

public class McDonalds {
	Carta carta = new Carta();
	Pedido pedido = new Pedido(); 
	
	public McDonalds() {
		//inicializarPedido();
	}

	public Articulo[] getArticulosCarta() {
			return carta.getArticulos();
	}
	
   public Articulo getArticulo(int i) {
	   return carta.getListaArticulos().get(i);
   }
	
	public void inicializarPedido() {
		pedido.inicializar();
	}
	
	public void añadirAPedido(Articulo articulo, int unidades) {
		pedido.add(articulo, unidades);
	
	}
	public void remove(Articulo articulo, int unidades) {
		pedido.remove(articulo, unidades);
	}

	public float getTotalPedido() {
		return pedido.getTotal();
	}
 
	public void grabarPedido() {
		pedido.grabarPedido();
	}

	public int buscarUnidades(Articulo a) {
		return pedido.buscarUnidades(a);
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public String getTextoPedido() {
		return pedido.toString();
	}
}
