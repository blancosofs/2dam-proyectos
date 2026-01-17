package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Noticias;
import domain.Usuario;
import ui.VentanaLogin;

public class NoticiasDAO {

	public static List<Noticias> extraerNoticiasObjeto() {
		List<Noticias> fuentes = new ArrayList<>();
		try {
			FileReader archivo = new FileReader("TXT/configuracion.txt");
			BufferedReader lector = new BufferedReader(archivo);

			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("DEPORTES")) {
					String[] cadena = linea.substring(8).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not1 = new Noticias(id, nombre, url, css);
					fuentes.add(not1);
				}

				else if (linea.startsWith("ECONOMIA")) {
					String[] cadena = linea.substring(8).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not2 = new Noticias(id, nombre, url, css);
					fuentes.add(not2);

				} else if (linea.startsWith("NACIONAL")) {
					String[] cadena = linea.substring(8).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not3 = new Noticias(id, nombre, url, css);
					fuentes.add(not3);

				} else if (linea.startsWith("INTERNACIONAL")) {
					String[] cadena = linea.substring(13).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not4 = new Noticias(id, nombre, url, css);
					fuentes.add(not4);

				} else if (linea.startsWith("MUSICA")) {
					String[] cadena = linea.substring(6).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not5 = new Noticias(id, nombre, url, css);
					fuentes.add(not5);

				} else if (linea.startsWith("ALEATORIO")) {
					String[] cadena = linea.substring(9).split("==");

					String id = cadena[0];
					String nombre = cadena[1];
					String url = cadena[2];
					String css = cadena[3];

					Noticias not6 = new Noticias(id, nombre, url, css);
					fuentes.add(not6);
				}
			}
			lector.close();
		} catch (Exception e) {
			String msg = "[error] Error en la carga de noticias (revisa el txt), sentimos las molestias! ";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
		}
		return fuentes;
	}

	public static String emailTester() {
		String usuarioMail = "";
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/configuracion.txt"));
			String linea;
			while ((linea = lector.readLine()) != null) {

				if (linea.startsWith("&")) {
					String[] cadena = linea.substring(1).split("==");
					usuarioMail = cadena[1];
				}
			}
			lector.close();
		} catch (IOException e) {
			String msg = "[error] Error en la carga de usuarios, sentimos las molestias!";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			System.exit(0);
		}
		return usuarioMail;
	}

}
