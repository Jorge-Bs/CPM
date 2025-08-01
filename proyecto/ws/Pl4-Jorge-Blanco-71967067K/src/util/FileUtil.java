package util;

import java.io.*;



public abstract class FileUtil{

	public static BufferedReader createReader(String nombreFicheroEntrada) throws FileNotFoundException {
		BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
		return fichero;
	}

	private static BufferedWriter createWriter(String nombreFicheroSalida,boolean option) throws IOException {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFicheroSalida,option));
		return fichero;
		
	}
	
	public static void save(String lines,String fileName,boolean option) {
		BufferedWriter writer = null;
		File file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("No se ha podido guardar el archivo");
			}
		}
		try {
			try {
				writer = createWriter(fileName,option);
				if (file.length() != 0) {
	                lines = "\n" + lines;
	            }
				writer.append(lines);
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
