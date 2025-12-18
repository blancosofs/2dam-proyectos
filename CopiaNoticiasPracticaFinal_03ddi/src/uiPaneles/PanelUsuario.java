package uiPaneles;

import javax.swing.JPanel;

import dao.PreferenciasDAO;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelUsuario() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		PanelUsuarioNoticias panelUsuarioNoticias = new PanelUsuarioNoticias();
		panelUsuarioNoticias.setBounds(0, 0, 1200, 800);
		add(panelUsuarioNoticias);
		panelUsuarioNoticias.setVisible(false);
		
		PanelUsuarioPreferencias panelUsuarioNuevo = new PanelUsuarioPreferencias(panelUsuarioNoticias);
		panelUsuarioNuevo.setBounds(0, 0, 1200, 800);
		add(panelUsuarioNuevo);
		panelUsuarioNuevo.setVisible(false);
		
		//EDITAAAAR
		if(PreferenciasDAO.comprobarPersonalizacion()) {
			panelUsuarioNoticias.setVisible(true);
			setVisible(false);
		} else {
			panelUsuarioNuevo.setVisible(true);
			setVisible(false);
		}
	}

}
