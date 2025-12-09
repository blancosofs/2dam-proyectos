package uiPaneles;

import javax.swing.JPanel;

import dao.PersonalizacionDAO;

public class PanelUsuario extends JPanel {

	public PanelUsuario() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		PanelUsuarioNoticias panelUsuarioNoticias = new PanelUsuarioNoticias();
		panelUsuarioNoticias.setBounds(0, 0, 1200, 800);
		add(panelUsuarioNoticias);
		panelUsuarioNoticias.setVisible(false);
		
		PanelUsuarioNuevo panelUsuarioNuevo = new PanelUsuarioNuevo();
		panelUsuarioNuevo.setBounds(0, 0, 1200, 800);
		add(panelUsuarioNuevo);
		panelUsuarioNuevo.setVisible(false);
		
		if(!PersonalizacionDAO.comprobarPersonalizacion()) { //si es false
			panelUsuarioNoticias.setVisible(true);
			setVisible(false);
		} else {
			panelUsuarioNuevo.setVisible(true);
			setVisible(false);
		}
		
		
		
	}

}
