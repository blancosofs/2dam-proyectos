package ui;


import java.awt.EventQueue;
import java.awt.Toolkit;




public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					VentanaLogin miVentanaLogin = new VentanaLogin();
					miVentanaLogin.setSize(1200, 800);
					miVentanaLogin.setResizable(false);
					miVentanaLogin.setLocationRelativeTo(null);
					miVentanaLogin.setVisible(true);
					miVentanaLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCarga.class.getResource("IMG/icono.png")));
					miVentanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/
					VentanaCarga miVentanaCarga = new VentanaCarga();
					miVentanaCarga.setSize(660, 330);
					miVentanaCarga.setUndecorated(true);
					miVentanaCarga.setResizable(false);
					miVentanaCarga.setLocationRelativeTo(null);

					miVentanaCarga.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("icono.png")));
					miVentanaCarga.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
	

}
