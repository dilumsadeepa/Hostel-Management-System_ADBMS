package com.fot.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fot.hms.model.ComplaintMaintenanceViewEntity;
import com.fot.hms.service.ComplaintMaintenanceViewService;

import java.util.List;


@RestController
@RequestMapping("/complaint_maintenance")
public class ComplaintMaintenanceViewController {
    @Autowired
    private ComplaintMaintenanceViewService service;

    @GetMapping("/all")
    public List<ComplaintMaintenanceViewEntity> getAllComplaintMaintenanceRecords() {
        return service.getAllComplaintMaintenanceRecords();
    }

    @GetMapping("/find/{complaintId}")
    public ComplaintMaintenanceViewEntity findComplaintMaintenanceRecordByComplaintId(@PathVariable int complaintId) {
        return service.findComplaintMaintenanceRecordByComplaintId(complaintId);
    }
}
