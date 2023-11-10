package com.fot.hms.controller;

import com.fot.hms.model.ComplaintEntity;
import com.fot.hms.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ComplaintEntity>> getAllComplaints () {
        List<ComplaintEntity> complaints = complaintService.findAllComplaints();
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




}
