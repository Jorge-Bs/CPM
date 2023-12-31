package castleBooker.sevice;

import java.util.Date;
import java.util.List;
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
	
	public int getAmountOfData() {
		return booker.getAmountOfData();
	}

	public String getCastleImage(int index) {
		return booker.getCastle(index).getCode();
	}
	
	public String getCastleDecription(String id) {
		return booker.getCastle(id).getDescription();
	}
	
	public String getInfo(int index) {
		return booker.getCastleInfo(index);
	}
	
	public int getAmountOfEnchantments() {
		return booker.amountOfEnchantments();
	}
	
	public String getEnchantment(int index) {
		return booker.getEnchantment(index);
	}

	public void setCastles(List<String> filtros) {
		booker.setCastles(filtros);
	}

	public String getCastleInfo(String id) {
		return booker.getCastleInfo(id);
	}

	public void iniciarReserva(String id) {
		booker.iniciarReserva(id);
	}

	public void inicializar() {
		booker.inicializar();
	}

	public double getPrice() {
		return booker.getPrice();
	}

	public Date getDate() {
		return booker.getActualDate();
	}

	public int getRoomsInfo() {
		return booker.getRoomsInfo();
	}

	public int getPeopleInfo() {
		return booker.getPeopleInfo();
	}

	public int getDaysInfo() {
		return booker.getDaysInfo();
	}

	public boolean habitacionesValidas() {
		return booker.habitacionesValidas();
	}

	public void saveId(String id) {
		booker.saveId(id);
		
	}

	public String getUserId() {
		return booker.userId();
	}

	public void updateDate(Integer rooms, Integer people, Integer days,Date date) {
		booker.updateRooms(rooms);
		booker.updatePeople(people);
		booker.updateDays(days);
		booker.updateArrive(date);
	}
	
	public void updatePersonalData(String name, String id, String email, String comments) {
		booker.updatePersonalData(name,id,email,comments);
	}

	public boolean hasActualUserDiscount() {
		return booker.hasActualUserDiscount();
	}

	public String getCatleReserva() {
		return booker.getCastleReserva();
	}

	public String getUserName() {
		return booker.getUserName();
	}

	public String getUserEmail() {
		return booker.getEmail();
	}

	public String getArriveDate() {
		return booker.arriveDate();
	}

	public String getDiscountPrice() {
		return booker.getDiscountPrice();
	}

	public void procesarReserva(boolean aplicarDescuento) {
		booker.procesarReserva(aplicarDescuento);
	}
	
	
}
