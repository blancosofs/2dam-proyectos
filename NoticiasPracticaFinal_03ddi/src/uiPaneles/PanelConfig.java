package uiPaneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class PanelConfig extends JPanel{
	private static final long serialVersionUID = 1L;

	private JEditorPane editorPane_h1Config;
	private JButton btn_alta;
	private JButton btn_baja;
	private JButton btn_test;
	private JButton btn_hora;


	public PanelConfig(PanelTest panelTest) {

		setLayout(null);

		editorPane_h1Config = new JEditorPane();
		editorPane_h1Config.setContentType("text/html");
		editorPane_h1Config.setText("Bienvenido al panel de configuracion <br> Seleccione una de las siguientes opciones");
		editorPane_h1Config.setEnabled(false);
		editorPane_h1Config.setEditable(false);
		editorPane_h1Config.setBounds(6, 6, 423, 34);
		add(editorPane_h1Config);

		btn_alta = new JButton("ALTA");
		btn_alta.setBounds(6, 118, 117, 29);
		add(btn_alta);
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});

		btn_baja = new JButton("BAJA");
		btn_baja.setBounds(6, 159, 117, 29);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btn_test = new JButton("TEST");
		btn_test.setBounds(169, 137, 117, 29);
		add(btn_test);
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTest.setVisible(true);
			}
		});

		btn_hora = new JButton("HORA");
		btn_hora.setBounds(312, 137, 117, 29);
		add(btn_hora);
		btn_hora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});




	}
}
