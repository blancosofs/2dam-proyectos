package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class PreferenciasDAO {
	public static boolean comprobarPersonalizacion() {
		// true lleno, false vacio
		try {
			FileReader archivo = new FileReader("TXT/preferencias");
			BufferedReader lector = new BufferedReader(archivo);
			String linea;

			while ((linea = lector.readLine()) != null) {
				return false;
			}

			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void escribirPreferencias(int[] seleccionPreferencias) {
		try {
			FileWriter fw = new FileWriter("TXT/preferencias", true);
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
