package uiPaneles;

import javax.swing.JPanel;

import dao.HistoricoDAO;
import service.NoticiasService;
import ui.VentanaLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class PanelUsuarioNoticias extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl_msgNoticias;
	private TextArea textArea;
	private JButton btn_guardar;
	private JButton btn_volver;
	
	
	public PanelUsuarioNoticias() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		lbl_msgNoticias = new JLabel("Noticias");
		lbl_msgNoticias.setBounds(38, 33, 60, 14);
		add(lbl_msgNoticias);
		
		textArea = new TextArea();
		textArea.setBounds(50, 73, 956, 486);
		textArea.setEditable(false);
		textArea.append("\n---\nTus noticias son:\n---\n");
		textArea.append(NoticiasService.exNoticias());
		add(textArea);
		
		btn_guardar = new JButton("Guardar en el historico");
		btn_guardar.setBounds(412, 603, 273, 23);
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
		btn_volver.setBounds(486, 679, 117, 29);
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin.mostrar("inicio de sesion");
			}
		});
		add(btn_volver);
		
	}
}
