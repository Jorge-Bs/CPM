package uo.cpm.p7.service;

import uo.cpm.p7.game.Juego;
import uo.cpm.p7.model.Tablero;

public class SpaceInvaders {

	private Juego juego = new Juego();

	public Tablero getTablero()
	{
		return juego.getTablero();
	}

	public void inicializar()
	{
		juego.inicializarJuego();
	}

	public void dipara(int i)
	{
		juego.dispara(i);
	}

	public boolean isPartidaFinalizada()
	{
		return juego.isPartidaFinalizada();
	}
	
	public int getPuntuacion()
	{
		return juego.getPuntos();
	}

	public void lanzarDado()
	{
		juego.lanzar();
	}

	public int getDisparos()
	{
		return juego.getDisparos();
	}

	public String obtenerImagen(int i) 
	{
		return juego.obtenerImagen(i);
	}
	
	public String getEndMessage() {
		return juego.getEnemigoEncontrado();
	}
	
	public int size() {
		return juego.size();
	}
	
	
	public void setDificultad(String dificultad) {
		juego.setDificultad(dificultad);
	}

}