package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import domain.Noticias;

public class NoticiasDAO {
	
	public static List<Noticias> extraerNoticiasObjeto() {
		List<Noticias> fuentes=new ArrayList<>();
		try {
			FileReader archivo = new FileReader("TXT/configuracion.txt");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("DEPORTES")) {
					String[] cadena = linea.substring(8).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not1 = new Noticias(id,nombre,url,css);
					fuentes.add(not1);
				}

				else if (linea.startsWith("ECONOMIA")) {
					String[] cadena = linea.substring(8).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not2 = new Noticias(id,nombre,url,css);
					fuentes.add(not2);
					
				} else if (linea.startsWith("NACIONAL")) {
					String[] cadena = linea.substring(8).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not3 = new Noticias(id,nombre,url,css);
					fuentes.add(not3);
				
				} else if (linea.startsWith("INTERNACIONAL")) {
					String[] cadena = linea.substring(13).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not4 = new Noticias(id,nombre,url,css);
					fuentes.add(not4);
				
				} else if (linea.startsWith("MUSICA")) {
					String[] cadena = linea.substring(6).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not5 = new Noticias(id,nombre,url,css);
					fuentes.add(not5);

				} else if (linea.startsWith("ALEATORIO")) {
					String[] cadena = linea.substring(9).split("==");

					String id=  cadena[0];
					String nombre= cadena[1];
					String url= cadena[2];
					String css = cadena[3];
					
					Noticias not6 = new Noticias(id,nombre,url,css);
					fuentes.add(not6);
				}
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fuentes;
	}

}
