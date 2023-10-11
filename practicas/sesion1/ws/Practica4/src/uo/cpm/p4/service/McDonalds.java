package uo.cpm.p4.service;

import uo.cpm.p4.model.*;

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
	
	public int getAmountOfProduct(Articulo articulo) {
		 return pedido.getAmount(articulo);
	}

	public String getPedido() {
		return pedido.getPedido();
	}

	public void eliminarProductos(int amount,Articulo articulo) {
		pedido.eliminarProductos(amount,articulo);
	}
	
	public boolean hasDiscount() {
		return pedido.isDiscount();
	}
	
	public void setLlevar(boolean llevar) {
		pedido.setLlevar(llevar);
	}
}
