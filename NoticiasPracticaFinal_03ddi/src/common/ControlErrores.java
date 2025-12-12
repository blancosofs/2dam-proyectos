package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ControlErrores {

	public static boolean comprobarTXTconfig() {
		File fichero = new File("TXT/configuracion.txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				FileWriter escritura = new FileWriter(fichero);
				escritura.write(' ');
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
			return false;
		}
		return true;
	}

	public static boolean comprobarTXThistorico() {
		File fichero = new File("TXT/historico.txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				FileWriter escritura = new FileWriter(fichero);
				escritura.write(' ');
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
			return false;
		}
		return true;
	}

	public static boolean comprobarTXTusuarios() {
		File fichero = new File("TXT/usuarios.txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				FileWriter escritura = new FileWriter(fichero);
				escritura.write("*id1::user1::pwd1::usr1@email.com");
				escritura.write("*id2::user2::pwd2::usr2@email.com");
				escritura.write("#ida1::admin1::pwda1::admin1@email.com");
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
			return false;
		}
		return true;
	}

	public static boolean comprobarAltaUsuarios() {
		try {
			int contador = 0;
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				if (linea.startsWith("*")) {
					contador++;
					if (contador>=3) {
						return false;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean comprobarEmail(String toEmail){
		if (toEmail == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
		Matcher matcher = pattern.matcher(toEmail);

		if (matcher.find()) {
		} else {
			return false;
		}
		return false;
	}

	public static boolean comprobarPersonalizacion() {
		return false;
	}
}
