package castleBooker.sevice;

import castleBooker.booker.Booker;
import castleBooker.game.Casilla;


public class App {

	private Booker booker = new Booker();
	
	public Casilla getCasilla(int fila,int columna) {
		return booker.getGame().getCasilla(fila, columna);
	}
}
