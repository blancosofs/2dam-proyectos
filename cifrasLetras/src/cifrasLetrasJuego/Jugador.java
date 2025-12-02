package cifrasLetrasJuego;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Jugador extends Thread {
	// se pasa uno a otro
	public final static Semaphore SEM1 = new Semaphore(1);
	public final static Semaphore SEM2 = new Semaphore(0);

	public final static ArrayList<String> Juego = new ArrayList<String>();

	@Override
	public void run() {
		try {
			for (;;) { // quien mueve esto es el semaforo
				// TE APROPIAS DEL SEM1
				SEM1.acquire();
				// imprimo
				String letraSem = letraRandom();
				Juego.add(letraSem);
				System.out.print(letraSem + " ");
				SEM2.release(); // DOY PASO, NOTIFICAS
				while (true) { // si hace ping pasas a pong
					SEM2.acquire();
					// imprimo
					String cifraSem = cifraRandom();
					Juego.add(cifraSem);
					System.out.print(cifraSem + " ");
					SEM1.release();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String letraRandom() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(20);
		for (int i = 0; i < 1; i++) {
			int aleatorio = rand.nextInt(caracteres.length()); 
			//esto genera una posicion random de caracter
			
			char caracter = caracteres.charAt(aleatorio);
			//este guarda el caracter
			sb.append(caracter);
		}
		return sb.toString();
	}

	public static String cifraRandom() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(20);
		for (int i = 0; i < 1; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

}
