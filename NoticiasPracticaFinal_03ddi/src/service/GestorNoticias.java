package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GestorNoticias {

	public static void main(String[] args) {

		String mostrarNoticiasMarca = exNot_dMarca();
		System.out.print(mostrarNoticiasMarca+"\n");
		
		String mostrarNoticiasAs = exNot_dAs();
		System.out.print(mostrarNoticiasAs + "\n");
		
		String mostrarNoticiasMundoDep = exNot_dMundoDep();
		System.out.print(mostrarNoticiasMundoDep+"\n");
		

		String mostrarNoticiasEconomista = exNot_eEconomista();
		System.out.print(mostrarNoticiasEconomista+"\n");
		
		String mostrarNoticiasExpansion = exNot_eExpansion();
		System.out.print(mostrarNoticiasExpansion+"\n");
		
		String mostrarNoticiasEdigital = exNot_eDigital();
		System.out.print(mostrarNoticiasEdigital+"\n");
	}

	public static String exNot_dMarca() {
		StringBuilder sb = new StringBuilder("Noticias Deportes-Marca: \n");
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
		StringBuilder sb = new StringBuilder("Noticias Deportes-As: \n");
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
	
	public static String exNot_dMundoDep() {
		StringBuilder sb = new StringBuilder("Noticias Deportes-Mundo: \n");
		try {
			int contador = 0;

			String web = "https://www.mundodeportivo.com/loultimo";
			Document doc = Jsoup.connect(web).get();

			while (contador < 3) {
				Element palabra = doc.select("h2.title a.page-link").get(contador);
				String resultado = palabra.html().toUpperCase();
				sb.append(resultado).append(" \n");
				contador++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	//-----------------------------------
	public static String exNot_eEconomista() {
		StringBuilder sb = new StringBuilder("Noticias Economia-El Economista: \n");
		try {
			int contador = 0;

			String web = "https://www.eleconomista.es/?gad_source=1&gad_campaignid=12340049456&gbraid=0AAAAAD9rSRDALaMK6Iu18PDLe2wUmJn6_&gclid=CjwKCAiA3L_JBhAlEiwAlcWO51eciKSeJV52Gth9BD3EoT1VAPo0XBAeXeteBuzCu8bz39StoWJz1xoC5n0QAvD_BwE";
			Document doc = Jsoup.connect(web).get();
			while (contador < 3) {
				Element palabra = doc.select("h2.h1 a").get(contador+1);
				String resultado = palabra.html().toUpperCase();
				sb.append(resultado).append(" \n");
				contador++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	public static String exNot_eExpansion() {
		StringBuilder sb = new StringBuilder("Noticias Economia-Expansion: \n");
		try {
			int contador = 0;

			String web = "https://www.expansion.com/";
			Document doc = Jsoup.connect(web).get();

			while (contador < 3) {
				Element palabra = doc.select("a.ue-c-cover-content__link h2.ue-c-cover-content__headline").get(contador);
				String resultado = palabra.html().toUpperCase();
				sb.append(resultado).append(" \n");
				contador++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_eDigital() {
		StringBuilder sb = new StringBuilder("Noticias Economia-Economia Digital: \n");
		try {
			int contador = 0;

			String web = "https://www.economiadigital.es/";
			Document doc = Jsoup.connect(web).get();

			while (contador < 3) {
				Element palabra = doc.select("h2.entry-title a").get(contador);
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
