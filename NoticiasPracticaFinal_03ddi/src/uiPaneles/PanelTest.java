package uiPaneles;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.ControlErrores;
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
	private JLabel lbl_msgInternacional;
	private JTextArea textArea_I1;
	private JTextArea textArea_I2;
	private JTextArea textArea_I3;
	private JLabel lbl_msgMusica;
	private JTextArea textArea_M1;
	private JTextArea textArea_M2;
	private JTextArea textArea_M3;
	private JLabel lbl_msgAleatorio;
	private JTextArea textArea_A1;
	private JTextArea textArea_A2;
	private JTextArea textArea_A3;
	private JButton btnNextTest;

	private JTextField textField_email;
	private JLabel lbl_msgEmail;
	
	private JButton btn_exit;
	private JButton btn_volver;
	

	public PanelTest() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		lbl_msgDeporte = new JLabel("DEPORTE");
		lbl_msgDeporte.setBounds(20, 184, 108, 16);
		add(lbl_msgDeporte);

		textArea_D1 = new JTextArea(NoticiasService.exNot_dMarca());
		textArea_D1.setEditable(false);
		textArea_D1.setBounds(20, 212, 537, 34);
		add(textArea_D1);
		textArea_D1.setLineWrap(true);
		textArea_D1.setWrapStyleWord(true);

		textArea_D2 = new JTextArea(NoticiasService.exNot_dAs());
		textArea_D2.setEditable(false);
		textArea_D2.setBounds(20, 258, 537, 34);
		add(textArea_D2);
		textArea_D2.setLineWrap(true);
		textArea_D2.setWrapStyleWord(true);

		textArea_D3 = new JTextArea(NoticiasService.exNot_dMundoDep());
		textArea_D3.setEditable(false);
		textArea_D3.setBounds(20, 310, 537, 34);
		add(textArea_D3);
		textArea_D3.setLineWrap(true);
		textArea_D3.setWrapStyleWord(true);
//------------------------------------------------------------------------
		lbl_msgEconomia = new JLabel("ECONOMIA");
		lbl_msgEconomia.setBounds(20, 356, 123, 16);
		add(lbl_msgEconomia);

		textArea_E1 = new JTextArea(NoticiasService.exNot_eEconomista());
		textArea_E1.setEditable(false);
		textArea_E1.setBounds(20, 384, 537, 34);
		add(textArea_E1);
		textArea_E1.setLineWrap(true);
		textArea_E1.setWrapStyleWord(true);

		textArea_E2 = new JTextArea(NoticiasService.exNot_eDigital());
		textArea_E2.setEditable(false);
		textArea_E2.setBounds(20, 430, 537, 34);
		add(textArea_E2);
		textArea_E2.setLineWrap(true);
		textArea_E2.setWrapStyleWord(true);

		textArea_E3 = new JTextArea(NoticiasService.exNot_eExpansion());
		textArea_E3.setEditable(false);
		textArea_E3.setBounds(20, 476, 537, 34);
		add(textArea_E3);
		textArea_E3.setLineWrap(true);
		textArea_E3.setWrapStyleWord(true);
		// ------------------------------------------------------------------------
		lbl_msgNacional = new JLabel("NACIONAL");
		lbl_msgNacional.setBounds(20, 522, 123, 16);
		add(lbl_msgNacional);

		textArea_N1 = new JTextArea(NoticiasService.exNot_nRtve());
		textArea_N1.setEditable(false);
		textArea_N1.setBounds(20, 550, 537, 34);
		add(textArea_N1);
		textArea_N1.setLineWrap(true);
		textArea_N1.setWrapStyleWord(true);

		textArea_N2 = new JTextArea(NoticiasService.exNot_nTheObjetive());
		textArea_N2.setEditable(false);
		textArea_N2.setBounds(20, 596, 537, 34);
		add(textArea_N2);
		textArea_N2.setLineWrap(true);
		textArea_N2.setWrapStyleWord(true);

		textArea_N3 = new JTextArea(NoticiasService.exNot_nElMundo());
		textArea_N3.setEditable(false);
		textArea_N3.setBounds(20, 642, 537, 34);
		add(textArea_N3);
		textArea_N3.setLineWrap(true);
		textArea_N3.setWrapStyleWord(true);
		// ------------------------------------------------------------------------
		lbl_msgInternacional = new JLabel("INTERNACIONAL");
		lbl_msgInternacional.setBounds(614, 184, 108, 16);
		add(lbl_msgInternacional);

		textArea_I1 = new JTextArea(NoticiasService.exNot_iEuropaPress());
		textArea_I1.setWrapStyleWord(true);
		textArea_I1.setLineWrap(true);
		textArea_I1.setEditable(false);
		textArea_I1.setBounds(614, 212, 537, 34);
		add(textArea_I1);
		textArea_I1.setLineWrap(true);
		textArea_I1.setWrapStyleWord(true);

		textArea_I2 = new JTextArea(NoticiasService.exNot_i20mins());
		textArea_I2.setWrapStyleWord(true);
		textArea_I2.setLineWrap(true);
		textArea_I2.setEditable(false);
		textArea_I2.setBounds(614, 258, 537, 34);
		add(textArea_I2);
		textArea_I2.setLineWrap(true);
		textArea_I2.setWrapStyleWord(true);

		textArea_I3 = new JTextArea(NoticiasService.exNot_iLaRazon());
		textArea_I3.setWrapStyleWord(true);
		textArea_I3.setLineWrap(true);
		textArea_I3.setEditable(false);
		textArea_I3.setBounds(614, 310, 537, 34);
		add(textArea_I3);
		textArea_I3.setLineWrap(true);
		textArea_I3.setWrapStyleWord(true);
		// ------------------------------------------------------------------------
		lbl_msgMusica = new JLabel("MUSICA");
		lbl_msgMusica.setBounds(614, 356, 123, 16);
		add(lbl_msgMusica);

		textArea_M1 = new JTextArea(NoticiasService.exNot_mRockFm());
		textArea_M1.setWrapStyleWord(true);
		textArea_M1.setLineWrap(true);
		textArea_M1.setEditable(false);
		textArea_M1.setBounds(614, 384, 537, 34);
		add(textArea_M1);
		textArea_M1.setLineWrap(true);
		textArea_M1.setWrapStyleWord(true);

		textArea_M2 = new JTextArea(NoticiasService.exNot_mRadiole());
		textArea_M2.setWrapStyleWord(true);
		textArea_M2.setLineWrap(true);
		textArea_M2.setEditable(false);
		textArea_M2.setBounds(614, 430, 537, 34);
		add(textArea_M2);
		textArea_M2.setLineWrap(true);
		textArea_M2.setWrapStyleWord(true);

		textArea_M3 = new JTextArea(NoticiasService.exNot_mPaisMusica());
		textArea_M3.setWrapStyleWord(true);
		textArea_M3.setLineWrap(true);
		textArea_M3.setEditable(false);
		textArea_M3.setBounds(614, 476, 537, 34);
		add(textArea_M3);
		textArea_M3.setLineWrap(true);
		textArea_M3.setWrapStyleWord(true);
		// ------------------------------------------------------------------------
		lbl_msgAleatorio = new JLabel("ALEATORIO");
		lbl_msgAleatorio.setBounds(614, 522, 123, 16);
		add(lbl_msgAleatorio);

		textArea_A1 = new JTextArea(NoticiasService.exNot_aCbr());
		textArea_A1.setEditable(false);
		textArea_A1.setBounds(614, 550, 537, 34);
		add(textArea_A1);
		textArea_A1.setLineWrap(true);
		textArea_A1.setWrapStyleWord(true);

		textArea_A2 = new JTextArea(NoticiasService.exNot_aLecturalia());
		textArea_A2.setEditable(false);
		textArea_A2.setBounds(614, 596, 537, 34);
		add(textArea_A2);
		textArea_A2.setLineWrap(true);
		textArea_A2.setWrapStyleWord(true);

		textArea_A3 = new JTextArea(NoticiasService.exNot_a9to5());
		textArea_A3.setEditable(false);
		textArea_A3.setBounds(614, 642, 537, 34);
		add(textArea_A3);
		textArea_A3.setLineWrap(true);
		textArea_A3.setWrapStyleWord(true);
		// ------------------------------------------------------------------------
		lbl_msgEmail = new JLabel("Email:");
		lbl_msgEmail.setBounds(22, 121, 129, 16);
		add(lbl_msgEmail);

		textField_email = new JTextField();
		textField_email.setBounds(163, 116, 1007, 26);
		add(textField_email);
		textField_email.setColumns(10);

		btnNextTest = new JButton("enviar");
		btnNextTest.setBounds(538, 688, 92, 29);
		btnNextTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String toEmail = textField_email.getText();
				if ((textField_email.getText()) != null) {
					if (!ControlErrores.comprobarEmail(toEmail)) {
						String msg = "[error] Email invalido";
						JOptionPane.showMessageDialog(null, msg, "", 1);

					} else {
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
						sb.append("--\nDEPORTES\n--\n").append("Titular 1: ").append(textArea_D1.getText()).append("\n")
								.append("Titular 2: ").append(textArea_D2.getText()).append("\n").append("Titular 3: ")
								.append(textArea_D3.getText()).append("\n").append("--\nECONOMIA\n--\n")
								.append("Titular 4: ").append(textArea_E1.getText()).append("\n").append("Titular 5: ")
								.append(textArea_E2.getText()).append("\n").append("Titular 6: ")
								.append(textArea_E3.getText()).append("\n").append("--\nNACIONAL\n--\n")
								.append("Titular 7: ").append(textArea_N1.getText()).append("\n").append("Titular 8: ")
								.append(textArea_N2.getText()).append("\n").append("Titular 9: ")
								.append(textArea_N3.getText()).append("\n").append("--\nINTERNACIONAL\n--\n")
								.append("Titular 10: ").append(textArea_I1.getText()).append("\n")
								.append("Titular 11: ").append(textArea_I2.getText()).append("\n")
								.append("Titular 12: ").append(textArea_I3.getText()).append("\n")
								.append("--\nMUSICA\n--\n").append("Titular 13: ").append(textArea_M1.getText())
								.append("\n").append("Titular 14: ").append(textArea_M2.getText()).append("\n")
								.append("Titular 15: ").append(textArea_M3.getText()).append("\n")
								.append("--\nALEATORIO\n--\n").append("Titular 16: ").append(textArea_A1.getText())
								.append("\n").append("Titular 17: ").append(textArea_A2.getText()).append("\n")
								.append("Titular 18: ").append(textArea_A3.getText());

						Session session = Session.getDefaultInstance(props, auth);
						sendEmail(session, toEmail, "NOTICIAS DAM", sb.toString());
					}
				} else {
					String msg = "[error] Email vacio";
					JOptionPane.showMessageDialog(null, msg, "", 1);

				}

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