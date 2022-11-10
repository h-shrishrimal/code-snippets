package com.tcs.rmg.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tcs.rmg.service.impl.UserServiceImpl;

@Component
public class MailSender {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
		
	@Value("${iaspire.digital.emailid}")
	private String emailId;

	public boolean sendMail(String emailmsg, String emailAddress) throws AddressException, MessagingException {

		List<String> recipient_to = new ArrayList<String>();

		//emailAddress = "Receiver.Test@tcsdev.com";
		if (emailAddress != null && !emailAddress.isEmpty()) {
			if(emailAddress.contains(",")) {
				logger.info("emailAddress  has multiple id email---");
			String[] strList=	emailAddress.split(",");
			recipient_to.addAll(Arrays.asList(strList));
			}else {
				
				recipient_to.add(emailAddress);
			}
			logger.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			logger.info("Email id is:::: "+emailAddress);
			logger.info("Email Message is:::: "+emailmsg);
			logger.info(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			String s = "";
			String subject = "";
			//String sender = "iAspire@tcs.com";
			//String host = "smtp.tcs.com";
			//String host = "172.17.9.236";
			
			//prod cloud smtp host ---start
			//String host = "172.17.9.119"; //Prod
			String host = "smtp.tcs.com";

			//prod cloud smtp host ---end

			String username = "";
			String pass_word = "";
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 25);

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, pass_word);
				}
			});

			//String senderEmailId = "Sender.Test@tcsdev.com";
			//String receiverEmailId = "Receiver.Test@tcsdev.com";
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailId));
			try {
				if (emailmsg.length() > 0) {

					s = emailmsg;
					subject = "Job Applied Notification";

					for (String j : recipient_to)
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(j));
					message.setSubject(subject);
					message.setText(s);
					logger.info("Sending email---");
					message.setContent(s, "text/html");
				//	Transport.send(message);
					logger.info("email send done---");
				}
			} catch (Exception e) {
				logger.error("Error  into  sendmail --"+e);
				throw e;
			}
			return true;
		} else {
			logger.info("--email id is null--");
			return false;
		}
	}
}