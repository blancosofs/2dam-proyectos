package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import domain.Usuario;

public class UsuariosDAO {
	
	//public static void main(String[]args) {
	//	List<Usuario> usr = extraerUsuarioObjeto();	
	//	for (Usuario usuario : usr) {
	//		System.out.println(usuario);
	//	}
	//}

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
					
					if (cadena.length >= 4) { // se va
						String preferencias = cadena[3];
						int[] noticiasTXT = new int[18];
						
						for (int i = 0; i < preferencias.length() && i < 18; i++) {
							char c = preferencias.charAt(i);
							if (c == '1') {
								noticiasTXT[i] = 1;
							} else {
								noticiasTXT[i] = 0;
							}
						}
						
						Usuario u1 = new Usuario(usuario, password, email, "user", false, false, noticiasTXT);
						userArrayList.add(u1);
					}
					
					else {
						Usuario u1 = new Usuario(usuario, password, email, "user", false, false, null);
						userArrayList.add(u1);
					}

				} else if (linea.startsWith("#")) {
					String[] cadena = linea.substring(1).split("::");
					String usuario = cadena[0];
					String password = cadena[1];
					String email = cadena[2];

					Usuario a1 = new Usuario(usuario, password, email, "admin", false, false, null);
					userArrayList.add(a1);
				}
			}
			lector.close();
		} catch (IOException e) {
			String msg = "[error] Error en la carga de usuarios, sentimos las molestias!";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
		}
		return userArrayList;
	}
	
	public static void guardarPreferencias(Usuario usuarioPreferencias, int[] seleccionPreferencias) {
		try {
			
			FileWriter fw = new FileWriter("TXT/usuarios.txt", true); // no sobreescribe
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea = "";
			
			if (linea.startsWith("*")) {
				String[] cadena = linea.substring(1).split("::");
				
				if (cadena[0].equals(usuarioPreferencias.getNombre())) {
					
					String preferencias = cadena[3];
					int[] noticiasTXT = seleccionPreferencias;
					for (int i = 0; i < preferencias.length() && i < 18; i++) {
						char c = preferencias.charAt(i);
						if (c == '1') {
							noticiasTXT[i] = 1;
						} else {
							noticiasTXT[i] = 0;
						}
					}
					fw.write(preferencias);
				}
			} 
			
			fw.close();
			
		} catch (Exception e) {
			String msg = "[error] Error en la carga de usuarios, sentimos las molestias!";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
		}
	}

	public static void altaUsuario(String newNombre, String newPass, String newEmail) {
		try {
			FileWriter fw = new FileWriter("TXT/usuarios.txt", true); // no sobreescribe
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios.txt"));
			String linea;

			fw.write("\n");
			fw.write("*");
			fw.write(newNombre);
			fw.write("::");
			fw.write(newPass);
			fw.write("::");
			fw.write(newEmail);
			fw.write("::");

			fw.close();
		} catch (Exception e) {
			String msg = "[error] Error en la escritura de alta, sentimos las molestias!";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
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
			String msg = "[error] Error en la escritura de baja, sentimos las molestias!";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
		}
	}
}
