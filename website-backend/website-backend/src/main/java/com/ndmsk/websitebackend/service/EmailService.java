package com.ndmsk.websitebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendContactMail(String name, String email, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("aarohindmsk@gmail.com");   // admin email
        mail.setSubject("New Contact Form Submission");
        mail.setText(
                "Name: " + name + "\n" +
                        "Email: " + email + "\n\n" +
                        "Message:\n" + message
        );

        mailSender.send(mail);
    }
}
