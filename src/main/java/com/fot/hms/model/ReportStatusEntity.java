package com.fot.hms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "complaint")

public class ReportStatusEntity {
    @Id
    private Long complaintId;
    private String complaint;
    private String status;
    private String inspectionNote;


    public ReportStatusEntity() {
        // Default constructor
    }

    public ReportStatusEntity(Long complaintId, String complaint, String status, String inspectionNote) {
        this.complaintId = complaintId;
        this.complaint = complaint;
        this.status = status;
        this.inspectionNote = inspectionNote;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInspectionNote() {
        return inspectionNote;
    }

    public void setInspectionNote(String inspectionNote) {
        this.inspectionNote = inspectionNote;
    }
}

