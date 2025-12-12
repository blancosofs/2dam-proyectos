package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class PanelBaja extends JPanel {

	private JEditorPane editorPane;

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lbl_nombre;

	private JButton btn_baja;
	private JButton btn_volver;
	private JButton btn_exit;

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

		btn_baja = new JButton("Baja");
		btn_baja.setBounds(866, 584, 117, 29);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = "[No disponible] Nos encontramos en desarrollo, sentimos las molestias!";
				JOptionPane.showMessageDialog(null, msg, "", 1);
				//UsuariosDAO.bajaUsuario(nombreBaja);
			}
		});
		
		btn_volver = new JButton("<--");
		btn_volver.setBounds(740, 584, 117, 29);
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//como cambio al panel padre sin pasarselo como parametro
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
