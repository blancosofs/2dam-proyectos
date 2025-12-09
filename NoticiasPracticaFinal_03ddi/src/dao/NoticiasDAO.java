package dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class NoticiasDAO {
	public static String urlNoticia(int noticia) {
		String url = null;
		try {
			FileReader archivo = new FileReader("TXT/noticias");
			BufferedReader lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("&")) {
					String[] cadena = linea.substring(1).split("::");

					String marca = cadena[0];
					String as = cadena[1];
					String mundo = cadena[2];
					
					if (noticia == 1) {
						url=marca;
					} else if (noticia == 2) {
						url=as;
					}else {
						url=mundo;
					}

				} else if (linea.startsWith("&&")) {
					String[] cadena = linea.substring(2).split("::");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
