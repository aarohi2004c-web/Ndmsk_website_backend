package com.ndmsk.websitebackend.controller;

import com.ndmsk.websitebackend.dto.ContactResponseDTO;
import com.ndmsk.websitebackend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/contacts")
@RequiredArgsConstructor
public class AdminContactController {

    private final ContactService contactService;

    @GetMapping
    public List<ContactResponseDTO> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactResponseDTO getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
