// =========================
// ContactResponseDTO.java
// =========================
package com.ndmsk.websitebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String message;
}
