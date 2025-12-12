package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuariosDAO {

	public static void main(String[] args) {
		List<Usuario> user = extraerUsuarioObjeto();
		for (Usuario u : user) {
			System.out.println(u);
		}

	}

	public static List<Usuario> extraerUsuarioObjeto() {
		List<Usuario> user = new ArrayList<>();
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");
					String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					String email = cadena[3];

					Usuario u1 = new Usuario(id, usuario, password, email, "user", false, false);
					user.add(u1);

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");
					String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					String email = cadena[3];

					Usuario a1 = new Usuario(id, usuario, password, email, "admin", false, false);
					user.add(a1);
				}
			}
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static int comprobarUsrTXT(String usr, String pass) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");

					// String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					// String email = cadena[3];

					if (usuario.equals(usr) && password.equals(pass)) {
						// System.out.println("[TEST] "+usuario);
						// System.out.println("[TEST] "+password);

						// iniciar sesion!!!!!!!
						Usuario u = new Usuario();
						u.setLoggeado(true);
						// System.out.println("[test]"+u.isLoggeado());
						return 2;
					}

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");

					// String id = cadena[0];
					String usuario = cadena[1];
					String password = cadena[2];
					// String email = cadena[3];

					if (usuario.equals(usr) && password.equals(pass)) {
						// System.out.println("[TEST] "+usuario);
						// System.out.println("[TEST] "+password);

						// iniciar sesion!!!!!!!
						Usuario u = new Usuario();
						u.setLoggeado(true);
						return 1;
					}
				}
			}
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void altaUsuario(String newNombre, String newPass, String newEmail) {
		try {
			FileWriter fw = new FileWriter("TXT/usuarios.txt", true);
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;
			String newId = " ";

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");
					String id = cadena[0];
					// String usuario = cadena[1];
					// String password = cadena[2];
					// String email = cadena[3];
					if (id.equals(newId)) {
					newId+= "Admin";
					}
				}else {
					newId="idAdmin";
				}
			}

			fw.write("\n");
			fw.write("*");
			fw.write(newId);
			fw.write("::");
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
			FileReader archivo = new FileReader("TXT/usuarios.txt");
			BufferedReader lector = new BufferedReader(archivo);
			FileWriter fw = new FileWriter("TXT/usuarios", true);
			String linea;

			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("*")) {
					String[] cadena = linea.substring(1).split("::");
					String usuario = cadena[0];
					// String password = cadena[1];
					// String email = cadena[2];
					if (nombreBaja.equals(usuario)) {
						fw.write("");
					}
				}
			}
			lector.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
