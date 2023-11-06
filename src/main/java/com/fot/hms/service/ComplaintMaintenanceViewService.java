package com.fot.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fot.hms.model.ComplaintMaintenanceViewEntity;
import com.fot.hms.repo.ComplaintMaintenanceViewRepository;

import java.util.List;

@Service
public class ComplaintMaintenanceViewService {

    @Autowired
    private ComplaintMaintenanceViewRepository repository;

    public List<ComplaintMaintenanceViewEntity> getAllComplaintMaintenanceRecords() {
        return repository.findAll();
    }

    public ComplaintMaintenanceViewEntity findComplaintMaintenanceRecordByComplaintId(int complaintId) {
        return repository.findByComplaintId(complaintId);
    }
}
