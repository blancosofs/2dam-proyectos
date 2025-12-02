package cifrasLetrasJuego;

public class Main {
	/**
	 * @author ASHLEY LEON & SOFIA BLANCO
	 */

	public static void main(String[] args) {
		String ganador;
		
		for (int i = 0; i < 10; i++) {
			Jugador hCifras= new Jugador();
			//hCifras.setName("Cifras");
			hCifras.start();
			
			Jugador hLetras= new Jugador();
			//hLetras.setName("Letras");
			hLetras.start();
		}
		
//		for (String Juego : Jugador.Juego) {
//			System.out.println(Juego);
//		}
		
		
//		System.out.println("El ganador es: "+Jugador.Juego.getLast());
//		int tamanio = Jugador.Juego.size();
//		System.out.println(tamanio);
	}
	

}
