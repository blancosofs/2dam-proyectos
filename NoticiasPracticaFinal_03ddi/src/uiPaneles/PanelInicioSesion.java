package uiPaneles;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsuariosDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PanelInicioSesion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_usuario;

	private JEditorPane editorPane_login;

	private JLabel lbl_usuario;
	private JLabel lbl_pwd;

	private JButton btn_ver;
	private JButton btn_exit;

	private JPasswordField passwordField;
	private JButton btn_iniciarSesion;

	public PanelInicioSesion(PanelAdmin panelAdmin, PanelUsuario panelUsuario) {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
	

		editorPane_login = new JEditorPane();
		editorPane_login.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane_login.setEditable(false);
		editorPane_login.setBounds(39, 27, 1102, 90);
		add(editorPane_login);
		editorPane_login.setContentType("text/html");
		editorPane_login.setText(
				"<center> <h1>Bienvenido a su app de noticias <br> <h2>Porfavor, indroduzca usuario y contraseña");

		lbl_usuario = new JLabel("USUARIO:");
		lbl_usuario.setBounds(215, 234, 61, 16);
		add(lbl_usuario);

		textField_usuario = new JTextField();
		textField_usuario.setBounds(350, 229, 414, 26);
		add(textField_usuario);
		textField_usuario.setColumns(10);

		lbl_pwd = new JLabel("CONTRASEÑA:");
		lbl_pwd.setBounds(215, 284, 101, 16);
		add(lbl_pwd);

		passwordField = new JPasswordField();
		passwordField.setBounds(350, 279, 414, 26);
		add(passwordField);

		btn_ver = new JButton("👀");
		btn_ver.setBounds(788, 279, 117, 29);
		add(btn_ver);
		btn_ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// si lo muestras ya no lo puedes ocultar ~~~~~~~~~ solo si tienes tiempo
				passwordField.setEchoChar((char) 0);
			}
		});

		btn_iniciarSesion = new JButton("Iniciar Sesion");
		btn_iniciarSesion.setBounds(457, 363, 220, 29);
		add(btn_iniciarSesion);
		btn_iniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//editar limite intentos
				
				
				
				String usr = textField_usuario.getText();
				String pass = new String(passwordField.getPassword());
				if (UsuariosDAO.comprobarUsrTXT(usr, pass) == 1) {
					panelAdmin.setVisible(true);
					setVisible(false);
					btn_iniciarSesion.setEnabled(false);
				} else if (UsuariosDAO.comprobarUsrTXT(usr, pass) == 2) {
					panelUsuario.setVisible(true);
					setVisible(false);
					btn_iniciarSesion.setEnabled(false);
				} else {
					String msg = "[error] Usuario no encontrado";
					JOptionPane.showMessageDialog(null, msg, "", 1);
				}
			}
			
			
		});

		btn_exit = new JButton("x");
		btn_exit.setBorder(null);
		btn_exit.setBounds(1141, 6, 53, 26);

		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 0->aceptar, 1->no, 2->cancelar
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
