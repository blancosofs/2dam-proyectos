package dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonalizacionDAO {
	public static void main(String[] args) {

		try {

			System.out.println(sacarFuentesTXT());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void escribirFuentesTXT(String rdbt_num) {
		try {
			File personalizar = new File("TXT/personalizar");
			FileWriter fw = new FileWriter(personalizar);

			if (rdbt_num.equals("1")) {
				fw.write(rdbt_num);
			} else if (rdbt_num.equals("2")) {
				fw.write(rdbt_num);
			} else {
				fw.write(rdbt_num);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String sacarFuentesTXT() throws IOException {
		File fichero = new File("TXT/personalizar");
		FileReader fr = new FileReader(fichero);

		int opc = fr.read();

		if (opc == 1) {
			String sMarca = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";
			return sMarca;
		} else if (opc == 2) {
			String sAs = "https://as.com/futbol/";
			return sAs;
		} else {
			String sMundoDep = "https://www.mundodeportivo.com/loultimo";
			return sMundoDep;
		}
	}

	public static void comprobarTXT() {
		File TXT = new File("TXT");

		if (!TXT.exists()) {
			TXT.mkdir();
		}

		File config = new File("PLANTAS/plantas.xml");
		if (!config.exists()) {
			try {
				config.createNewFile();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}
}
