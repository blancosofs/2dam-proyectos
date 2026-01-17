package uiPaneles;

import javax.swing.JPanel;

import dao.HistoricoDAO;
import service.NoticiasService;
import ui.VentanaLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;


public class PanelUsuarioNoticias extends JPanel{

	private static final long serialVersionUID = 1L;
	private JEditorPane editorPane;

	private TextArea textArea;
	private JButton btn_guardar;
	private JButton btn_volver;
	private JButton btn_exit;
	
	
	public PanelUsuarioNoticias() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		editorPane = new JEditorPane();
		editorPane.setFont(new Font("Argelina", Font.BOLD, 20));
		editorPane.setContentType("text/html");
		editorPane.setText(
				"<center><h1>Bienvenido al panel de noticias");
		editorPane.setEditable(false);
		editorPane.setBounds(85, 100, 630, 70);
		add(editorPane);
		
		textArea = new TextArea();
		textArea.setBounds(38, 196, 716, 304);
		textArea.setEditable(false);
		textArea.append("\n---\nTus noticias son:\n---\n");
		textArea.append(NoticiasService.exNoticias());
		add(textArea);
		
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
		
		btn_guardar = new JButton("Guardar en el historico");
		btn_guardar.setBounds(602, 520, 154, 35);
		add(btn_guardar);
		btn_guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HistoricoDAO.escribirEnHistorico();
				String msg = "[info] Noticias guardadadas con exito en el txt";
				JOptionPane.showMessageDialog(null, msg, "", 1);
			}
		});
		
		btn_volver = new JButton("<--");
		btn_volver.setBounds(38, 523, 141, 29);
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin.mostrar("inicio de sesion");
			}
		});
		add(btn_volver);
		
	}
}
