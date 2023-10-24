package uo.cpm.p6.game;

import uo.cpm.p6.model.*;

public class Juego {
	
	public static final int maxDisparos = 4;
	public static int puntos;
	int disparos;
	private Tablero tablero; 
	private String enemigoEncontrado;
	
	
	public Juego(){
		inicializarJuego();
	}

	public void inicializarJuego(){
		tablero = new Tablero();
		puntos = 1000;
		disparos = 0;
		enemigoEncontrado="Ninguno";
		}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public String getEnemigoEncontrado() {
		return enemigoEncontrado;
	}

	public void setEnemigoEncontrado(String enemigoEncontrado) {
		this.enemigoEncontrado = enemigoEncontrado;
	}
	
	public void dispara(int i){
		disparos --;
		puntos += tablero.getCasillas()[i].descubrir();
		if (tablero.getCasillas()[i].isEncontrado())
			setEnemigoEncontrado(tablero.getCasillas()[i].getTipo());
		if(enemigoEncontrado.equals("Meteoro")) puntos=0;
		
	}
	
	public boolean isPartidaFinalizada() {
		return (getEnemigoEncontrado().equals("Invasor")||getEnemigoEncontrado().equals("Meteoro") || disparos == 0) ;
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar());	
	}
	
	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}
	
	public String obtenerImagen(int i) {
		return getTablero().obtenerImagen(i);
		
	}
}
