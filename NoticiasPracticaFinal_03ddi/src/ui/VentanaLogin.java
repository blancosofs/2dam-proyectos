package ui;

import javax.swing.JFrame;

import uiPaneles.PanelAdmin;



public class VentanaLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public VentanaLogin() {
		setResizable(false);
		setLocationRelativeTo(null);

		//PanelInicioSesion miPanelInicioSesion= new PanelInicioSesion();
		//add(miPanelInicioSesion);

		PanelAdmin panelAdmin= new PanelAdmin();
		add(panelAdmin);

	}
}
