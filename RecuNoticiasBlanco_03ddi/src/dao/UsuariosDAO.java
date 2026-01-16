package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuariosDAO {

	public static List<Usuario> extraerUsuarioObjeto() {
		List<Usuario> userArrayList = new ArrayList<>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");
					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];

					Usuario u1 = new Usuario(usuario, password, email, "user", false, false);
					userArrayList.add(u1);

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");
					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];

					Usuario a1 = new Usuario(usuario, password, email, "admin", false, false);
					userArrayList.add(a1);
				}
			}
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userArrayList;
	}


	public static void altaUsuario(String newNombre, String newPass, String newEmail) {
		try {
			FileWriter fw = new FileWriter("TXT/usuarios.txt", true);
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			
				fw.write("\n");
				fw.write("*");
				fw.write(newNombre);
				fw.write("::");
				fw.write(newPass);
				fw.write("::");
				fw.write(newEmail);
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void bajaUsuario(String nombreBaja) {
		try {
			FileReader archivo = new FileReader("TXT/usuarios.txt");
			BufferedReader lector = new BufferedReader(archivo);
			FileWriter fw = new FileWriter("TXT/usuarios", true);
			
				fw.write("");
			
			lector.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
