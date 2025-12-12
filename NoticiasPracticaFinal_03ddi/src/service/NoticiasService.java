package service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import dao.NoticiasDAO;
import domain.Noticias;

public class NoticiasService {
	
	/*
	public static void main(String[] args) {
		String prueba = exNoticias();
		System.out.println(prueba);
	}*/
	
	public static String exNoticias() {	
		List<Noticias> fuentes=NoticiasDAO.extraerNoticiasObjeto();
		try {
			for (Noticias n : fuentes) {
				
			String web = (n.getUrl());
			Document doc = Jsoup.connect(web).get();

			//problema
			Element palabra = doc.select(n.getCss()).get(0);
			String resultado = palabra.html().toUpperCase();
			return resultado;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return null;
	}
	
	public static String exNot_dMarca() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.mod-title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	public static String exNot_dAs() {
		StringBuilder sb = new StringBuilder();
		try {
			String web ="https://as.com/futbol/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h3.s_t a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	public static String exNot_dMundoDep() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.mundodeportivo.com/loultimo";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.title a.page-link").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	// ECONOMIA -----------------------------------
	public static String exNot_eEconomista() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.eleconomista.es/?gad_source=1&gad_campaignid=12340049456&gbraid=0AAAAAD9rSRDALaMK6Iu18PDLe2wUmJn6_&gclid=CjwKCAiA3L_JBhAlEiwAlcWO51eciKSeJV52Gth9BD3EoT1VAPo0XBAeXeteBuzCu8bz39StoWJz1xoC5n0QAvD_BwE";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.h1 a").get(3);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	public static String exNot_eExpansion() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.expansion.com/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("a.ue-c-cover-content__link h2.ue-c-cover-content__headline").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_eDigital() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.economiadigital.es/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.entry-title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	// NACIONAL -----------------------------------
	public static String exNot_nRtve() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.rtve.es/noticias/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("span.maintitle").get(2);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_nTheObjetive() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://theobjective.com/espana/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.tno-article-general__content__title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_nElMundo() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.elmundo.es/espana.html";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.ue-c-cover-content__headline").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

	// INTERNACIONAL -----------------------------------
	
	public static String exNot_iEuropaPress() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.europapress.es/internacional/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.articulo-titulo a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_i20mins() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.20minutos.es/internacional/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.c-article__title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_iLaRazon() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.larazon.es/internacional/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.article__title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	// MUSICA -----------------------------------
	
	public static String exNot_mRockFm() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.rockfm.fm/tag/noticia-del-dia";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.c-article__title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_mRadiole() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.radiole.com/actualidad";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.title span").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_mPaisMusica() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://elpais.com/noticias/musica/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2.c_t a").get(3);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	
	// ALEATORIO -----------------------------------

	public static String exNot_aCbr() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.cbr.com/category/anime-news/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h5.display-card-title a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String exNot_aLecturalia() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://www.lecturalia.com/blog/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("h2 a").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	 
	public static String exNot_a9to5() {
		StringBuilder sb = new StringBuilder();
		try {

			String web = "https://9to5mac.com/";
			Document doc = Jsoup.connect(web).get();

			Element palabra = doc.select("a.article__title-link").get(0);
			String resultado = palabra.html().toUpperCase();
			sb.append(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}
	
	
	
}
