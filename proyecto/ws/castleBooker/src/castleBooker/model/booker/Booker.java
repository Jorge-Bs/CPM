package castleBooker.model.booker;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import castleBooker.model.discount.DiscountData;
import castleBooker.model.game.Game;
import util.CastleFileUtil;

public class Booker {

	private static final String FILE_PATH="files/";
	private Game game = new Game();
	private DiscountData discountData = new DiscountData();
	private Locale location = new Locale("es");
	private List<Castle> castillos;
	int amountOfCastles;
	

	public Booker() {
		loadCastle();
	}
	
	
	public Game getGame() {
		return game;
	}
	
	public DiscountData getDiscounts() {
		return discountData;
	}
	
	public Locale getLocation() {
		return this.location;
	}
	
	public void loadCastle() {
		ResourceBundle recursos = ResourceBundle.getBundle("rcs/text",getLocation());
		loadCastle(recursos.getString("castillo"));
	}

	private void loadCastle(String string) {
		List<Castle> castillos = CastleFileUtil.readCastleFile(FILE_PATH+string);
		if(castillos==null) {
			throw new NullPointerException("La carga de castillos ha producido un error");
		}
		this.castillos=castillos;
		this.amountOfCastles=castillos.size();
	}
	
	public Castle getCastle(int position) {
		return castillos.get(position);
	}
	
	
}
