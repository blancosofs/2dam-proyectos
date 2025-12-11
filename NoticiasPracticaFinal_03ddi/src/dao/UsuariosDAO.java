package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class UsuariosDAO {
	public static int comprobarUsrTXT(String usr, String pass) {
		try {
			FileReader archivo = new FileReader("TXT/usuarios");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");

					String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					String email = cadena[3];

					if (usuario.equals(usr) && password.equals(pass)) {
						// System.out.println("[TEST] "+usuario);
						// System.out.println("[TEST] "+password);
						return 2;
					}

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");

					String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					String email = cadena[3];

					if (usuario.equals(usr) && password.equals(pass)) {
						// System.out.println("[TEST] "+usuario);
						// System.out.println("[TEST] "+password);
						return 1;
					}
				}
			}
			lector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void altaUsuario(String newNombre, String newPass, String newEmail) {
		try {
			FileWriter fw = new FileWriter("TXT/usuarios", true);
			fw.write("\n");
			fw.write("*");
			fw.write(newNombre);
			fw.write("::");
			fw.write(newPass);
			fw.write("::");
			fw.write(newEmail);

			// System.out.println("[TEST] " + newNombre);
			// System.out.println("[TEST] " + newPass);
			// System.out.println("[TEST] " + newEmail);

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void bajaUsuario(String nombreBaja) {
		try {
			FileReader archivo = new FileReader("TXT/usuarios");
			BufferedReader lector = new BufferedReader(archivo);
			FileWriter fw = new FileWriter("TXT/usuarios", true);
			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");
					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];

					if (nombreBaja.equals(usuario)) {
						fw.write("");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
