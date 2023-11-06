package com.fot.hms.service;

import com.fot.hms.exception.ComplaintNotFoundException;
import com.fot.hms.model.ComplaintEntity;
import com.fot.hms.repo.ComplaintRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComplaintService {
    private final ComplaintRepo complaintRepo;

    @Autowired
    public ComplaintService(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    public List<ComplaintEntity> findAllComplaints(){
        return complaintRepo.findAll();
    }

    public void deleteComplaint(int complaintId){
        complaintRepo.deleteComplaintById(complaintId);
    }

    public ComplaintEntity addComplaint(ComplaintEntity complaintEntity){
        return complaintRepo.save(complaintEntity);
    }

    public ComplaintEntity updateComplaint(ComplaintEntity complaintEntity){
        return complaintRepo.save(complaintEntity);

    }

    public ComplaintEntity findComplaintById(int complaintId) {
        return complaintRepo.findByComplaintId(complaintId)
                .orElseThrow(() -> new ComplaintNotFoundException("Complaint by id " + complaintId + " was not found"));
    }

    public List<ComplaintEntity> getComplaintsByUserIndex(String userIndex) {
        return complaintRepo.getComplaintsByUserIndex(userIndex);
    }



    public void markAsDeleted(int complaintId) {
        ComplaintEntity complaint = findComplaintById(complaintId);
        complaint.setIsDeleted(true); // Set the IsDeleted field to true
        complaintRepo.save(complaint);
    }


}
