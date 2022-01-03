package com.exemple.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class emailController {
	@Autowired
	EmailService emailService;
	
	
	@GetMapping("/sendEmail")
	
	public String sendEmail() {
		return emailService.sendEmail();
	}


}
