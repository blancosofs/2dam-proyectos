package uiPaneles;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsuariosDAO;
import domain.Usuario;
import ui.VentanaLogin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	private JButton btn_baja;

	private Usuario existe = null;

	public PanelInicioSesion() {
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
				// ~~~~~ editar limite intentos
				String usr = textField_usuario.getText();
				String pass = new String(passwordField.getPassword());

				// Usuario existe = null; // vacio, subelo para poder verlo en cerrar sesion
				List<Usuario> userLeer = UsuariosDAO.extraerUsuarioObjeto();
				for (Usuario u : userLeer) {
					if (u.getNombre().equalsIgnoreCase(usr.trim()) && u.getPass().equalsIgnoreCase(pass.trim())) {
						existe = u; // recorres, comparas y le metes esos valores
					}
				}
				// si ya no lo tienes vacio
				if (existe != null) {
					// ahora si!!!!
					/* INICIAR SESION */
					existe.setLoggeado(true);
					// en lugar de numeros comparas directamente con el cargo
					if (existe.getCargo().equals("user")) {
						VentanaLogin.mostrar("usuario");
						/* COMPROBAR PREFERENCIAS */
						//recuerda que el card es como un metodo que barajea, por eso en esta clase usas ventana aunque tehgas otro en usuario :p
						if (!existe.isPreferencias()) {
							VentanaLogin.mostrar("preferencias");
						} else {
							VentanaLogin.mostrar("noticias");
						}
					} else if (existe.getCargo().equals("admin")) {
						VentanaLogin.mostrar("administrador");
					}
					// para que no te lies
					btn_iniciarSesion.setEnabled(false);
					btn_baja.setVisible(true);
				} else {
					String msg = "[error] Usuario no encontrado";
					JOptionPane.showMessageDialog(null, msg, "", 1);
				}
			}
		});

		btn_baja = new JButton("Cerrar sesion");
		btn_baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (existe != null) {
					/* CERRAR SESION */
					existe.setLoggeado(false);

					btn_iniciarSesion.setEnabled(true);
					btn_baja.setVisible(false);
				}
			}
		});
		btn_baja.setBounds(457, 433, 220, 29);
		add(btn_baja);
		btn_baja.setVisible(false);

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
