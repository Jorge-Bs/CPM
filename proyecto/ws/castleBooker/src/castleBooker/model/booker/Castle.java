package castleBooker.model.booker;

public class Castle {
	
	private String code;
	private String name;
	private String description;
	private String country;
	private double price;
	private String enchantment;
	
	public Castle(String code,String name,String description,String country,double price,String enchantment) {
		setCode(code);
		setName(name);
		setDescription(description);
		setCountry(country);
		setPrice(price);
		setEnchantment(enchantment);
	}

	protected void setCode(String code) {
		this.code = code;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	protected void setPrice(double price) {
		this.price = price;
	}

	protected void setEnchantment(String enchantment) {
		this.enchantment = enchantment;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCountry() {
		return country;
	}

	public double getPrice() {
		return price;
	}

	public String getEnchantment() {
		return enchantment;
	}
	
	public String toStringDescriptionAndWithoutPrice(String formato) {
		formato=info(formato);
		formato=formato.replaceFirst("@", getDescription());
		return formato;
	}
	
	private String info(String formato) {
		formato=formato.replaceFirst("@", getName());
		formato=formato.replaceFirst("@", getCountry());
		formato=formato.replaceFirst("@", getEnchantment());
		return formato;
	}
	
	public String toStringPriceAndWithoutDescription(String formato) {
		formato=info(formato);
		formato=formato.replaceFirst("@", getPrice()+"");
		return formato;
	}
	
	@Override
	public boolean equals(Object e) {
		if(e==this) {
			return true;
		}else {
			if(!(e instanceof Castle)) {
				return false;
			}
			else {
				Castle cas = (Castle)e;
				return this.getCode().equals(cas.getCode());
			}
		}
	}
		

}
