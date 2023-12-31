package util;

import java.io.*;



public abstract class FileUtil{

	public static BufferedReader createReader(String nombreFicheroEntrada) throws FileNotFoundException {
		BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
		return fichero;
	}

	private static BufferedWriter createWriter(String nombreFicheroSalida) throws IOException {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFicheroSalida));
		return fichero;
		
	}
	
	public static void save(String lines,String fileName) {
		BufferedWriter writer = null;
		try {
			try {
				writer = createWriter(fileName);
				writer.write(lines);
			}finally {
				if(writer!=null) {
					writer.close();
					}
			}
		} catch (IOException e) {
			throw new RuntimeException("Se ha producido un error con el fichero");
		}
	}
}
