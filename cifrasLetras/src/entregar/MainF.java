package entregar;

public class MainF {

	public static final Object sincronizador = new Object();
	public static String ganador = "";

	public static void main(String[] args) {
		try {
			JugadorF cifras = new JugadorF();
			JugadorF letras = new JugadorF();
			
			synchronized (sincronizador) {
				cifras.start();
				letras.start();
				sincronizador.wait();
			}

			System.out.println("El ganador es: " + ganador);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
