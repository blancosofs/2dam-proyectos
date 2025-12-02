package entregar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class JugadorF extends Thread {
	Random r = new Random();
	
	public static FileOutputStream fosSalida ;

	@Override
	public void run() {
		comprobarCrearTXT();
		try {
			fosSalida = new FileOutputStream("salida.txt", true);
			Thread.sleep((long) (Math.random() * 1000));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static char letraRandom(Random r) {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVW";
		char[] arrayLetras = letras.toCharArray();

		return arrayLetras[r.nextInt(arrayLetras.length)];
	}

	public static char cifrasRandom(Random r) {
		String cifras = "123456789";
		char[] arrayCifras = cifras.toCharArray();

		return arrayCifras[r.nextInt(arrayCifras.length)];
	}

	public static void comprobarCrearTXT() {
		File ficherotxt = new File("salida.txt");
		if (!ficherotxt.exists()) {
			System.err.println("ERROR. El fichero que estas intentando leer no existe(salida.txt)");
			try {
				System.out.println("INFO. Se procede a la creacion de salida.txt)");
				ficherotxt.createNewFile();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}

	}

}
