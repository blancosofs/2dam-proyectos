package ui;

import java.awt.EventQueue;
import java.awt.Toolkit;


public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarga miVentanaCarga = new VentanaCarga();
					miVentanaCarga.setSize(660, 330);
					miVentanaCarga.setUndecorated(true);
					miVentanaCarga.setResizable(false);
					miVentanaCarga.setLocationRelativeTo(null);
					//~~~~~~~~~~~~~~~
					//no va la imagen
					miVentanaCarga.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("icono.png")));
					miVentanaCarga.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	

}
