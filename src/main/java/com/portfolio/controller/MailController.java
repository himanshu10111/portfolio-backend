package com.portfolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "*")
public class MailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequest mailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("himashudoye42@gmail.com"); // Set a valid email address
        message.setTo(mailRequest.getEmail());
        message.setSubject(mailRequest.getSubject());
        message.setText("Dear " + mailRequest.getFirstName() + " " + mailRequest.getLastName()
                + ",\n\nYour mail is received. Thank you for reaching out.\n\nBest regards,\nThe Mail API Team");

        emailSender.send(message);
        return "Mail sent successfully!";
    }

}
