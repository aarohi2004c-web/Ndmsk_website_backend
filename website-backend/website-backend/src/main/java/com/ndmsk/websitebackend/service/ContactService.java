package com.ndmsk.websitebackend.service;

import com.ndmsk.websitebackend.dto.ContactRequestDTO;
import com.ndmsk.websitebackend.dto.ContactResponseDTO;
import com.ndmsk.websitebackend.model.Contact;
import com.ndmsk.websitebackend.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final EmailService emailService;

    // ================= USER CONTACT FORM =================
    public ContactResponseDTO saveContact(ContactRequestDTO dto) {

        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setMessage(dto.getMessage());

        Contact saved = contactRepository.save(contact);

        // SEND EMAIL TO ADMIN
        emailService.sendContactMail(
                saved.getName(),
                saved.getEmail(),
                saved.getMessage()
        );

        return mapToDTO(saved);
    }

    // ================= ADMIN APIs =================
    public List<ContactResponseDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ContactResponseDTO getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        return mapToDTO(contact);
    }

    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contact not found");
        }
        contactRepository.deleteById(id);
    }

    // ================= COMMON MAPPER =================
    private ContactResponseDTO mapToDTO(Contact contact) {
        return new ContactResponseDTO(
                contact.getId(),
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );
    }
}
