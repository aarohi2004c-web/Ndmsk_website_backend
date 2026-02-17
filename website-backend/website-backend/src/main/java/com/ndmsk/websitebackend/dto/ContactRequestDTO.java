// =========================
// ContactRequestDTO.java
// =========================
package com.ndmsk.websitebackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequestDTO {
    private String name;
    private String email;
    private String message;
}
