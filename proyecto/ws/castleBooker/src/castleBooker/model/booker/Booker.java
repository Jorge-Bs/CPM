package castleBooker.model.booker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import castleBooker.model.discount.DiscountData;
import castleBooker.model.game.Game;
import util.CastleFileUtil;

public class Booker {

	private static final String FILE_PATH="files/";
	private Game game = new Game();
	private DiscountData discountData = new DiscountData();
	private Locale location = new Locale("en");
	private List<Castle> castillos;
	private List<Castle> totalCastillos;
	private String[] encantamientos;
	int amountOfCastles;
	

	public Booker() {
		loadCastle();
		loadEncatamientos();
	}
	
	
	private void loadEncatamientos() {
		Set<String> encantamientos = new TreeSet<>();
		for(Castle castillo:castillos) {
			String[] encanta=castillo.getEnchantment().split("-");
			for(String tipo:encanta) {
				encantamientos.add(tipo);
			}
		}
		String enca=encantamientos.toString().replace(" ", "");
		enca=enca.replace("[","");
		enca=enca.replace("]","");
		this.encantamientos=enca.split(",");
		return;
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
		this.totalCastillos=castillos;
		this.amountOfCastles=castillos.size();
	}
	
	public Castle getCastle(int position) {
		return castillos.get(position);
	}
	
	public int getAmountOfData() {
		return amountOfCastles;
	}


	public String getCastleInfo(int index) {
		ResourceBundle recursos = ResourceBundle.getBundle("rcs/text",getLocation());
		return castillos.get(index).toString(recursos.getString("castilloStringInfo"));
	}
	
	public int amountOfEnchantments() {
		return encantamientos.length;
	}
	
	public String getEnchantment(int index) {
		return encantamientos[index];
	}


	public void setCastles(List<String> filtros) {
		if(filtros!=null && filtros.size()!=0) {
			List<Castle> filtro=new ArrayList<>();
			for(String tipo:filtros) {
				for(Castle castillo:totalCastillos) {
					if(castillo.getEnchantment().contains(tipo)) {
						filtro.add(castillo);
					}
				}
			}
			this.castillos=filtro;
			this.amountOfCastles=filtro.size();
		}else {
			this.castillos=totalCastillos;
			this.amountOfCastles=totalCastillos.size();
		}
	}
}
