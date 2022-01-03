package com.exemple.demo.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javamailsender;
	
	
	public String sendEmail() {
		SimpleMailMessage message =new SimpleMailMessage();
		message.setFrom("chaima.naoueni14@gmail.com");
		message.setTo("chaima.naoueni14@gmail.com");
		message.setSubject("test subject");
		message.setText("Hello , Your Order is Confirmed");
		
		javamailsender.send(message);
		
		return ("Hello Your Order Confirmed");
	}


}
