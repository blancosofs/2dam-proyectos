package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.ControlErrores;
import dao.UsuariosDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class PanelAlta extends JPanel {

	private JEditorPane editorPane;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_pwd;
	private JTextField textField_email;

	private JLabel lbl_nombre;
	private JLabel lbl_pwd;
	private JLabel lbl_email;

	private JButton btn_alta;
	private JButton btn_volver;
	private JButton btn_exit;

	public PanelAlta() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText(
				"<center><h1>Bienvenido al panel de alta de usuarios <br> <h2>Introduzca los siguientes datos");
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

		// ------------------------------------

		lbl_pwd = new JLabel("Contraseña:");
		lbl_pwd.setBounds(223, 420, 88, 16);
		add(lbl_pwd);

		textField_pwd = new JTextField();
		textField_pwd.setColumns(10);
		textField_pwd.setBounds(323, 403, 660, 50);
		add(textField_pwd);

		// ------------------------------------

		lbl_email = new JLabel("Email:");
		lbl_email.setBounds(223, 514, 61, 16);
		add(lbl_email);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(323, 497, 660, 50);
		add(textField_email);

		btn_alta = new JButton("Alta");
		btn_alta.setBounds(866, 584, 117, 29);
		add(btn_alta);
		btn_alta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newNombre = textField.getText();
				String newPass = textField_pwd.getText();
				String newEmail = textField_email.getText();

				if ((newNombre) != null || (newPass) != null || (newEmail) != null) {

					if (!ControlErrores.comprobarEmail(newEmail) || !ControlErrores.comprobarNombre(newNombre)
							|| !ControlErrores.comprobarPass(newPass)) {
						String msg = "[error] Campos invalidos. "
								+ "Siga la siguiente estructura sin []: \n user[numero de preferencia(del 1-9)], pwd[numero de preferencia (del 1-9)], [email]@[direccion].[com]";
						JOptionPane.showMessageDialog(null, msg, "", 1);

					} else {

						if (!ControlErrores.comprobarAltaUsuariosNombre(newNombre)) {
							String msg = "[error] Usuario ya existente";
							JOptionPane.showMessageDialog(null, msg, "", 1);
						} else {
							if (!ControlErrores.comprobarAltaUsuarios()) {
								String msg = "[error] Numero de usuarios superado. La aplicacion solo soporta 10";
								JOptionPane.showMessageDialog(null, msg, "", 1);
							} else {
								UsuariosDAO.altaUsuario(newNombre, newPass, newEmail);
								String msg = "[info] Usuario dado de alta con exito";
								JOptionPane.showMessageDialog(null, msg, "", 1);
							}
						}
					}
				} else {
					String msg = "[error] Algun campo esta vacio";
					JOptionPane.showMessageDialog(null, msg, "", 1);
				}
			}
		});

		btn_volver = new JButton("<--");
		btn_volver.setBounds(699, 584, 117, 29);
		btn_volver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// como cambio al panel padre sin pasarselo como parametro
				
				//String msg = "[No disponible] Nos encontramos en desarrollo, sentimos las molestias!";
				//JOptionPane.showMessageDialog(null, msg, "", 1);
			}
		});
		add(btn_volver);

		btn_exit = new JButton("x");
		btn_exit.setBorder(null);
		btn_exit.setBounds(1141, 6, 53, 26);

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
	}
}
