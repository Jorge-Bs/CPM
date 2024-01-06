package castleBooker.model.booker;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import castleBooker.model.discount.Discount;
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
	private static Locale location;
	private List<Castle> castillos;
	private List<Castle> totalCastillos;
	private Persona usuario = new Persona();
	private Reserva reservaEnProgreso = new Reserva();
	private String[] encantamientos;
	int amountOfCastles;
	private Date date = new Date();
	

	public Booker() {
		setLocation(Locale.getDefault());
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
		loadCastle();
	}
	
	public static Locale getLocation() {
		return location;
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
		return castillos.get(index).info(recursos.getString("castilloStringInfo"));
	}
	
	public String getCastleInfo(String id) {
		ResourceBundle recursos = ResourceBundle.getBundle("rcs/text",getLocation());
		return getCastle(id).info(recursos.getString("castilloPrecio"));
	}
	
	public int amountOfEnchantments() {
		return encantamientos.length;
	}
	
	public String getEnchantment(int index) {
		return encantamientos[index];
	}


	public void setCastles(List<String> filtros,int dinero) {
		List<Castle> filtroMoney=new ArrayList<>();
		for(Castle castillo:totalCastillos) {
			if(castillo.getPrice()<=dinero) {
				filtroMoney.add(castillo);
			}
		}
		if(filtros!=null && filtros.size()!=0) {
			List<Castle> filtro=new ArrayList<>();
			for(Castle castillo:filtroMoney) {
				for(String tipo:filtros) {
					if(castillo.getEnchantment().contains(tipo)) {
						filtro.add(castillo);
						break;
					}
				}
			}
			this.castillos=filtro;
			this.amountOfCastles=filtro.size();
		}else {
			this.castillos=filtroMoney;
			this.amountOfCastles=filtroMoney.size();
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
	
	private double getDiscountPriceDouble() {
		if(hasActualUserDiscount()) {
			double value =  (reservaEnProgreso.getPrice()*(1-discountData.getDiscount(userId()).getAmount()));
			value = Math.round(value*100);
			return (value/100);
		}else {
			return reservaEnProgreso.getPrice();
		}
	}


	public String getDiscountPrice() {
		double value = getDiscountPriceDouble();
		return formateo(value);
	}
	
	static String formateo(double value) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/text", Booker.getLocation());
		NumberFormat precio = NumberFormat.getCurrencyInstance(Booker.getLocation());
		precio.setCurrency(Currency.getInstance(textos.getString("moneda")));
		return precio.format(value);
	}


	public void procesarReserva(boolean aplicarDescuento) {
		double value;
		if(aplicarDescuento && hasActualUserDiscount()) {
			value = getDiscountPriceDouble();
			discountData.remove(usuario.getDni());
		}else {
			value = reservaEnProgreso.getPrice();
		}
		reservaEnProgreso.setPrice(value);
		reservaEnProgreso.setFinished(true);
		reservaEnProgreso.setPersona(usuario);
		guardar();
	}
	
	private void guardar() {
		String value = reservaEnProgreso.serialize();
		FileUtil.save(value, RESERVA_FILEPATH,true);
	}


	public void saveDate(Date date) {
		usuario.saveDate(date);
	}


	@SuppressWarnings("deprecation")
	public boolean isAgeValid() {
		Date adult = new Date();
		adult.setYear(date.getYear()-18);
		if(usuario.getAge()==null) {
			return false;
		}
		return usuario.getAge().before(adult);
	}


	public boolean isMaxDiscount() {
		return game.getDiscount()==0.25;
	}


	public boolean camposValidos(String text) {
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		return true;
	}


	public boolean guardarDescuento(String id) {
		Discount type = Discount.getDiscountType(game.getDiscount());
		return (discountData.addDiscount(id, type));
	}


	public int maxPrice() {
		double value=0;
		for(Castle castillo:totalCastillos) {
			if(castillo.getPrice()>value) {
				value = castillo.getPrice();
			}
		}
		return (int) value;
	}


	public int minPrice() {
		double value=1000000;
		for(Castle castillo:totalCastillos) {
			if(castillo.getPrice()<value) {
				value = castillo.getPrice();
			}
		}
		return (int) value;
	}


	public String getPriceLocation() {
		return formateo(reservaEnProgreso.getPrice());
	}


	public void saveReserva(String path) {
		File archivo = new File(path+"/reserva.dat");
		ResourceBundle texto = ResourceBundle.getBundle("rcs/text", getLocation());
		String formato= texto.getString("formatoGuardado");
		String result = saveData(formato);
		FileUtil.save(result, archivo.getPath(), false);
	}
	
	private String saveData(String formato) {
		return reservaEnProgreso.getReservaToSave(formato);
	}

}
