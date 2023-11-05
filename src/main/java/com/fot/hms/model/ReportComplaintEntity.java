package com.fot.hms.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity

public class ReportComplaintEntity {

    @Id
    @GeneratedValue
    @Column(name = "complaint_id")
    private Long complaintId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_index")
    private String userIndex;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "complaint_date")
    private String complaintDate;

    @Column(name = "status")
    private String status;


    // Constructors, getters, and setters

    public ReportComplaintEntity() {
    }

    public ReportComplaintEntity(Long userId, String userIndex, String complaint, String complaintDate, String status) {
        this.userId = userId;
        this.userIndex = userIndex;
        this.complaint = complaint;
        this.complaintDate = complaintDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(String userIndex) {
        this.userIndex = userIndex;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
