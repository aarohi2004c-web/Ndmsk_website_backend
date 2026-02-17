package com.ndmsk.websitebackend.repository;

import com.ndmsk.websitebackend.hr.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    long countByStatus(String pending);

    long countByStartDateBetween(LocalDate firstDayOfMonth, LocalDate today);
}
