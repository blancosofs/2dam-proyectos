package entregar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import entregar.JugadorF.TipoHilo;
/*
 * @author Ashley Leon y Sofia Blanco
 * 
 * */

public class MainF {
	/* objeto sincronifazor que va a ser un recurso compartido */
	public static Object sincronizador = new Object();
	public static String ganador = "";

	/* abres fichero de lectura y compartido */
	public static FileOutputStream fosSalida;

	public static void main(String[] args) {
		try {
			/* Tenemos el recurso compartido? */
			comprobarCrearTXT();

			/* abres tuberia para escribir */
			fosSalida = new FileOutputStream("salida.txt");

			JugadorF cifras = new JugadorF(TipoHilo.CIFRAS);
			JugadorF letras = new JugadorF(TipoHilo.LETRAS);

			/* empezamos dos hilos */
			cifras.start();
			letras.start();

			/* te metes al recurso compartido */
			synchronized (sincronizador) {
				/* esperas al ganador */
				System.out.println("[llega] esperar al ganador");
				sincronizador.wait(); // esperas al ganador
			}
			/* cierras */
			//fosSalida.close();

			/* imprimes quien gaan */
			System.out.println("El ganador es: " + ganador);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
