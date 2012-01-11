package org.lope.creations.model.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void sendSuccessMail(String egemsUsername, String logType) {
		try {
			String host = "smtp.gmail.com";
			String from = "lopegwapo@gmail.com";
			String pass = "chupijay";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");

			Session session = Session.getInstance(props, new GMailAuthenticator(from, pass));
			MimeMessage message = new MimeMessage(session);
			Address fromAddress;

			fromAddress = new InternetAddress(from);

			Address toAddress = new InternetAddress("lemano@exist.com");

			message.setFrom(fromAddress);
			message.setRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject("Login Success!");
			message.setText("You have successfully "+ logType +" the user " + egemsUsername + ". Congratulations!" );
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			message.saveChanges();
			Transport.send(message);
			transport.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
