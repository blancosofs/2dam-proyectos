package uiPaneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.VentanaLogin;

public class PanelConfig extends JPanel {
	private static final long serialVersionUID = 1L;

	private JEditorPane editorPane_h1Config;
	private JButton btn_alta;
	private JButton btn_baja;
	private JButton btn_test;
	private JButton btn_hora;

	private JButton btn_exit;
	private JButton btn_volver;

	public PanelConfig() {
		setLayout(null);
		setBounds(0, 0, 800, 600);

		editorPane_h1Config = new JEditorPane();
		editorPane_h1Config.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane_h1Config.setContentType("text/html");
		editorPane_h1Config.setText(
				"<center><h1>Bienvenido al panel de configuracion <br> <h2>Seleccione una de las siguientes opciones");
		editorPane_h1Config.setEditable(false);
		editorPane_h1Config.setBounds(85, 100, 630, 110);
		add(editorPane_h1Config);

		btn_alta = new JButton("ALTA");
		btn_alta.setFont(new Font("Argelina", Font.PLAIN, 11));
		btn_alta.setBounds(92, 263, 155, 35);
		add(btn_alta);
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelAlta.setVisible(true);
				//setVisible(false);
				PanelAdmin.mostrar2("alta");
			}
		});

		btn_baja = new JButton("BAJA");
		btn_baja.setFont(new Font("Argelina", Font.PLAIN, 11));
		btn_baja.setBounds(92, 326, 155, 35);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelBaja.setVisible(true);
				//setVisible(false);
				PanelAdmin.mostrar2("baja");
			}
		});

		btn_test = new JButton("TEST");
		btn_test.setFont(new Font("Argelina", Font.PLAIN, 11));
		btn_test.setBounds(330, 290, 155, 35);
		add(btn_test);
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelTest.setVisible(true);
				//setVisible(false);
				PanelAdmin.mostrar2("test");
			}
		});

		btn_hora = new JButton("HORA");
		btn_hora.setFont(new Font("Argelina", Font.PLAIN, 11));
		btn_hora.setBounds(560, 290, 155, 35);
		add(btn_hora);
		btn_hora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "[No disponible] Nos encontramos en desarrollo, sentimos las molestias!";
				JOptionPane.showMessageDialog(null, msg, "", 1);
				//PanelAdmin.mostrar2("hora");
			}
		});

		btn_exit = new JButton("x");
		btn_exit.setBackground(new Color(255, 0, 0));
		btn_exit.setBorder(null);
		btn_exit.setBounds(750,25,25,25);
		
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Cerrar aplicacion",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (confirmacion == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		add(btn_exit);
		
		btn_volver = new JButton("<--");
		btn_volver.setBounds(292, 470, 231, 35);
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin.mostrar("inicio de sesion");
				//getParent().setVisible(true); //esto va a admin
				//setVisible(false);
				//getParent().isVisible();
				//String msg = "[No disponible] Nos encontramos en desarrollo, sentimos las molestias!";
				//JOptionPane.showMessageDialog(null, msg, "", 1);
			}
		});
		add(btn_volver);

	}
}
