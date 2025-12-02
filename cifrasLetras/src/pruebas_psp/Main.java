package pruebas_psp;

import java.io.FileOutputStream;

public class Main {

	public static FileOutputStream fos;
	public static final Object sincronizador = new Object();
	public static String ganador = "";

	public static void main(String[] args) {

		try {

			fos = new FileOutputStream("salida.txt", true);

			Jugador cifras = new Jugador("Cifras", "cifras");
			Jugador letras = new Jugador("Letras", "letras");

			synchronized (sincronizador) {
				cifras.start();
				letras.start();
				sincronizador.wait(); // esperamos al ganador
			}

			System.out.println("El ganador es: " + ganador);

			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
