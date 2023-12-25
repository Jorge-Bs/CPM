package util;

import java.io.*;



public abstract class FileUtil{

	public static BufferedReader createReader(String nombreFicheroEntrada) throws FileNotFoundException {
		BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
		return fichero;
	}

	public static BufferedWriter createWriter(String nombreFicheroSalida) throws IOException {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFicheroSalida));
		return fichero;
		
	}
}
