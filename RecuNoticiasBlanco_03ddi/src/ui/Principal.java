package ui;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		
		/*
		 * @ author: Sofia Blanco Calsina
		 * 
		 * Bienvenidoa a mi aplicacion de noticias!
		 * 
		 * [AVISO] La applicaciion tarda un ratito en cargar, porfavor tenga paciencia
		 * [INFO] En la memoria del proyecto hay un apardado de Estructura del codigo
		 * 
		 * [info] Credenciales usuario prueba: user1 pwd1
		 * [info] Credenciales admin prueba: admin1 pwda1
		 * 
		 * Inicie la eplicacion y disfrute de las noticias de ultima hora :))
		 * 
		 * */
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin miVentanaLogin = new VentanaLogin();
					miVentanaLogin.setSize(1200, 800);
					miVentanaLogin.setResizable(false);
					miVentanaLogin.setLocationRelativeTo(null);
					miVentanaLogin.setVisible(false);
					
					VentanaCarga miVentanaCarga = new VentanaCarga(miVentanaLogin);
					miVentanaCarga.setSize(660, 330);
					miVentanaCarga.setUndecorated(true);
					miVentanaCarga.setResizable(false);
					miVentanaCarga.setLocationRelativeTo(null);
					miVentanaCarga.setVisible(true);
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
