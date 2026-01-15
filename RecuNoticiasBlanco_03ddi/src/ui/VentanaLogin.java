package ui;

//import java.awt.Toolkit;

import javax.swing.JFrame;

import uiPaneles.PanelInicioSesion;
import uiPaneles.PanelAdmin;
import uiPaneles.PanelUsuario;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntm_ver;
	private JMenuItem mntm_des;
	// panel contenedor de tarjetas
	private static JPanel tarjetas;
	
	public static void mostrar(String nombre) {
        CardLayout cl = (CardLayout) tarjetas.getLayout();
        cl.show(tarjetas, nombre);
    }

	public VentanaLogin() {
		
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		// setIconImage(Toolkit.getDefaultToolkit().getImage("imagen/icono.png"));

		/* QUE TE PREGUNTE EN CERRAR */
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 0->aceptar, 1->no, 2->cancelar
				int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Cerrar aplicacion",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (confirmacion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		// el panel contenedor va a ser CardLayout
		tarjetas = new JPanel(new CardLayout());
		setContentPane(tarjetas); // metelo en tu frame!! (es esto raro pane.add(cards, BorderLayout.CENTER);)

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		menuBar.setBounds(0, 0, 1200, 15);

		mnNewMenu = new JMenu("Acerca de ..");
		menuBar.add(mnNewMenu);

		mntm_ver = new JMenuItem("Version 2.0");
		mnNewMenu.add(mntm_ver);

		mntm_des = new JMenuItem("Blanco Calsina Sofía");
		mnNewMenu.add(mntm_des);

		PanelAdmin panelAdmin = new PanelAdmin();
		panelAdmin.setBounds(0, 0, 1200, 800);
		// getContentPane().add(panelAdmin);
		// panelAdmin.setVisible(false);
		tarjetas.add(panelAdmin, "administrador"); // sin nombre no puedes hacer show

		PanelUsuario panelUsuario = new PanelUsuario();
		panelUsuario.setBounds(0, 0, 1200, 800);
		// getContentPane().add(panelUsuario);
		// panelUsuario.setVisible(false);
		tarjetas.add(panelUsuario, "usuario");

		PanelInicioSesion miPanelInicioSesion = new PanelInicioSesion();
		miPanelInicioSesion.setBounds(0, 0, 1200, 800);
		// getContentPane().add(miPanelInicioSesion);
		miPanelInicioSesion.add(menuBar);
		tarjetas.add(miPanelInicioSesion, "inicio de sesion");
		mostrar("inicio de sesion");
	}
	
	

}
