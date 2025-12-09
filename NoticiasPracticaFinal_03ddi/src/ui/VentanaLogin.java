package ui;

import javax.swing.JFrame;

import uiPaneles.PanelInicioSesion;
import uiPaneles.PanelAdmin;
import uiPaneles.PanelUsuario;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaLogin() {
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);

		
		PanelAdmin panelAdmin = new PanelAdmin();
		panelAdmin.setBounds(0, 0, 1200, 800);
		add(panelAdmin);
		panelAdmin.setVisible(false);
		

		PanelUsuario panelUsuario = new PanelUsuario();
		panelUsuario.setBounds(0, 0, 1200, 800);
		add(panelUsuario);
		panelUsuario.setVisible(false);
		
		 PanelInicioSesion miPanelInicioSesion = new PanelInicioSesion(panelAdmin, panelUsuario);
		 miPanelInicioSesion.setBounds(0, 0, 1200, 800);
		 add(miPanelInicioSesion);

	}
}
