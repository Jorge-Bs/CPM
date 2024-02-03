package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import castleBooker.model.discount.Discount;

public class DiscountFileUtil extends FileUtil{
	
	public  static HashMap<String, Discount> readDiscount(String fileName){
		try {
			try {
				BufferedReader reader = createReader(fileName);
				HashMap<String , Discount> map= new HashMap<>();
				while(reader.ready()) {
					String line = reader.readLine();
					String[] parts = line.split(";");
					Discount disocunt = Discount.valueOf(parts[1]);
					map.put(parts[0], disocunt);
				}
				reader.close();
				return map;
			} catch (FileNotFoundException e) {
				new File(fileName).createNewFile();
				return readDiscount(fileName);
			}
		}catch(IOException ioe) {
			throw new RuntimeException("Se ha producido un error con la lectura del fichero");
		}
	}
	
	
}

