package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PreferenciasDAO {
	public static boolean comprobarPersonalizacion() {
		// true lleno, false vacio
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/configuracion"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				//fin de personalizacion
				//EDITAAAAAAR
				if (linea.endsWith("&"))
				return false;
			}
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void escribirPreferencias(int[] seleccionPreferencias) {
		try {
			FileWriter fw = new FileWriter("TXT/configuracion", true);
			fw.write("*");
			for (int i = 0; i < seleccionPreferencias.length; i++) {
				System.out.print(seleccionPreferencias[i]);
				fw.write(Integer.toString(seleccionPreferencias[i]));
			}
			fw.write("\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
