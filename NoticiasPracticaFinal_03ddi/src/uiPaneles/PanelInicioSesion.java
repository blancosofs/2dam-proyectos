package uiPaneles;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsuariosDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;

public class PanelInicioSesion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_usuario;

	private JEditorPane editorPane_login;

	private JLabel lbl_usuario;
	private JLabel lbl_pwd;

	private JButton btn_ver;

	private JPasswordField passwordField;
	private JButton btn_iniciarSesion;

	public PanelInicioSesion() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		editorPane_login = new JEditorPane();
		editorPane_login.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane_login.setEditable(false);
		editorPane_login.setBounds(39, 27, 1102, 90);
		add(editorPane_login);
		editorPane_login.setContentType("text/html");
		editorPane_login.setText("<center> <h1>Bienvenido a su app de noticias <br> <h2>Porfavor, indroduzca usuario y contraseña");

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
				//si lo muestras ya no lo puedes ocultar. ~~~~~~~~~ ssolo si tienes tiempo
				passwordField.setEchoChar((char) 0);
			}
		});

		btn_iniciarSesion = new JButton("Iniciar Sesion");
		btn_iniciarSesion.setBounds(457, 363, 220, 29);
		add(btn_iniciarSesion);
		btn_iniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usr = textField_usuario.getText();
				String pass = new String(passwordField.getPassword());
				//validarPwd(pass);
				if (UsuariosDAO.comprobarUsrTXT(usr, pass)==1) {
					System.out.print("[TEST] llegas?");
					PanelAdmin miPanelAdmin = new PanelAdmin();
					miPanelAdmin.setBounds(0, 0, 1200, 800);
					add(miPanelAdmin);
		
					//getParent().add(miPanelAdmin);
					//setVisible(false);
				}else if (UsuariosDAO.comprobarUsrTXT(usr, pass)==2) {
					System.out.println("[TEST] llegas?");
					PanelUsuario miPanelUsuario = new PanelUsuario();
					miPanelUsuario.setBounds(0, 0, 1200, 800);
					add(miPanelUsuario);
				}else {
					//ventana de errores
				}
			}
		});
	}

	public static boolean validarPwd(String pass) {
		if (pass == null) {
			String msg = "[error] Contrasena nula";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			return false;
		}
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{5,7}$");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			String msg = "Contrasena valida";
			JOptionPane.showMessageDialog(null, msg, "", 1);

			return true;
		} else {
			String msg = "[error] Contrasena invalida";
			JOptionPane.showMessageDialog(null, msg, "", 1);
			return false;
		}
	}
}
