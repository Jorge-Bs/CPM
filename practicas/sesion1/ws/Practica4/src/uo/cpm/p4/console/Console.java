package uo.cpm.p4.console;

import java.util.Scanner;

import uo.cpm.p4.model.Articulo;
import uo.cpm.p4.model.Carta;
import uo.cpm.p4.model.Pedido;

public class Console {

	private Carta carta = new Carta();
	private Pedido pedido = new Pedido();
	Scanner teclado = new Scanner(System.in);
	
	public void run() {
		display();
	}
	
	private void display() {
		
		
		boolean exit = false;
		do {
			showMenu();
			switch(teclado.nextInt()) {
			case 0:
				exit=true; break;
			case 1:
				showCarta(); break;
			case 2:
				addPedido(); break;
			case 3:
				showPedido(); break;
			case 4:
				procesarPedido();break;
			}
		}while(!exit);

	}
	
	private void addPedido() {
		int product=-1;
		int amount=0;
		print("Inserte el numero del producto:");
		product=teclado.nextInt();
		print("Inserte la cantidad");
		amount=teclado.nextInt();
		pedido.add(getArticuloCarta(product), amount);
	}
	
	
	
	
	private void showPedido() {
		print("El precio total es de: "+pedido.getTotal());
		print("Su pedido contiene los siguietes productos:");
		print(pedido.getListaPedido().toString());
	}
	
	private void procesarPedido() {
		showPedido();
		print("Presione 1 para confirmar el pedido, otro numero en caso contrario");
		switch(teclado.nextInt()) {
		case 1:
			pedido.grabarPedido();
			confirmar();
		}
	}
	
	
	
	private void showMenu() {
		print("Bienvenido");
		print("1-Consultar Carta");
		print("2-Añadir producto al pedido");
		print("3-Consultar su pedido");
		print("4-Procesar su pedido");
		print("0 - Salir");
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private void showCarta() {
		Articulo[] articulos = carta.getArticulos();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<articulos.length;i++) {
			sb.append((i+1)+"-"+articulos[i]+".\n");
		}
		print(sb.toString());
	}
	
	private Articulo getArticuloCarta(int n) {
		return  carta.getArticulos()[n-1];
	}
	
	private void confirmar() {
		print("Su pedido ha sido confirmado con el siguiente codigo: "+pedido.getCodigo());
		print("Hasta la proxima");
		pedido.inicializar();
	}
}
