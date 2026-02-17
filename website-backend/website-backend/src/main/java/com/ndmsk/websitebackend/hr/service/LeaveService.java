package com.ndmsk.websitebackend.hr.service;

import com.ndmsk.websitebackend.hr.entity.Leave;
import com.ndmsk.websitebackend.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public Leave applyLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
