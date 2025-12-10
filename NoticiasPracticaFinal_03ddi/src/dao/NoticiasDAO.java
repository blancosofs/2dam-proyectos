package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class NoticiasDAO {
	
	public static ArrayList<String[]> extraerNoticia() {
		ArrayList<String[]> arrayListNoticia = new ArrayList<>();;
		try {
			String[] arrayNoticia = null;

			FileReader archivo = new FileReader("TXT/noticias");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("&")) {
					String[] cadena = linea.substring(1).split(";;");

					for (int i = 0; i < arrayNoticia.length; i++) {
						arrayNoticia[0] = cadena[0];
						arrayNoticia[1] = cadena[1];
						arrayNoticia[2] = cadena[2];
					}
					
					arrayListNoticia.add(arrayNoticia);
				} 
				
				else if (linea.startsWith("&&")) {
					String[] cadena = linea.substring(2).split(";;");

					String nombre = cadena[0];
					String link = cadena[1];
					String css = cadena[2];
				}
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListNoticia;
	}
	
}
