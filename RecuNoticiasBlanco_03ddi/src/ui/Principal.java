package ui;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		
		/*
		 * @ author: Sofia Blanco Calsina
		 * 
		 * Bienvenido a mi aplicacion de noticias!!
		 * 
		 * [AVISO] La applicacion tarda un ratito en cargar, porfavor tenga paciencia
		 * 
		 * [info] Credenciales usuario prueba: user1 pwd1
		 * [info] Credenciales usuario prueba: user2 pwd2
		 * [info] Credenciales usuario prueba: user3 pwd3
		 * 
		 * [info] Credenciales admin prueba: admin1 pwda1
		 * 
		 * Inicie la aplicacion y disfrute de las noticias de ultima hora :))
		 * 
		 * */
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin miVentanaLogin = new VentanaLogin();
					miVentanaLogin.setSize(800, 600);
					miVentanaLogin.setResizable(false);
					miVentanaLogin.setLocationRelativeTo(null);
					miVentanaLogin.setVisible(false);
					
					VentanaCarga miVentanaCarga = new VentanaCarga(miVentanaLogin);
					miVentanaCarga.setSize(600, 400);
					miVentanaCarga.setUndecorated(true);
					miVentanaCarga.setResizable(false);
					miVentanaCarga.setLocationRelativeTo(null);
					miVentanaCarga.setVisible(true);
						
				} catch (Exception e) {
					String msg = "[error] Error en la carga de la aplicaion, sentimos las molestias!";
					JOptionPane.showMessageDialog(null, msg, "", 1);
					System.exit(0);
				}
			}
		});
	}
	

}
