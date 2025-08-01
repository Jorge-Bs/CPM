package uo.cpm.p3.model;

import java.util.*;

import uo.cpm.p3.util.FileUtil;


public class Pedido {

	private List<Articulo> listaPedido;
	private String codigo;
	

	/**
	 * Inicializa el pedido
	 */
	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	/**
	 * Establece la lista de pedidos a 0 y genra un codigo para el pedido
	 */
	public void inicializar() {
		listaPedido.clear();
		generarCodigo();
			}

	/**
	 * Añade el articulo al pedido , se necesita las unidades a añadir
	 * @param articuloDelCatalogo
	 * @param unidades
	 */
	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
	}

	/**
	 * Devuelve el precio del pedido
	 * @return precio
	 */
	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido) {
			precio += a.getPrecio() * a.getUnidades();
		}
		if (precio >= 60) {
			precio = (precio * 0.9F);
			}
		return precio;
	}

	/**
	 * guarda en un archivo de nombre el codigo la lista de pedidos
	 */
	public void grabarPedido() {
		FileUtil.saveToFile(codigo, listaPedido);
	}

	/**
	 * Devuelve la lista de pedidos
	 * @return lista  de pedidos
	 */
	public List<Articulo> getListaPedido() {
		return listaPedido;
	}

	
	/**
	 * La lista que se de por paramtro se establece como la lista de productos del pedido
	 * @param listaPedido
	 */
	public void setListaPedido(List<Articulo> listaPedido) {
		this.listaPedido = listaPedido;
	}

	/**
	 * Devuelve el codigo del pedido
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Genera de forma aleatoria un codigo para el pedido
	 */
	public void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);
		}
	}

	public int getAmount(Articulo articulo) {
		List<Articulo> arti = getListaPedido();
		for(Articulo ar:arti) {
			if(ar.equals(articulo)) return ar.getUnidades();
		}
		return 0;
	}
	
	
}
