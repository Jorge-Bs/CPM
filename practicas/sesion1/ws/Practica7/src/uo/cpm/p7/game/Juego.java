package uo.cpm.p7.game;

import uo.cpm.p7.model.*;

public class Juego {
	
	public static Dificultad DIFI= Dificultad.MEDIO;
	public static  int maxDisparos = 4;
	public static int puntos;
	int disparos;
	private Tablero tablero; 
	private String enemigoEncontrado;
	
	
	public Juego(){
		inicializarJuego();
	}

	public void inicializarJuego(){
		setMaxDisparos(DIFI);
		tablero = new Tablero(DIFI);
		puntos = 1000;
		disparos = 0;
		enemigoEncontrado="Ninguno";
		}
	
	private void setMaxDisparos(Dificultad difi) {
		switch(difi) {
		case FACIL:
			maxDisparos=5;
			break;
		case MEDIO:
			maxDisparos=4;
			break;
		case DIFICIL:
			maxDisparos=3;
			break;
		}
		
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
	
	public int size() {
		return tablero.size();
	}

	public void setDificultad(String dificultad) {
		switch(dificultad) {
		case "facil":
			DIFI = Dificultad.FACIL;
			break;
		case "medio":
			DIFI = Dificultad.MEDIO;
			break;
		case "dificil":
			DIFI= Dificultad.DIFICIL;
			break;
		}
	}
}
