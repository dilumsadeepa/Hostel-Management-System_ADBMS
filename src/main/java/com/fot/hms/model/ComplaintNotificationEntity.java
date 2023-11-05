package com.fot.hms.model;

import jakarta.persistence.*;
import java.time.LocalDate; // Import LocalDateTime
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.util.Date;

@Entity
@Table(name = "complaintNotification", schema = "hms", catalog = "")
public class ComplaintNotificationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_index")
    private String userIndex;

    @Column(name = "complaint", columnDefinition = "TEXT")
    private String complaint;

    @Column(name = "res_id")
    private int resId;


    @Column(name = "evidence_image")
    private String evidenceImage;

    @Column(name = "status")
    private String status;

    @Column(name = "to_whom")
    private int toWhom;

    @Column(name = "complaint_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate complaint_Date;

    public ComplaintNotificationEntity() {
    }

    public ComplaintNotificationEntity(final int complaintId, final int userId, final String userIndex, final String complaint, final int resId, final String evidenceImage, final String status, final int toWhom, final LocalDate complaint_Date) {
        this.complaintId = complaintId;
        this.userId = userId;
        this.userIndex = userIndex;
        this.complaint = complaint;
        this.resId = resId;
        this.evidenceImage = evidenceImage;
        this.status = status;
        this.toWhom = toWhom;
        this.complaint_Date = complaint_Date;
    }

    public int getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(final int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public String getUserIndex() {
        return this.userIndex;
    }

    public void setUserIndex(final String userIndex) {
        this.userIndex = userIndex;
    }

    public String getComplaint() {
        return this.complaint;
    }

    public void setComplaint(final String complaint) {
        this.complaint = complaint;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(final int resId) {
        this.resId = resId;
    }

    public String getEvidenceImage() {
        return this.evidenceImage;
    }

    public void setEvidenceImage(final String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public int getToWhom() {
        return this.toWhom;
    }

    public void setToWhom(final int toWhom) {
        this.toWhom = toWhom;
    }

    public LocalDate getComplaint_Date() {
        return this.complaint_Date;
    }

    public void setComplaint_Date(final LocalDate complaint_Date) {
        this.complaint_Date = complaint_Date;
    }
}
