package castleBooker.model.booker;

/**
 * @author jorge
 *
 */
public class Reserva {

	private Persona persona;
	private int amountOfPersons;
	private int amountOfDays;
	private int amountOfRooms;
	private double price;
	private Castle castle;
	private boolean isFinished = false;
	private String comment;
	
	public Reserva(Castle catillo) {
		setCastle(catillo);
	}

	protected Persona getPersona() {
		return persona;
	}

	protected void setPersona(Persona persona) {
		this.persona = persona;
	}


	protected int getAmountOfPersons() {
		return amountOfPersons;
	}

	protected int getAmountOfRooms() {
		return amountOfRooms;
	}

	protected void setAmountOfRooms(int amountOfRooms) {
		this.amountOfRooms = amountOfRooms;
	}

	protected void setAmountOfPersons(int amountOfPersons) {
		this.amountOfPersons = amountOfPersons;
	}

	protected int getAmountOfDays() {
		return amountOfDays;
	}

	protected void setAmountOfDays(int amountOfDays) {
		this.amountOfDays = amountOfDays;
	}

	protected double getPrice() {
		return price*getAmountOfDays()*getAmountOfRooms();
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
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

	public void inicializar() {
		setCastle(null);
		setPersona(null);
		setAmountOfPersons(1);
		setAmountOfDays(1);
		setPrice(0);
		setFinished(false);
		setComment("");
	}
	
	public void cambiarCastillo(Castle castle) {
		setCastle(castle);
		setPrice(castle.getPrice());
	}
	
	
	
}
