package dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class PersonalizacionDAO {
	public static boolean comprobarPersonalizacion() {
		// true lleno, false vacio
		try {
			FileReader archivo = new FileReader("TXT/personalizar");
			BufferedReader lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				
				
				
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
