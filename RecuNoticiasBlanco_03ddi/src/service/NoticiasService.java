package service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.NoticiasDAO;
import domain.Noticias;

public class NoticiasService {

	public static String exNoticias() {
		List<Noticias> fuentes = NoticiasDAO.extraerNoticiasObjeto();
		StringBuilder sb = new StringBuilder();
		try {
			for (Noticias n : fuentes) {

				String web = (n.getUrl());
				Document doc = Jsoup.connect(web).get();

				// problema
				  Elements elementosComprobar = doc.select(n.getCss());
		            if (!elementosComprobar.isEmpty()) {
		                Element palabra = elementosComprobar.get(0);
		                String resultado = palabra.text().toUpperCase();
		                
		                if (resultado != null && !resultado.isEmpty()) {
		                    sb.append(n.getNombre()).append("\n")
		                      .append(resultado)
		                      .append("\n\n-----------------\n\n");
		                }
		            }

			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return sb.toString();
	}

}
