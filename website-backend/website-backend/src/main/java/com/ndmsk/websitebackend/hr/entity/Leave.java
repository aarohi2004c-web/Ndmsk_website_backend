package com.ndmsk.websitebackend.hr.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
@Data
@Entity
@Table(name = "leaves")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status;  // PENDING / APPROVED / REJECTED

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Leave() {
        this.status = "PENDING";
    }

    // getters & setters
}
