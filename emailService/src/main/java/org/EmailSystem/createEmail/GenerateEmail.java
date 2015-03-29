package org.EmailSystem.createEmail;

import org.EmailSystem.content.EmailMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class GenerateEmail {

	@Autowired
	private MailSender mailSender;

	public GenerateEmail(MailSender mailSender) {
		this.mailSender = mailSender;

	}

	public void sendMail(String to, String firstName, String lastName) {

		SimpleMailMessage message = new SimpleMailMessage();
		EmailMessageBuilder builder = new EmailMessageBuilder();
		message.setTo(to);
		message.setSubject(builder.getWelcomeSubject());
		message.setText(builder.getWelcomeBody(firstName, lastName));
		mailSender.send(message);
	}

}
