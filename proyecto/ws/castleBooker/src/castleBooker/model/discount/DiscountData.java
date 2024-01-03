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
			saveDiscount(key+";"+type);
			return true;
		}
		return false;
	}
	
	private void saveDiscount(String line) {
		DiscountFileUtil.save(line, FILE_NAME,true);
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
		DiscountFileUtil.save(lines,FILE_NAME,false);
	}
	
	public boolean hasDiscount(String key) {
		return descuentos.containsKey(key);
	}

	public double consultDiscount(String key) {
		return descuentos.get(key).getAmount()*100;
	}

	public void remove(String dni) {
		descuentos.remove(dni);
		saveFile();
	}

}
