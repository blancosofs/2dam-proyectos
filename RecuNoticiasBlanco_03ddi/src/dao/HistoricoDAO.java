package dao;

import java.io.FileWriter;

import service.NoticiasService;

public class HistoricoDAO {

	public static void escribirEnHistorico() {
		try {
			FileWriter fw = new FileWriter("TXT/historico.txt", true);
			fw.write("\n");
			String fuentes = NoticiasService.exNoticias();
			fw.write(fuentes);
			fw.write("\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
