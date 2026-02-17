package com.ndmsk.websitebackend.hr.controller;

import com.ndmsk.websitebackend.hr.entity.Employee;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hr")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    // ✅ Create Employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // ✅ Get All Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Get Only Active Employees
    @GetMapping("/employees/active")
    public List<Employee> getActiveEmployees() {
        return employeeRepository.findByActiveTrue();
    }

    // ✅ Deactivate Employee
    @PutMapping("/employees/{id}/deactivate")
    public String deactivateEmployee(@PathVariable Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setActive(false);
        employeeRepository.save(emp);

        return "Employee deactivated successfully";
    }

    // ✅ Delete Employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }
}
