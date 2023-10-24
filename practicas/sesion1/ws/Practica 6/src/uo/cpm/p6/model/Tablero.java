package uo.cpm.p6.model;

public class Tablero {
	
	public static final int DIM = 8;
	Casilla[] casillas;
	private int invasor;
	
	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio();
		colocaInvasor();
		colocarMeteoro();
		}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		invasor= posicionInvasor;
		casillas[posicionInvasor] = new Invasor();	
	}
	
	private void colocarMeteoro() {
		int posicionMeteoro = (int) (Math.random() * DIM);
		if(posicionMeteoro!=invasor) casillas[posicionMeteoro] = new Meteoro();
		else colocarMeteoro();
	}
	
	
	public Casilla[] getCasillas() {
		return casillas;
	}
	
	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
}
