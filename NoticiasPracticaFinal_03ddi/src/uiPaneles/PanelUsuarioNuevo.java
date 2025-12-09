package uiPaneles;

import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class PanelUsuarioNuevo extends JPanel {
	
	private JEditorPane editorPane;
	
	public PanelUsuarioNuevo() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText("<center><h1>Bienvenido al panel de personalizacion <br> <h2>Seleccione sus preferencias");
		editorPane.setEditable(false);
		editorPane.setBounds(221, 35, 760, 90);
		add(editorPane);
		
		
		
	}
}
