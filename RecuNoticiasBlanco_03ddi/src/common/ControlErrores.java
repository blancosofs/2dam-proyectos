package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlErrores {
	
	public static boolean hayInternet() {
	  
		return true;
	}
	
	public static boolean comprobarIcono() {
		File fichero = new File("imagen/icono.png");
		if (!fichero.exists()) {
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFondo() {
		File fichero = new File("src/ui/fondo.jpg");
		if (!fichero.exists()) {
			return false;
		}
		return true;
	}

	public static boolean comprobarTXTconfig() {
		File fichero = new File("TXT/configuracion.txt");
		if (!fichero.exists()) {
			return false;
		}
		return true;
	}

	public static boolean comprobarTXThistorico() {
		File fichero = new File("TXT/historico.txt");
		if (!fichero.exists()) {
			return false;
		}
		return true;
	}

	public static boolean comprobarTXTusuarios() {
		File fichero = new File("TXT/usuarios.txt");
		if (!fichero.exists()) {
			return false;
		}
		return true;
	}

	//coontador de usuarios soportados por app
	public static boolean comprobarAltaUsuarios() {
		try {
			int contador = 0;
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				if (linea.startsWith("*")) {
					contador++;
					if (contador >= 10) {
						return false;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	//contador existencia usuarios por nombre
	public static boolean comprobarAltaUsuariosNombre(String nombre) {
		try {

			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				if (linea.startsWith("*")) {

					String[] cadena = linea.substring(1).split("::");

					String usuario = cadena[0];
					// String password = cadena[1];
					// String email = cadena[2];

					if (usuario.equals(nombre)) {
						return false;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean comprobarEmail(String toEmail) {
		if (toEmail == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
		Matcher matcher = pattern.matcher(toEmail);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarNombre(String nombre) {
		if (nombre == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^user[1-9]$");
		Matcher matcher = pattern.matcher(nombre);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarPass(String pass) {
		if (pass == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^pwd[1-9]$");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarPersonalizacion() {
		return false;
	}
}
