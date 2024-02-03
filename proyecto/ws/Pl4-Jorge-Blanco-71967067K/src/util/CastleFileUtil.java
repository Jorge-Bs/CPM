package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import castleBooker.model.booker.Castle;

public class CastleFileUtil extends FileUtil{

	public static List<Castle> readCastleFile(String path){
		try {
			BufferedReader reader = createReader(path);
			List<Castle> castles = new ArrayList<>();
			while(reader.ready()) {
				String line = reader.readLine();
				String[] parts = line.split(";");
				double price = Double.parseDouble(parts[4]);
				Castle castillo = new Castle(parts[0],parts[1],parts[2],parts[3],price,parts[5]);
				castles.add(castillo);
			}
			reader.close();
			return castles;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("El archivo no se ha encontrado y no se han podido cargar los datos necesarios");
		}catch(IOException e) {
			throw new RuntimeException("Se ha producido un error mientras se leia el fichero");
		}
	}
}
