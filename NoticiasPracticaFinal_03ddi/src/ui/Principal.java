package ui;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin miVentanaLogin = new VentanaLogin();
					miVentanaLogin.setSize(1200, 800);
					miVentanaLogin.setResizable(false);
					miVentanaLogin.setLocationRelativeTo(null);
					miVentanaLogin.setVisible(true);

					// VentanaCarga miVentanaCarga = new VentanaCarga();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
