package castleBooker.model.booker;

import java.util.Date;

public class Persona {
	
	private String dni;
	private String fullName;
	private String email;
	private Date age;
	
	public Persona() {
		
	}
	
	public Persona(String dni) {
		setDni(dni);
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

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public void inicializar() {
		setDni(null);
		setFullName(null);
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
