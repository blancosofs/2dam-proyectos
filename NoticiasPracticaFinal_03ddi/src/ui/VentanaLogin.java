package ui;

import javax.swing.JFrame;

import uiPaneles.PanelAdmin;



public class VentanaLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public VentanaLogin() {
		setSize(1200, 800);       
	    setResizable(false);
	    setLocationRelativeTo(null);

		//PanelInicioSesion miPanelInicioSesion= new PanelInicioSesion();
		//add(miPanelInicioSesion);

		PanelAdmin panelAdmin= new PanelAdmin();
		panelAdmin.setBounds(0, 0, 1200, 800); 
		add(panelAdmin);

	}
}
