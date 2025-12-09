package uiPaneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

public class PanelTest extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lbl_msgDeporte;
	private JTextArea textArea_D1;
	private JTextArea textArea_D2;
	private JTextArea textArea_D3;
	private JLabel lbl_msgEconomia;
	private JTextArea textArea_E1;
	private JTextArea textArea_E2;
	private JTextArea textArea_E3;
	private JLabel lbl_msgNacional;
	private JTextArea textArea_N1;
	private JTextArea textArea_N2;
	private JTextArea textArea_N3;
	private JButton btnNextTest;

	public PanelTest() {
		setLayout(null);
		   setBounds(0, 0, 1200, 800);

		lbl_msgDeporte = new JLabel("DEPORTE");
		lbl_msgDeporte.setBounds(20, 16, 108, 16);
		add(lbl_msgDeporte);

		textArea_D1 = new JTextArea(NoticiasService.exNot_dMarca());
		textArea_D1.setEnabled(false);
		textArea_D1.setEditable(false);
		textArea_D1.setBounds(20, 44, 537, 60);
		add(textArea_D1);
		textArea_D1.setLineWrap(true);
		textArea_D1.setWrapStyleWord(true);

		textArea_D2 = new JTextArea(NoticiasService.exNot_dAs());
		textArea_D2.setEnabled(false);
		textArea_D2.setEditable(false);
		textArea_D2.setBounds(20, 116, 537, 60);
		add(textArea_D2);
		textArea_D2.setLineWrap(true);
		textArea_D2.setWrapStyleWord(true);

		textArea_D3 = new JTextArea(NoticiasService.exNot_dMundoDep());
		textArea_D3.setEnabled(false);
		textArea_D3.setEditable(false);
		textArea_D3.setBounds(20, 197, 537, 60);
		add(textArea_D3);
		textArea_D3.setLineWrap(true);
		textArea_D3.setWrapStyleWord(true);

		lbl_msgEconomia = new JLabel("ECONOMIA");
		lbl_msgEconomia.setBounds(20, 269, 123, 16);
		add(lbl_msgEconomia);

		textArea_E1 = new JTextArea(NoticiasService.exNot_eEconomista());
		textArea_E1.setEnabled(false);
		textArea_E1.setEditable(false);
		textArea_E1.setBounds(20, 297, 537, 60);
		add(textArea_E1);
		textArea_E1.setLineWrap(true);
		textArea_E1.setWrapStyleWord(true);

		textArea_E2 = new JTextArea(NoticiasService.exNot_eDigital());
		textArea_E2.setEnabled(false);
		textArea_E2.setEditable(false);
		textArea_E2.setBounds(20, 367, 537, 60);
		add(textArea_E2);
		textArea_E2.setLineWrap(true);
		textArea_E2.setWrapStyleWord(true);

		textArea_E3 = new JTextArea(NoticiasService.exNot_eExpansion());
		textArea_E3.setEnabled(false);
		textArea_E3.setEditable(false);
		textArea_E3.setBounds(20, 439, 537, 60);
		add(textArea_E3);
		textArea_E3.setLineWrap(true);
		textArea_E3.setWrapStyleWord(true);

		lbl_msgNacional = new JLabel("NACIONAL");
		lbl_msgNacional.setBounds(20, 522, 123, 16);
		add(lbl_msgNacional);

		textArea_N1 = new JTextArea();
		textArea_N1.setEnabled(false);
		textArea_N1.setEditable(false);
		textArea_N1.setBounds(20, 550, 537, 60);
		add(textArea_N1);

		textArea_N2 = new JTextArea();
		textArea_N2.setEnabled(false);
		textArea_N2.setEditable(false);
		textArea_N2.setBounds(20, 639, 537, 60);
		add(textArea_N2);

		textArea_N3 = new JTextArea();
		textArea_N3.setEnabled(false);
		textArea_N3.setEditable(false);
		textArea_N3.setBounds(20, 723, 537, 60);
		add(textArea_N3);

		btnNextTest = new JButton("->");
		btnNextTest.setBounds(1152, 765, 48, 29);
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
				sb.append("--\nDEPORTES\n--\n").append(textArea_D1.getText()).append("\n").append(textArea_D2.getText())
						.append("\n").append(textArea_D3.getText()).append("--\nECONOMIA\n--\n")
						.append(textArea_E1.getText()).append("\n").append(textArea_E2.getText()).append("\n")
						.append(textArea_E3.getText());
				Session session = Session.getDefaultInstance(props, auth);
				sendEmail(session, toEmail, "EMAIL", sb.toString());
			}
		});
		add(btnNextTest);
		
		JLabel lbl_msgDeporte_1 = new JLabel("DEPORTE");
		lbl_msgDeporte_1.setBounds(614, 16, 108, 16);
		add(lbl_msgDeporte_1);
		
		JTextArea textArea_D1_1 = new JTextArea("");
		textArea_D1_1.setWrapStyleWord(true);
		textArea_D1_1.setLineWrap(true);
		textArea_D1_1.setEnabled(false);
		textArea_D1_1.setEditable(false);
		textArea_D1_1.setBounds(614, 44, 537, 60);
		add(textArea_D1_1);
		
		JTextArea textArea_D2_1 = new JTextArea("");
		textArea_D2_1.setWrapStyleWord(true);
		textArea_D2_1.setLineWrap(true);
		textArea_D2_1.setEnabled(false);
		textArea_D2_1.setEditable(false);
		textArea_D2_1.setBounds(614, 116, 537, 60);
		add(textArea_D2_1);
		
		JTextArea textArea_D3_1 = new JTextArea("");
		textArea_D3_1.setWrapStyleWord(true);
		textArea_D3_1.setLineWrap(true);
		textArea_D3_1.setEnabled(false);
		textArea_D3_1.setEditable(false);
		textArea_D3_1.setBounds(614, 197, 537, 60);
		add(textArea_D3_1);
		
		JLabel lbl_msgEconomia_1 = new JLabel("ECONOMIA");
		lbl_msgEconomia_1.setBounds(614, 269, 123, 16);
		add(lbl_msgEconomia_1);
		
		JTextArea textArea_E1_1 = new JTextArea("");
		textArea_E1_1.setWrapStyleWord(true);
		textArea_E1_1.setLineWrap(true);
		textArea_E1_1.setEnabled(false);
		textArea_E1_1.setEditable(false);
		textArea_E1_1.setBounds(614, 297, 537, 60);
		add(textArea_E1_1);
		
		JTextArea textArea_E2_1 = new JTextArea("");
		textArea_E2_1.setWrapStyleWord(true);
		textArea_E2_1.setLineWrap(true);
		textArea_E2_1.setEnabled(false);
		textArea_E2_1.setEditable(false);
		textArea_E2_1.setBounds(614, 367, 537, 60);
		add(textArea_E2_1);
		
		JTextArea textArea_E3_1 = new JTextArea("");
		textArea_E3_1.setWrapStyleWord(true);
		textArea_E3_1.setLineWrap(true);
		textArea_E3_1.setEnabled(false);
		textArea_E3_1.setEditable(false);
		textArea_E3_1.setBounds(614, 439, 537, 60);
		add(textArea_E3_1);
		
		JLabel lbl_msgNacional_1 = new JLabel("NACIONAL");
		lbl_msgNacional_1.setBounds(614, 522, 123, 16);
		add(lbl_msgNacional_1);
		
		JTextArea textArea_N1_1 = new JTextArea();
		textArea_N1_1.setEnabled(false);
		textArea_N1_1.setEditable(false);
		textArea_N1_1.setBounds(614, 550, 537, 60);
		add(textArea_N1_1);
		
		JTextArea textArea_N2_1 = new JTextArea();
		textArea_N2_1.setEnabled(false);
		textArea_N2_1.setEditable(false);
		textArea_N2_1.setBounds(614, 639, 537, 60);
		add(textArea_N2_1);
		
		JTextArea textArea_N3_1 = new JTextArea();
		textArea_N3_1.setEnabled(false);
		textArea_N3_1.setEditable(false);
		textArea_N3_1.setBounds(614, 723, 537, 60);
		add(textArea_N3_1);
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
