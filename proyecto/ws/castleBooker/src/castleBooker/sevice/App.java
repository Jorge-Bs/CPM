package castleBooker.sevice;

import java.util.Locale;

import castleBooker.model.booker.Booker;
import castleBooker.model.game.Casilla;


public class App {

	private Booker booker = new Booker();
	
	public Locale getLocation() {
		return booker.getLocation();
	}
	
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
	
	public boolean hasDiscount(String key) {
		return booker.getDiscounts().hasDiscount(key);
	}

	public double consultDiscount(String key) {
		return booker.getDiscounts().consultDiscount(key);
	}
	
}
