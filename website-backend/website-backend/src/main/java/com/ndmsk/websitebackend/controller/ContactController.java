package com.ndmsk.websitebackend.controller;

import com.ndmsk.websitebackend.model.Contact;
import com.ndmsk.websitebackend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/contact")
    public Contact saveContact(@RequestBody Contact contact) {

        /* Saving to the database */
        Contact savedContact = contactRepository.save(contact);

        // Send Email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("aarohindmsk@gmail.com");   // <-- Gmail
        message.setSubject("New Contact Form Submission");
        message.setText(
                "Name: " + contact.getName() +
                        "\nEmail: " + contact.getEmail() +
                        "\nMessage: " + contact.getMessage()
        );

        mailSender.send(message);

        return savedContact;
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}