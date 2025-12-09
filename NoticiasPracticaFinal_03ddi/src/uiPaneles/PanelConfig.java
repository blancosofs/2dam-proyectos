package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class PanelConfig extends JPanel {
	private static final long serialVersionUID = 1L;

	private JEditorPane editorPane_h1Config;
	private JButton btn_alta;
	private JButton btn_baja;
	private JButton btn_test;
	private JButton btn_hora;

	public PanelConfig(PanelTest panelTest, PanelHora panelHora, PanelAlta panelAlta, PanelBaja panelBaja) {

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane_h1Config = new JEditorPane();
		editorPane_h1Config.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane_h1Config.setContentType("text/html");
		editorPane_h1Config.setText(
				"<center><h1>Bienvenido al panel de configuracion <br> <h2>Seleccione una de las siguientes opciones");
		editorPane_h1Config.setEditable(false);
		editorPane_h1Config.setBounds(223, 140, 760, 90);
		add(editorPane_h1Config);

		btn_alta = new JButton("ALTA");
		btn_alta.setBounds(368, 369, 117, 29);
		add(btn_alta);
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAlta.setVisible(true);
			}
		});

		btn_baja = new JButton("BAJA");
		btn_baja.setBounds(368, 410, 117, 29);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBaja.setVisible(true);
			}
		});

		btn_test = new JButton("TEST");
		btn_test.setBounds(531, 388, 117, 29);
		add(btn_test);
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTest.setVisible(true);
			}
		});

		btn_hora = new JButton("HORA");
		btn_hora.setBounds(674, 388, 117, 29);
		add(btn_hora);
		btn_hora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}
}
