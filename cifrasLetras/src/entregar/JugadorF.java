package entregar;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*
 * @author Ashley Leon y Sofia Blanco
 * 
 * */

public class JugadorF extends Thread {

	/* atributo enum para saber si es cifra o letra */
	private TipoHilo cifraOletra;

	/* constructor para poder usarlo en el main */
	public JugadorF(TipoHilo cifraOletra) {
		this.cifraOletra = cifraOletra;
	}

	Random r = new Random();
	public final static Semaphore SEM1 = new Semaphore(1); // verde, una clase un semaforo

	@Override
	public void run() {
		int contador = 0;

		try {
			/* mientras no llegue el contador a 20 */
			while (contador < 20) {
				System.out.println("[B-llega] se mete al bucle");

				/* que vayan despacio */
				Thread.sleep(1000);
				System.out.println("[B-llega] se va a dormir");

				/* si es hilo cifras escribes si es letras escribes */
				if (cifraOletra == TipoHilo.CIFRAS) {
					/* escribes cifras y letras */
					/* antes tienes que dar luz verde */
					SEM1.acquire();
					MainF.fosSalida.write(cifrasRandom(r));
					//System.out.println("[B-llega] escribe cifras "+cifrasRandom(r));
					SEM1.release();
				} else {
					SEM1.acquire();
					MainF.fosSalida.write(letraRandom(r));
					//System.out.println("[B-llega] escribe letras "+letraRandom(r));
					SEM1.release();
				}

				/* has escrito en el fichero asi que suma uno y sigues */
				contador++;

				/* si llegas a 20 */
				if (contador == 20) {
					System.out.println("[llega] se mete al if de ganador");
					/* le dices quien ganas!! */
					MainF.ganador = cifraOletra.toString(); // a la variable ganador que es compartida le metes tu variable tipo de hilo (saca la que antes se meta al if)

					/* te metes en lo compartido */
					synchronized (MainF.sincronizador) {
						System.out.println("[llega] notificar al main del ganador");
						/* avisas al ganador */
						MainF.sincronizador.notify(); 
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public enum TipoHilo {
		CIFRAS, LETRAS
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

}
