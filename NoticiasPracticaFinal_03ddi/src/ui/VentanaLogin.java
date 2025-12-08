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

		// PanelInicioSesion miPanelInicioSesion = new PanelInicioSesion();
		// miPanelInicioSesion.setBounds(0, 0, 1200, 800);
		// add(miPanelInicioSesion);

		// [TEST]
		PanelAdmin panelAdmin = new PanelAdmin();
		panelAdmin.setBounds(0, 0, 1200, 800);
		add(panelAdmin);
		// [TEST]
		PanelUsuario panelUsuario = new PanelUsuario();
		panelUsuario.setBounds(0, 0, 1200, 800);
		add(panelUsuario);

	}
}
