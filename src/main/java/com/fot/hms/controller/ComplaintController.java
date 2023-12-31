package com.fot.hms.controller;

import com.fot.hms.model.ComplaintEntity;
import com.fot.hms.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ComplaintEntity>> getAllComplaints() {
        List<ComplaintEntity> complaints = complaintService.findAllComplaints()
                .stream()
                .filter(complaint -> !complaint.setIsDeleted()) // Filter out deleted complaints
                .collect(Collectors.toList());
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}")
    public ResponseEntity<ComplaintEntity> getComplaintById (@PathVariable("Id") int Id) {
        ComplaintEntity complaint = complaintService.findComplaintById(Id);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ComplaintEntity> addComplaint(@RequestBody ComplaintEntity complaint) {
        ComplaintEntity newComplaint = complaintService.addComplaint(complaint);
        return new ResponseEntity<>(newComplaint, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ComplaintEntity> updateComplaint(@RequestBody ComplaintEntity complaint) {
        ComplaintEntity updateComplaint = complaintService.updateComplaint(complaint);
        return new ResponseEntity<>(updateComplaint, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteComplaint(@PathVariable("Id") int Id) {
        complaintService.deleteComplaint(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/complaintByUserId/{userId}")
    public ResponseEntity<List<ComplaintEntity>> getComplaintsByUserId(@PathVariable("userId") String userId) {
        List<ComplaintEntity> complaints = complaintService.getComplaintsByUserIndex(userId);

        if (complaints.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(complaints, HttpStatus.OK);
        }
    }


    @PutMapping("/markAsDeleted/{Id}")
    public ResponseEntity<?> markComplaintAsDeleted(@PathVariable("Id") int Id) {
        complaintService.markAsDeleted(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







    @GetMapping("/total-count")
    public ResponseEntity<Long> getTotalComplaintsCount() {
        long count = complaintService.getTotalComplaintsCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/pending-count")
    public ResponseEntity<Long> getPendingComplaintsCount() {
        long count = complaintService.getPendingComplaintsCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/resolved-count")
    public ResponseEntity<Long> getResolvedComplaintsCount() {
        long count = complaintService.getResolvedComplaintsCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/in-progress-count")
    public ResponseEntity<Long> getInProgressComplaintsCount() {
        long count = complaintService.getInProgressComplaintsCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ComplaintEntity>> getComplaintsByUserId(@PathVariable int userId) {
        List<ComplaintEntity> complaints = complaintService.getComplaintsByUserId(userId);
        return ResponseEntity.ok(complaints);
    }



}
