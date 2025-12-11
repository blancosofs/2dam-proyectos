package ui;

import java.awt.Toolkit;

import javax.swing.JFrame;

import uiPaneles.PanelInicioSesion;
import uiPaneles.PanelAdmin;
import uiPaneles.PanelUsuario;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntm_ver;
	private JMenuItem mntm_des;

	public VentanaLogin() {
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagen/icono.png"));

		PanelUsuario panelUsuario = new PanelUsuario();
		panelUsuario.setBounds(0, 0, 1200, 800);
		getContentPane().add(panelUsuario);
		panelUsuario.setVisible(false);

		menuBar = new JMenuBar();
		menuBar.setBounds(40, 61, 51, 33);

		mnNewMenu = new JMenu("...");
		menuBar.add(mnNewMenu);

		mntm_ver = new JMenuItem("Version 1.0");
		mnNewMenu.add(mntm_ver);

		mntm_des = new JMenuItem("Blanco Calsina Sofía");
		mnNewMenu.add(mntm_des);
		
		PanelAdmin panelAdmin = new PanelAdmin();
		panelUsuario.add(panelAdmin);
		panelAdmin.setBounds(0, 0, 1200, 800);
		panelAdmin.setVisible(false);
				
		PanelInicioSesion miPanelInicioSesion = new PanelInicioSesion(panelAdmin, panelUsuario);
		miPanelInicioSesion.setBounds(0, 0, 1200, 800);
		getContentPane().add(miPanelInicioSesion);
		miPanelInicioSesion.add(menuBar);

	}
}
