package dao;

import java.io.FileWriter;


import domain.Usuario;

public class PreferenciasDAO {
	public static boolean comprobarPersonalizacion() {
		// true lleno, false vacio
		Usuario u = new Usuario();
		if(u.isPreferencias()) { //true lleno
			return true;
		}else {
			return false;
		}
	}

	public static void escribirPreferencias(int[] seleccionPreferencias) {
		try {
			FileWriter fw = new FileWriter("TXT/configuracion.txt", true);
			fw.write("*");
			for (int i = 0; i < seleccionPreferencias.length; i++) {
				//EDITAAAR
				//System.out.print(seleccionPreferencias[i]);
				fw.write("==");
				Usuario u = new Usuario();
				//fw.write(u.getId());
				fw.write(Integer.toString(seleccionPreferencias[i]));
			}
			fw.write("\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
