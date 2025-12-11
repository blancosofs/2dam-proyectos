package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UsuariosDAO;

import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelBaja extends JPanel {

	private JEditorPane editorPane;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_pwd;
	private JTextField textField_email;

	private JLabel lbl_nombre;
	private JLabel lbl_pwd;
	private JLabel lbl_email;

	private JButton btn_baja;

	public PanelBaja() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText(
				"<center><h1>Bienvenido al panel de baja de usuarios <br> <h2>Introduzca los siguientes datos");
		editorPane.setEditable(false);
		editorPane.setBounds(223, 140, 760, 90);
		add(editorPane);

		lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(223, 324, 61, 16);
		add(lbl_nombre);

		textField = new JTextField();
		textField.setBounds(323, 307, 660, 50);
		add(textField);
		textField.setColumns(10);

		String nombreBaja = textField.getText();

		btn_baja = new JButton("Baja:");
		btn_baja.setBounds(866, 584, 117, 29);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UsuariosDAO.bajaUsuario(nombreBaja);
			}
		});

	}
}
