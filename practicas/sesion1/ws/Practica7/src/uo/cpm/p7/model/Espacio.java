package uo.cpm.p7.model;

public class Espacio extends Casilla {

	public Espacio() {
		setPuntos(-200);
		setTipo("Espacio");
		setImagen("/img/space.jpg");
	}
	public int descubrir () {
		return getPuntos();
		
	}
	public  boolean isEncontrado() {
	    return false;
	}
	
}