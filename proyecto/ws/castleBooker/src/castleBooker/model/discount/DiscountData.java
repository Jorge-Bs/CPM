package castleBooker.model.discount;

import java.util.HashMap;

import util.DiscountFileUtil;

public class DiscountData {
	
	private HashMap<String, Discount> descuentos = new HashMap<>();
	
	private static final String FILE_NAME="files/descuentos.dat";
	
	public DiscountData() {
		loadData();
		saveFile();
	}
	
	public boolean addDiscount(String key,Discount type) {
		if(!descuentos.containsKey(key)) {
			descuentos.put(key, type);
			return true;
		}
		return false;
	}
	
	public Discount getDiscount(String key) {
		return descuentos.get(key);
	}
	
	private void loadData() {
		descuentos = DiscountFileUtil.readDiscount(FILE_NAME);
	}
	
	public void saveFile() {
		String lines = descuentos.toString();
		lines = lines.replace("{", "");
		lines = lines.replace("}", "");
		lines = lines.replace(" ", "");
		lines = lines.replace("=",";");
		lines = lines.replace(",","\n");
		DiscountFileUtil.save(lines,FILE_NAME);
	}
	
	public boolean hasDiscount(String key) {
		return descuentos.containsKey(key);
	}

	public double consultDiscount(String key) {
		return descuentos.get(key).getAmount()*100;
	}

}
