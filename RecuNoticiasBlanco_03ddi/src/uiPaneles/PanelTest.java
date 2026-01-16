package uiPaneles;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.NoticiasService;

import java.awt.TextArea;
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

public class PanelTest extends JPanel {
	private static final long serialVersionUID = 1L;

	private TextArea textArea;

	private JButton btnNextTest;

	private JButton btn_exit;
	private JButton btn_volver;

	public PanelTest() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		textArea = new TextArea();
		textArea.setBounds(50, 73, 956, 486);
		textArea.setEditable(false);
		textArea.append("---\nTus noticias son:\n---\n");
		textArea.append(NoticiasService.exNoticias());
		add(textArea);

		btnNextTest = new JButton("enviar");
		btnNextTest.setBounds(539, 652, 92, 29);
		btnNextTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String toEmail = "sofiablanco.cal@gmail.com";

				final String fromEmail = "sofiablanco.cal@gmail.com";
				final String password = "fvtr pbjr czbk jylm";
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
				sb.append(NoticiasService.exNoticias());

				Session session = Session.getDefaultInstance(props, auth);
				sendEmail(session, toEmail, "NOTICIAS DAM", sb.toString());
			}
		});
		add(btnNextTest);

		btn_volver = new JButton("<--");
		btn_volver.setBounds(529, 738, 117, 29);
		btn_volver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PanelAdmin.mostrar2("config");
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

	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);

			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "BLANCO SOFIA"));
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