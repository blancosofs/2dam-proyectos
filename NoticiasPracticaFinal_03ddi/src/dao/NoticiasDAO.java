package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class NoticiasDAO {

	public static ArrayList<String[]> extraerNoticia() {
		ArrayList<String[]> arrayListNoticia = new ArrayList<>();

		try {
			FileReader archivo = new FileReader("TXT/noticias");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("DEPORTES")) {
					String[] cadena = linea.substring(8).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				}

				else if (linea.startsWith("ECONOMIA")) {
					String[] cadena = linea.substring(8).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				} else if (linea.startsWith("NACIONAL")) {
					String[] cadena = linea.substring(8).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				} else if (linea.startsWith("INTERNACIONAL")) {
					String[] cadena = linea.substring(13).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				} else if (linea.startsWith("MUSICA")) {
					String[] cadena = linea.substring(6).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				} else if (linea.startsWith("ALEATORIO")) {
					String[] cadena = linea.substring(9).split("==");

					String[] arrayNoticia = new String[3];
					arrayNoticia[0] = cadena[0];
					arrayNoticia[1] = cadena[1];
					arrayNoticia[2] = cadena[2];

					arrayListNoticia.add(arrayNoticia);
				}
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayListNoticia;
	}
	
	/*public static void main(String[] args) {
		ArrayList<String[]> noticias = extraerNoticia();

		for (String[] categoria : noticias) {
			for (String titular : categoria) {
				System.out.println(titular);
			}
			System.out.println("---");
		}
	}*/

}
