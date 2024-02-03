package castleBooker.model.booker;

import java.util.Date;
import java.util.Locale;

/**
 * @author jorge
 *
 */
public class Reserva {

	private Persona persona;
	private int amountOfPeople;
	private int amountOfDays;
	private int amountOfRooms;
	private double price;
	private Castle castle;
	private boolean isFinished = false;
	private String comment;
	private Date arrive;
	
	public Reserva() {
		inicializar();
	}

	protected Persona getPersona() {
		return persona;
	}

	protected void setPersona(Persona persona) {
		this.persona = persona;
	}


	protected int getAmountOfPeople() {
		return amountOfPeople;
	}

	protected int getAmountOfRooms() {
		return amountOfRooms;
	}

	protected void setAmountOfRooms(int amountOfRooms) {
		this.amountOfRooms = amountOfRooms;
	}

	protected void setAmountOfPeople(int amountOfPersons) {
		this.amountOfPeople = amountOfPersons;
	}

	protected int getAmountOfDays() {
		return amountOfDays;
	}

	protected void setAmountOfDays(int amountOfDays) {
		this.amountOfDays = amountOfDays;
	}

	protected double getPrice() {
		if(isFinished()) {
			return price;
		}else {
			return price*getAmountOfDays()*getAmountOfRooms();
		}
	}

	protected void setPrice(double price) {
		this.price = price;
	}

	protected Castle getCastle() {
		return castle;
	}

	protected void setCastle(Castle castle) {
		this.castle = castle;
	}
	

	protected boolean isFinished() {
		return isFinished;
	}

	protected void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	protected String getComment() {
		if(comment==null) {
			return "";
		}
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

	public void inicializar() {
		setCastle(null);
		setPersona(null);
		setAmountOfPeople(1);
		setAmountOfDays(1);
		setAmountOfRooms(1);
		setPrice(0);
		setFinished(false);
		setComment("");
		setArrive(null);
	}
	
	public void cambiarCastillo(Castle castle) {
		setCastle(castle);
		setPrice(castle.getPrice());
	}
	
	void updateRooms(int value) {
		setAmountOfRooms(value);
	}
	
	void updatePeople(int value) {
		setAmountOfPeople(value);
	}
	
	 void updateDays(int value) {
		setAmountOfDays(value);
	}

	public boolean valida() {
		if(amountOfRooms==amountOfPeople) {
			return true;
		}if(amountOfPeople>amountOfRooms) {
			return (amountOfPeople/amountOfRooms)<=2;
		}
		else {
			return false;
		}
	}

	public void setArrive(Date date) {
		this.arrive=date;
		
	}
	
	String getArrive() {
		@SuppressWarnings("deprecation")
		String date = arrive.toLocaleString();
		String[] parts = date.split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(parts[0]+" ");
		sb.append(parts[1]+" ");
		if(Locale.getDefault().getISO3Language().equals("eng")) {
			parts[2]=parts[2].replace(",", ".");
		}
		sb.append(parts[2]+" ");
		return sb.toString();
	}

	String serialize() {
		StringBuilder sb = new StringBuilder();
		sb.append(persona.getDni()+";");
		sb.append(persona.getFullName()+";");
		sb.append(persona.getEmail()+";");
		sb.append(castle.getCode()+";");
		sb.append(getArrive()+";");
		sb.append(getAmountOfDays()+";");
		sb.append(getAmountOfRooms()+";");
		sb.append(getPrice()+";");
		sb.append(getComment());
		return sb.toString();
	}

	public String getReservaToSave(String formato) {
		formato = formato.replaceFirst("@", persona.getFullName());
		formato = formato.replaceFirst("@", persona.getDni());
		formato = formato.replaceFirst("@", persona.getEmail());
		formato = formato.replaceFirst("@", getPrice()+"");
		formato = formato.replaceFirst("@", getCastle().getName());
		formato = formato.replaceFirst("@", getCastle().getCountry());
		formato = formato.replaceFirst("@", getArrive());
		formato = formato.replaceFirst("@", getAmountOfDays()+"");
		formato = formato.replaceFirst("@", getAmountOfRooms()+"");
		formato = formato.replaceFirst("@", getComment());
		return formato;
	}
	
}
