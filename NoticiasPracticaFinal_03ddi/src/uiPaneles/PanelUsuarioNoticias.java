package uiPaneles;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelUsuarioNoticias extends JPanel{
	
	private JLabel lbl_Noticas ;
	
	public PanelUsuarioNoticias() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		lbl_Noticas = new JLabel("Tus noticias de hoy son: ");
		lbl_Noticas.setBounds(37, 30, 287, 26);
		add(lbl_Noticas);
		
		
	}
}
