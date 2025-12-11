package uiPaneles;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import service.NoticiasService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelTest extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lbl_msgDeporte;
	private JTextArea textArea_D1;
	private JButton btnNextTest;
	private JButton btn_volver;
	private JTextField textField;

	public PanelTest() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		lbl_msgDeporte = new JLabel("DEPORTE");
		lbl_msgDeporte.setBounds(22, 121, 129, 16);
		add(lbl_msgDeporte);

		textArea_D1 = new JTextArea(NoticiasService.exNot_dMarca());
		textArea_D1.setEditable(false);
		textArea_D1.setBounds(22, 197, 1151, 474);
		add(textArea_D1);
		textArea_D1.setLineWrap(true);
		textArea_D1.setWrapStyleWord(true);
		
		btnNextTest = new JButton("enviar");
		btnNextTest.setBounds(1081, 732, 92, 29);
		btnNextTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String fromEmail = "sofiablanco.cal@gmail.com";
				final String password = "fvtr pbjr czbk jylm";
				final String toEmail = "sofiablanco.cal@gmail.com";
				final StringBuilder sb = new StringBuilder();

				Properties props = new Properties();

				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};

				Session session = Session.getDefaultInstance(props, auth);
				sendEmail(session, toEmail, "EMAIL DE PRUEBA", sb.toString());
			}
		});
		add(btnNextTest);
		
		btn_volver = new JButton("<--");
		btn_volver.setBounds(20, 764, 117, 29);
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//como cambio al panel padre sin pasarselo como parametro
			}
		});
		add(btn_volver);
		
		textField = new JTextField();
		textField.setBounds(163, 116, 1007, 26);
		add(textField);
		textField.setColumns(10);

	}

	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);

			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "SOFIA"));
			msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
