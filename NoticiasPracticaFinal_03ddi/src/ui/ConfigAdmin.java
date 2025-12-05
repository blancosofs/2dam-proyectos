package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import service.GestorNoticias;

import javax.swing.JTextArea;

public class ConfigAdmin {

	private JFrame frame;
	private JLayeredPane layeredPane;

	private JPanel panel_hora;

	private JPanel panel_altaBaja;

	public String rdbt_num;
	private JPanel panel_config;
	private JLabel lbl_config;
	private JButton btn_alta;
	private JButton btn_test;
	private JButton btn_hora;
	private JPanel panel_test;
	private JLabel lblNewLabel;
	private JLabel lbl_dep;
	private JLabel lbl_e;
	private JButton btn_mandarEmail;

	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JTextArea textArea_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigAdmin window = new ConfigAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfigAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(layeredPane);

		panel_test = new JPanel();
		panel_test.setBounds(0, 0, 785, 560);
		layeredPane.add(panel_test);
		panel_test.setLayout(null);
		panel_test.setVisible(false);

		lblNewLabel = new JLabel("NOTICIAS");
		lblNewLabel.setBounds(377, 11, 128, 35);
		panel_test.add(lblNewLabel);

		lbl_dep = new JLabel("DEPORTES");
		lbl_dep.setBounds(10, 38, 128, 14);
		panel_test.add(lbl_dep);

		lbl_e = new JLabel("ECONOMIA");
		lbl_e.setBounds(10, 245, 128, 14);
		panel_test.add(lbl_e);

		textArea = new JTextArea(GestorNoticias.exNot_dMarca());
		textArea.setEditable(false);
		textArea.setBounds(10, 57, 748, 41);
		panel_test.add(textArea);

		textArea_1 = new JTextArea(GestorNoticias.exNot_dAs());
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 124, 748, 41);
		panel_test.add(textArea_1);

		textArea_2 = new JTextArea(GestorNoticias.exNot_dMundoDep());
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 193, 748, 41);
		panel_test.add(textArea_2);

		textArea_3 = new JTextArea(GestorNoticias.exNot_eEconomista());
		textArea_3.setEditable(false);
		textArea_3.setBounds(10, 270, 748, 41);
		panel_test.add(textArea_3);

		textArea_4 = new JTextArea(GestorNoticias.exNot_eDigital());
		textArea_4.setEditable(false);
		textArea_4.setBounds(10, 337, 748, 41);
		panel_test.add(textArea_4);

		textArea_5 = new JTextArea(GestorNoticias.exNot_eExpansion());
		textArea_5.setEditable(false);
		textArea_5.setBounds(10, 398, 748, 41);
		panel_test.add(textArea_5);

		btn_mandarEmail = new JButton("TEST EMAIL");
		btn_mandarEmail.setBounds(565, 466, 193, 23);
		panel_test.add(btn_mandarEmail);
		btn_mandarEmail.addActionListener(new ActionListener() {
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
				sb.append("--\nDEPORTES\n--\n").append(textArea.getText()).append("\n").append(textArea_1.getText()).append("\n")
				.append(textArea_2.getText()).append("--\nECONOMIA\n--\n").append(textArea_3.getText()).append("\n").append(textArea_4.getText()).append("\n")
						.append(textArea_5.getText());
				Session session = Session.getDefaultInstance(props, auth);
				sendEmail(session, toEmail, "EMAIL", sb.toString());
			}
		});

		panel_config = new JPanel();
		panel_config.setLayout(null);
		panel_config.setBackground(new Color(255, 204, 255));
		panel_config.setBounds(0, 0, 785, 560);
		layeredPane.add(panel_config);

		btn_alta = new JButton("");
		btn_alta.setBounds(39, 178, 168, 67);
		panel_config.add(btn_alta);

		btn_test = new JButton("TEST");
		btn_test.setBounds(308, 311, 168, 67);
		panel_config.add(btn_test);
		btn_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_config.setVisible(false);
				panel_test.setVisible(true);
			}
		});

		lbl_config = new JLabel("CONFIGURACION");
		lbl_config.setBounds(39, 37, 688, 31);
		panel_config.add(lbl_config);

		btn_hora = new JButton("HORA");
		btn_hora.setBounds(559, 178, 168, 67);
		panel_config.add(btn_hora);

		panel_altaBaja = new JPanel();
		panel_altaBaja.setBackground(new Color(0, 153, 255));
		panel_altaBaja.setBounds(0, 0, 785, 560);
		layeredPane.add(panel_altaBaja);
		panel_altaBaja.setVisible(false);

		panel_hora = new JPanel();
		panel_hora.setBackground(new Color(153, 153, 255));
		panel_hora.setBounds(0, 0, 785, 560);
		layeredPane.add(panel_hora);
		panel_hora.setVisible(false);

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
