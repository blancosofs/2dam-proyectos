package uiPaneles;

import java.awt.CardLayout;

import javax.swing.JPanel;

import dao.PreferenciasDAO;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	/* CONTENEDOR DE TARJETAS */
	private static JPanel tarjetas3;

	public static void mostrar3(String nombre) {
		CardLayout cl = (CardLayout) tarjetas3.getLayout();
		cl.show(tarjetas3, nombre);
	}

	public PanelUsuario() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		// el panel contenedor va a ser CardLayout
		tarjetas3 = new JPanel(new CardLayout());
		add(tarjetas3); // este va al panel, no al frame por eso add

		PanelUsuarioNoticias panelUsuarioNoticias = new PanelUsuarioNoticias();
		panelUsuarioNoticias.setBounds(0, 0, 1200, 800);
		//add(panelUsuarioNoticias);
		//panelUsuarioNoticias.setVisible(false);
		tarjetas3.add(panelUsuarioNoticias, "noticias");
		
		
		PanelUsuarioPreferencias panelUsuarioNuevo = new PanelUsuarioPreferencias(panelUsuarioNoticias);
		panelUsuarioNuevo.setBounds(0, 0, 1200, 800);
		//add(panelUsuarioNuevo);
		//panelUsuarioNuevo.setVisible(false);
		tarjetas3.add(panelUsuarioNuevo, "preferencias");
		
		// EDITAAAAR
		if (PreferenciasDAO.comprobarPersonalizacion()) {
			// panelUsuarioNoticias.setVisible(true);
			// setVisible(false);
			mostrar3("preferencias");
		} else {
			// panelUsuarioNuevo.setVisible(true);
			// setVisible(false);
			mostrar3("noticias");
		}
	}

}
