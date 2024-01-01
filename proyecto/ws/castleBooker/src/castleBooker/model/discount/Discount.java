package castleBooker.model.discount;

public enum Discount {

	EXTRA25(0.25,"EXTRA25"), EXTRA10(0.10,"EXTRA10");
	
	private double value;
	private String code;

	Discount(double value, String code) {
		this.value =value;
		this.code=code;
	}
	
	public static Discount getDiscountType(double value) {
		Discount[] tipos = values();
		for(Discount tipo:tipos) {
			if(tipo.getAmount()==value) {
				return tipo;
			}
		}
		return null;
	}
	
	public double getAmount() {
		return value;
	}
	
	public String getCode() {
		return code;
	}
}
