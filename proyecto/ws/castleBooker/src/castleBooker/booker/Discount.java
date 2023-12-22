package castleBooker.booker;

public enum Discount {

	EXTRA25(0.25,"EXTRA25"), EXTRA10(0.10,"EXTRA10");
	
	private double value;
	private String code;

	Discount(double value, String code) {
		this.value =value;
		this.code=code;
	}
	
	
	
	public double getAmount() {
		return value;
	}
	
	public String getCode() {
		return code;
	}
}
