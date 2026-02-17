package com.ndmsk.websitebackend.hr.repository;

import com.ndmsk.websitebackend.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByActiveTrue();

}
