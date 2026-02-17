package com.ndmsk.websitebackend.hr.service;

import com.ndmsk.websitebackend.hr.entity.Employee;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee update(Long id, Employee updated) {
        Employee employee = getById(id);
        employee.setName(updated.getName());
        employee.setEmail(updated.getEmail());
        employee.setDepartment(updated.getDepartment());
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
