
package uiPaneles;

  

import javax.swing.JPanel;

import javax.swing.JLabel;

import javax.swing.JTextArea;

  

import com.sun.jdi.connect.Transport;

import com.sun.net.httpserver.Authenticator;

  

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.net.PasswordAuthentication;

import java.util.Properties;

  

import javax.mail.Message;

import javax.mail.Session;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import javax.swing.JButton;

  

public class PanelTest2 extends JPanel {

private JLabel lbl_msgInternacional;

private JTextArea textArea_D1;

private JTextArea textArea_D2;

private JTextArea textArea_D3;

  

private JLabel lbl_msgA;

private JTextArea textArea_A1;

private JTextArea textArea_A2;

private JTextArea textArea_A3;

  

private JLabel lbl_msgB;

private JTextArea textArea_B1;

private JTextArea textArea_B2;

private JTextArea textArea_B3;

  

private JButton btnEnviar;

  

private JButton btnVolver;

  

public PanelTest2(PanelTest panelTest) {

setLayout(null);

  

lbl_msgInternacional = new JLabel("INTERNACIONAL");

lbl_msgInternacional.setBounds(20, 19, 123, 16);

add(lbl_msgInternacional);

  

textArea_D1 = new JTextArea();

textArea_D1.setEnabled(false);

textArea_D1.setEditable(false);

textArea_D1.setBounds(20, 47, 966, 40);

add(textArea_D1);

  

textArea_D2 = new JTextArea();

textArea_D2.setEnabled(false);

textArea_D2.setEditable(false);

textArea_D2.setBounds(20, 99, 966, 40);

add(textArea_D2);

  

textArea_D3 = new JTextArea();

textArea_D3.setEnabled(false);

textArea_D3.setEditable(false);

textArea_D3.setBounds(20, 151, 966, 40);

add(textArea_D3);

  

lbl_msgA = new JLabel("A");

lbl_msgA.setBounds(20, 235, 123, 16);

add(lbl_msgA);

  

textArea_A1 = new JTextArea();

textArea_A1.setEnabled(false);

textArea_A1.setEditable(false);

textArea_A1.setBounds(20, 263, 966, 40);

add(textArea_A1);

  

textArea_A2 = new JTextArea();

textArea_A2.setEnabled(false);

textArea_A2.setEditable(false);

textArea_A2.setBounds(20, 315, 966, 40);

add(textArea_A2);

  

textArea_A3 = new JTextArea();

textArea_A3.setEnabled(false);

textArea_A3.setEditable(false);

textArea_A3.setBounds(20, 367, 966, 40);

add(textArea_A3);

  

lbl_msgB = new JLabel("B");

lbl_msgB.setBounds(20, 451, 123, 16);

add(lbl_msgB);

  

textArea_B1 = new JTextArea();

textArea_B1.setEnabled(false);

textArea_B1.setEditable(false);

textArea_B1.setBounds(20, 479, 966, 40);

add(textArea_B1);

  

textArea_B2 = new JTextArea();

textArea_B2.setEnabled(false);

textArea_B2.setEditable(false);

textArea_B2.setBounds(20, 531, 966, 40);

add(textArea_B2);

  

textArea_B3 = new JTextArea();

textArea_B3.setEnabled(false);

textArea_B3.setEditable(false);

textArea_B3.setBounds(20, 583, 966, 40);

add(textArea_B3);

  

btnEnviar = new JButton("ENVIAR");

btnEnviar.setBounds(869, 678, 117, 29);

btnEnviar.addActionListener(new ActionListener() {

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

sb.append();

Session session = Session.getDefaultInstance(props, auth);

sendEmail(session, toEmail, "EMAIL", sb.toString());

}

});

add(btnEnviar);

  

btnVolver = new JButton("<--");

btnVolver.setBounds(20, 678, 117, 29);

btnVolver.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

panelTest.setVisible(true);

}

});

add(btnVolver);

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

  

private static final long serialVersionUID = 1L;

  

}6