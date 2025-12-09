package uiPaneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
		editorPane.setText("<center><h1>Bienvenido al panel de baja de usuarios <br> <h2>Introduzca los siguientes datos");
		editorPane.setEditable(false);
		editorPane.setBounds(223, 140, 760, 90);
		add(editorPane);
		
		textField = new JTextField();
		textField.setBounds(323, 307, 660, 50);
		add(textField);
		textField.setColumns(10);
		
		lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(223, 324, 61, 16);
		add(lbl_nombre);
		
		textField_pwd = new JTextField();
		textField_pwd.setColumns(10);
		textField_pwd.setBounds(323, 403, 660, 50);
		add(textField_pwd);
		
		lbl_pwd = new JLabel("Contraseña:");
		lbl_pwd.setBounds(223, 420, 88, 16);
		add(lbl_pwd);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(323, 497, 660, 50);
		add(textField_email);
		
		lbl_email = new JLabel("Email:");
		lbl_email.setBounds(223, 514, 61, 16);
		add(lbl_email);
		
		btn_baja = new JButton("Baja:");
		btn_baja.setBounds(866, 584, 117, 29);
		add(btn_baja);
		btn_baja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 
				
			}
		});
		
		
		
	}
}
