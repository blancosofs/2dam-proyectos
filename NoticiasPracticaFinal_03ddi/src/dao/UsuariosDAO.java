package dao;

import java.io.BufferedReader;

import java.io.FileReader;

import uiPaneles.PanelAdmin;
import uiPaneles.PanelInicioSesion;

public class UsuariosDAO {
	public static boolean comprobarUsrTXT(String usr, String pass) {

		try {
			FileReader archivo = new FileReader("TXT/usuarios");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");

					String usuario = cadena[0];
					String password = cadena[1];

					if (usuario.equals(pass) && password.equals(pass)) {
						// menu usuario
					} else {
						// ventana de error
					}

				} else if (linea.startsWith("##")) {
					String[] cadena = linea.substring(2).split("::");

					String usuario = cadena[0];
					String password = cadena[1];

					if (usuario.equals(pass) && password.equals(pass)) {

						return true;
					} else {
						return false;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
