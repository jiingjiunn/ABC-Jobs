package com.wdf.utility;

import java.util.*;

import javax.mail.*;

import com.wdf.entity.*;

public class TLSEmail {
	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for TLS/STARTTLS: 587
	 */
	public static void sendTLSEmail(Email email) throws MessagingException {
		final String fromEmail = "jiingjiunn@gmail.com"; // requires valid gmail id
		final String password = "lfzslrupwvesgqqk"; // correct password for gmail id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		SendEmail.sendEmail(session, email.getEmail(), email.getSubject(), email.emailBody());
		
//		SendEmail.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment",
//				"SSLEmail Testing Body with Attachment");
//
//		SendEmail.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image",
//				"SSLEmail Testing Body with Image");
	}
}
