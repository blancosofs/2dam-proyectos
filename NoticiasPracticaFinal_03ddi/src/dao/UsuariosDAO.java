package dao;

import java.io.BufferedReader;

import java.io.FileReader;


public class UsuariosDAO {
	public static int comprobarUsrTXT(String usr, String pass) {
		try {
			FileReader archivo = new FileReader("TXT/usuarios");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");

					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];
					
					if (usuario.equals(usr) && password.equals(pass)) {
						//System.out.println("[TEST] "+usuario);
						//System.out.println("[TEST] "+password);
						return 2;
					} 

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");

					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];

					if (usuario.equals(usr) && password.equals(pass)) {
						//System.out.println("[TEST] "+usuario);
						//System.out.println("[TEST] "+password);
						return 1;
					} 
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String AltaUsuario() {
		 return null;
	}
	
	public static String BajaUsuario() {
		 return null;
	}
	
	
}
