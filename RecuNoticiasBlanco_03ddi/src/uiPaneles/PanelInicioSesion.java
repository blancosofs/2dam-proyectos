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

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PanelInicioSesion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_usuario;

	private JEditorPane dtrpnbienvenidoASu;

	private JLabel lbl_usuario;
	private JLabel lbl_pwd;

	private JButton btn_ver;
	private JButton btn_exit;

	private JPasswordField passwordField;
	private JButton btn_iniciarSesion;
	private JButton btn_baja;

	// no puedes pasarlo por constructor con card layout :/
	public static Usuario existe = null;

	// se solapan preferencias y noticias pque lo compruebas en inicio y muestras sin anyadir sos
   // public static boolean preferencias = false; // no estas
	
	public PanelInicioSesion() {
		setLayout(null);
		setBounds(0, 0, 800, 600);

		dtrpnbienvenidoASu = new JEditorPane();
		dtrpnbienvenidoASu.setFont(new Font("Argelina", Font.BOLD, 20));
		dtrpnbienvenidoASu.setEditable(false);
		dtrpnbienvenidoASu.setBounds(85, 100, 630, 110);
		add(dtrpnbienvenidoASu);
		dtrpnbienvenidoASu.setContentType("text/html");
		dtrpnbienvenidoASu.setText(
				"<center> <h1>Bienvenido a su app de noticias <br> <h2>Porfavor, indroduzca usuario y contraseña");

		lbl_usuario = new JLabel("USUARIO:");
		lbl_usuario.setFont(new Font("Argelina", Font.PLAIN, 16));
		lbl_usuario.setBounds(92, 263, 155, 34);
		add(lbl_usuario);

		textField_usuario = new JTextField();
		textField_usuario.setBounds(228, 263, 394, 34);
		add(textField_usuario);
		textField_usuario.setColumns(10);

		lbl_pwd = new JLabel("CONTRASEÑA:");
		lbl_pwd.setFont(new Font("Argelina", Font.PLAIN, 16));
		lbl_pwd.setBounds(92, 326, 155, 34);
		add(lbl_pwd);

		passwordField = new JPasswordField();
		passwordField.setBounds(228, 326, 394, 34);
		add(passwordField);

		btn_ver = new JButton("👀");
		btn_ver.setBounds(650, 326, 65, 34);
		add(btn_ver);
		btn_ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// si lo muestras ya no lo puedes ocultar ~~~~~~~~~ solo si tienes tiempo
				passwordField.setEchoChar((char) 0);
			}
		});

		btn_iniciarSesion = new JButton("Iniciar Sesion");
		btn_iniciarSesion.setBounds(292, 444, 231, 31);
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
							//System.out.println("[llegas?]");
							//System.out.println(existe);
							PanelUsuario.crearPreferencias(existe);
							//VentanaLogin.mostrar("preferencias");
						} else {
							PanelUsuario.crearNoticias(existe);
							//VentanaLogin.mostrar("noticias");
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
		btn_baja.setBounds(292, 508, 231, 31);
		add(btn_baja);
		btn_baja.setVisible(false);

		btn_exit = new JButton("x");
		btn_exit.setBackground(new Color(255, 0, 0));
		btn_exit.setBorder(null);
		btn_exit.setBounds(750,25,25,25);
		
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
