package castleBooker.model.booker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import castleBooker.model.discount.DiscountData;
import castleBooker.model.game.Game;
import util.CastleFileUtil;
import util.FileUtil;

public class Booker {

	public static final int AMOUNT_OF_YEARS_AVAILABLES=5;
	private static final String FILE_PATH="files/";
	private static final String RESERVA_FILEPATH=FILE_PATH+"reservas.dat";
	private Game game = new Game();
	private DiscountData discountData = new DiscountData();
	private Locale location;
	private List<Castle> castillos;
	private List<Castle> totalCastillos;
	private List<Reserva> reservas = new ArrayList<>();
	private Persona usuario = new Persona();
	private Reserva reservaEnProgreso = new Reserva();
	private String[] encantamientos;
	int amountOfCastles;
	private Date date = new Date();
	

	public Booker() {
		setLocation(new Locale("es"));
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
	
	public void setLocation(Locale location) {
		Locale.setDefault(location);
		this.location=location;
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
	
	public Castle getCastle(String id) {
		for(Castle castillo:castillos) {
			 if(castillo.getCode().equals(id)) {
				 return castillo;
			 }
		}
		throw new IllegalArgumentException("El castillo con identificado: "+id+" no se ha podido encontrar");
	}
	
	public int getAmountOfData() {
		return amountOfCastles;
	}


	public String getCastleInfo(int index) {
		ResourceBundle recursos = ResourceBundle.getBundle("rcs/text",getLocation());
		return castillos.get(index).toStringDescriptionAndWithoutPrice(recursos.getString("castilloStringInfo"));
	}
	
	public String getCastleInfo(String id) {
		ResourceBundle recursos = ResourceBundle.getBundle("rcs/text",getLocation());
		return getCastle(id).toStringPriceAndWithoutDescription(recursos.getString("castilloPrecio"));
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


	public void iniciarReserva(String id) {
		reservaEnProgreso.cambiarCastillo(getCastle(id));
	}
	
	public void inicializarReservaActual() {
		reservaEnProgreso.inicializar();
	}
	
	public void inicializarPersona() {
		if(usuario==null) {
			return;
		}else {
			usuario.inicializar();
		}
	}


	public void inicializar() {
		inicializarReservaActual();
		inicializarPersona();
	}


	public double getPrice() {
		return reservaEnProgreso.getPrice();
	}


	public Date getActualDate() {
		return date;
	}
	
	public void updateRooms(int value) {
		reservaEnProgreso.updateRooms(value);
	}
	public void updatePeople(int value) {
		reservaEnProgreso.updatePeople(value);
	}
	public void updateDays(int value) {
		reservaEnProgreso.updateDays(value);
	}


	public int getRoomsInfo() {
		return reservaEnProgreso.getAmountOfRooms();
	}


	public int getPeopleInfo() {
		return reservaEnProgreso.getAmountOfPeople();
	}


	public int getDaysInfo() {
		return reservaEnProgreso.getAmountOfDays();
	}


	public boolean habitacionesValidas() {
		return reservaEnProgreso.valida();
	}


	public void saveId(String id) {
		usuario.setDni(id);
	}


	public String userId() {
		return usuario.getDni();
	}


	public void updatePersonalData(String name, String id, String email, String comments) {
		usuario.setFullName(name);
		usuario.setDni(id);
		usuario.setEmail(email);
		reservaEnProgreso.setComment(comments);
	}


	public boolean hasActualUserDiscount() {
		return discountData.hasDiscount(usuario.getDni());
	}


	public String getCastleReserva() {
		return reservaEnProgreso.getCastle().getName();
	}


	public String getUserName() {
		return usuario.getFullName();
	}


	public String getEmail() {
		return usuario.getEmail();
	}


	public String arriveDate() {
		return reservaEnProgreso.getArrive();
	}


	public void updateArrive(Date date) {
		reservaEnProgreso.setArrive(date);
		
	}


	public String getDiscountPrice() {
		if(hasActualUserDiscount()) {
			double value =  (reservaEnProgreso.getPrice()*(1-discountData.getDiscount(userId()).getAmount()));
			value = Math.round(value*100);
			return (value/100)+"";
		}else {
			return reservaEnProgreso.getPrice()+"";
		}
	}


	public void procesarReserva(boolean aplicarDescuento) {
		double value;
		if(aplicarDescuento && hasActualUserDiscount()) {
			value = Double.parseDouble(getDiscountPrice());
		}else {
			value = reservaEnProgreso.getPrice();
		}
		reservaEnProgreso.setPrice(value);
		reservaEnProgreso.setFinished(true);
		reservaEnProgreso.setPersona(usuario);
		guardar();
		inicializar();
	}
	
	private void guardar() {
		String value = reservaEnProgreso.serialize();
		FileUtil.save(value, RESERVA_FILEPATH);
	}

}
