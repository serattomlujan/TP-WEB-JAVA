package util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import javax.mail.*;
import javax.mail.internet.*;




public class Emailer {
	
	public static Emailer instance;
	private Logger logger = LogManager.getLogger(getClass());
	
	private Properties props;
	
	public static Emailer getInstance() throws Exception{
		if (instance==null){
			instance=new Emailer();
		}
		return instance;
	}
	
	
	private Emailer() throws Exception{
		
		InputStream inputStream=getClass().getClassLoader().getResourceAsStream("app.properties");
		try {
			props = new Properties();
			/*props.load(inputStream);*/
			
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.host", "smtp.gmail.com");
			  props.put("mail.smtp.port", "587");
			  props.put("mail.username", "reservar2017java@gmail.com");
			  props.put("mail.password","Java2017");
			 
			
		} catch (Error e) {
			logger.log(Level.ERROR, e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public void send(String to, String subject, String body){

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.username"), props.getProperty("mail.password"));
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to)); //"marianab78@gmail.com"
			message.setSubject(subject); //"Testing Subject"
			message.setText(body); //"Dear Mail Crawler,\n\n No spam to my email, please!"

			Transport.send(message);

		} catch (MessagingException e) {
			logger.log(Level.ERROR, e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
