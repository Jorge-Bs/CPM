package uo.cpm.p7.model;

public class Tablero {
	private static final boolean POSITION=true;
	
	public static int DIM = 8;
	Casilla[] casillas;
	
	public Tablero(Dificultad dim) {
		setDim(dim);
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio();
		colocaDificultad(dim);
		}

	private void setDim(Dificultad dim) {
		switch(dim) {
		case FACIL:
			DIM=10;
			break;
		case MEDIO:
			DIM=8;
			break;
		case DIFICIL:
			DIM=6;
			break;
		}
		
	}

	private void colocaDificultad(Dificultad dim) {
		switch(dim) {
		case FACIL:
			colocaInvasor(2);
			colocarMeteoro(0);
			break;
		case MEDIO:
			colocaInvasor(1);
			colocarMeteoro(1);
			break;
		case DIFICIL:
			colocaInvasor(1);
			colocarMeteoro(2);
			break;
		}
	}

	private void colocaInvasor(int value) {
		for(int i=0;i<value;i++) {
			int posicionInvasor = (int) (Math.random() * DIM);
			casillas[posicionInvasor] = new Invasor();	
			if(POSITION)System.out.println("Posicion alien = "+posicionInvasor);
		}
	}
	
	private void colocarMeteoro(int value) {
		for(int i=0;i<value;i++) {
			int posicionMeteoro = (int) (Math.random() * DIM);
			if(casillas[posicionMeteoro].getTipo().equals("Espacio")) {
				casillas[posicionMeteoro] = new Meteoro();
				if(POSITION)System.out.println("Posicion meteoro = "+posicionMeteoro);
			}
			else colocarMeteoro(1);
		}
	}
	
	
	public Casilla[] getCasillas() {
		return casillas;
	}
	
	public String obtenerImagen(int i) {
		return casillas[i].getImagen();
	}
	
	public int size() {
		return casillas.length;
	}
}
