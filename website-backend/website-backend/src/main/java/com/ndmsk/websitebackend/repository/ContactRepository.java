// =========================
// ContactRepository.java
// =========================
package com.ndmsk.websitebackend.repository;

import com.ndmsk.websitebackend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
