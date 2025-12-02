package pruebas_psp;

import java.io.IOException;

public class Jugador extends Thread {
	

	private String hilo, accion;
	
	public Jugador(String hilo, String accion) {
		this.hilo = hilo;
		this.accion = accion;
	}
	
	
	@Override
	public void run() {
	    try {
	        Thread.sleep((int) (Math.random() * 1000)); // espera aleatoria

	        StringBuilder sb = new StringBuilder();

	        // Generar los 20 caracteres
	        for (int i = 0; i < 20; i++) {
	            if (accion.equals("letras")) {
	                sb.append(letraRandom());
	            } else {
	                sb.append((int)(Math.random()*10)); // numero del 0 al 9
	            }
	        }


	        escribir(sb.toString());


	        synchronized (Main.sincronizador) {
	            Main.ganador = this.hilo;
	            Main.sincronizador.notify();
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	private void escribir(String texto) {
	    synchronized (Main.fos) {
	        try {
	            Main.fos.write((texto + "\n").getBytes());
	            Main.fos.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	private char letraRandom() {
	    String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    int pos = (int)(Math.random() * alfabeto.length());
	    return alfabeto.charAt(pos);
	}

	

}
