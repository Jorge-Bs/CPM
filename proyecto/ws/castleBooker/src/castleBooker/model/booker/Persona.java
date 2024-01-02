package castleBooker.model.booker;

import java.util.Date;

public class Persona {
	
	private String dni;
	private String fullName;
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	private String email;
	private Date age;
	
	public Persona() {
		
	}
	
	public Persona(String dni) {
		setDni(dni);
	}
	
	public Persona(String dni,String fullName,int dayOfBirth,int monthOfBirth,int yearOfBirth,String email) {
		this(dni);
		setFullName(fullName);
		setDayOfBirth(dayOfBirth);
		setMonthOfBirth(monthOfBirth);
		setYearOfBirth(yearOfBirth);
		setEmail(email);
	}
	
	

	protected String getFullName() {
		return fullName;
	}

	protected void setFullName(String fullName) {
		this.fullName = fullName;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected int getDayOfBirth() {
		return dayOfBirth;
	}

	protected void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	protected int getMonthOfBirth() {
		return monthOfBirth;
	}

	protected void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	protected int getYearOfBirth() {
		return yearOfBirth;
	}

	protected void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public void inicializar() {
		setDni(null);
		setFullName(null);
		setDayOfBirth(0);
		setMonthOfBirth(0);
		setYearOfBirth(0);
		setEmail(null);
		saveDate(null);
	}
	
	void saveDate(Date age) {
		this.age=age;
	}

	Date getAge() {
		return age;
	}
	
	
	

}
