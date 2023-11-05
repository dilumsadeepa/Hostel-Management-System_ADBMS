package com.fot.hms.controller;


import com.fot.hms.model.ComplaintNotificationEntity;
import com.fot.hms.repo.ComplaintNotificationRepository;
import com.fot.hms.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/complaintNotifications")
public class ComplaintNotificationController {
    private final ComplaintNotificationRepository complaintNotificationRepository;

    @Autowired
    public ComplaintNotificationController(ComplaintNotificationRepository complaintNotificationRepository) {
        this.complaintNotificationRepository = complaintNotificationRepository;
    }

    @GetMapping("/all")
    public List<ComplaintNotificationEntity> getAllComplaintNotifications() {
        return complaintNotificationRepository.findAll();
    }
}
