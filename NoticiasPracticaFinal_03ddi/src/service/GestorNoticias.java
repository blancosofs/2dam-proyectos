package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GestorNoticias {

	public static void main(String[] args) {
		String mostrarNoticiasAs = exNot_dMarcas();
		System.out.print(mostrarNoticiasAs + "\n");

		String mostrarNoticiasMarca = exNot_dAs();
		System.out.print(mostrarNoticiasMarca);
	}

	public static String exNot_dMarcas() {
		StringBuilder sb = new StringBuilder("Noticias D-Marcas: \n");
		try {
			int contador = 0;

			String web = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";
			Document doc = Jsoup.connect(web).get();

			while (contador < 3) {
				Element palabra = doc.select("h2.mod-title a").get(contador);
				String resultado = palabra.html().toUpperCase();
				sb.append(resultado).append(" \n");
				contador++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	public static String exNot_dAs() {
		StringBuilder sb = new StringBuilder("Noticias D-As: \n");
		try {
			int contador = 0;

			String web = "https://as.com/futbol/";
			Document doc = Jsoup.connect(web).get();

			while (contador < 3) {
				Element palabra = doc.select("h3.s_t a").get(contador);
				String resultado = palabra.html().toUpperCase();
				sb.append(resultado).append(" \n");
				contador++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

}
