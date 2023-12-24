package castleBooker.sevice;

import castleBooker.booker.Booker;
import castleBooker.game.Casilla;


public class App {

	private Booker booker = new Booker();
	
	public Casilla getCasilla(int fila,int columna) {
		return booker.getGame().getCasilla(fila, columna);
	}
	
	public void lanzar() {
		booker.getGame().lanzar();
	}
	
	public int getDiceValue() {
		return booker.getGame().getDiceValue();
	}
	
	public boolean isFinishedGame() {
		return booker.getGame().isFinished();
	}
	
	public boolean move(int location) {
		return booker.getGame().move(location);
	}

	public boolean canGetDiscount() {
		return booker.getGame().canGetDicount();
	}

	public double getDiscountValue() {
		return booker.getGame().getDiscount();
	}
	
	public double getDiscountValuePercentage() {
		return booker.getGame().getDiscount()*100;
	}
	
	public void inicializarJuego() {
		booker.getGame().inicializar();
	}
	
}
