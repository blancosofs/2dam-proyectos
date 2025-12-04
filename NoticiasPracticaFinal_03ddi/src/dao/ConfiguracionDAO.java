package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ConfiguracionDAO {

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

	public static String sacarFuentesTXT() {
		try {
			File fichero = new File("TXT/personalizar");

			RandomAccessFile raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);

			int opc = raf.readInt();

			switch (opc) {
			case 1:
				String sMarca = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";
				return sMarca;
			case 2:
				String sAs = "https://as.com/futbol/";
				return sAs;
			case 3:
				String sMundoDep = "https://www.mundodeportivo.com/loultimo";
				return sMundoDep;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
