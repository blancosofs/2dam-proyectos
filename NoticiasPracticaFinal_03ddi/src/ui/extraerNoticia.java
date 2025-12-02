package ui;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class extraerNoticia {

	public static void main(String[] args) {
		try {

			String web = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";
			
			Document doc = Jsoup.connect(web).get();
			Element palabra = doc.select("h2.mod-title a").get(0);
			
			String resultado = palabra.html().toUpperCase();
			
			System.out.println(resultado);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
