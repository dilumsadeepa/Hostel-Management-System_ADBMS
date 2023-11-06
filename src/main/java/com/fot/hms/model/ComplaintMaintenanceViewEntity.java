package com.fot.hms.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "complaint_maintenance_view", schema = "hms", catalog = "")
public class ComplaintMaintenanceViewEntity {
    @Id
    @Column(name = "complaint_id")
    private int complaintId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "user_index")
    private String userIndex;
    @Basic
    @Column(name = "complaint")
    private String complaint;
    @Basic
    @Column(name = "res_id")
    private int resId;
    @Basic
    @Column(name = "complaint_date")
    private Date complaintDate;
    @Basic
    @Column(name = "complaint_evidence_image")
    private String complaintEvidenceImage;
    @Basic
    @Column(name = "complaint_status")
    private String complaintStatus;
    @Basic
    @Column(name = "maintenance_id")
    private int maintenanceId;
    @Basic
    @Column(name = "maintenance_handler")
    private String maintenanceHandler;
    @Basic
    @Column(name = "maintenance_status")
    private String maintenanceStatus;
    @Basic
    @Column(name = "maintenance_inspection_note")
    private String maintenanceInspectionNote;
    @Basic
    @Column(name = "maintenance_solution")
    private String maintenanceSolution;
    @Basic
    @Column(name = "maintenance_evidence_image")
    private String maintenanceEvidenceImage;
    @Basic
    @Column(name = "maintenance_date")
    private Timestamp maintenanceDate;

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintEvidenceImage() {
        return complaintEvidenceImage;
    }

    public void setComplaintEvidenceImage(String complaintEvidenceImage) {
        this.complaintEvidenceImage = complaintEvidenceImage;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getMaintenanceHandler() {
        return maintenanceHandler;
    }

    public void setMaintenanceHandler(String maintenanceHandler) {
        this.maintenanceHandler = maintenanceHandler;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getMaintenanceInspectionNote() {
        return maintenanceInspectionNote;
    }

    public void setMaintenanceInspectionNote(String maintenanceInspectionNote) {
        this.maintenanceInspectionNote = maintenanceInspectionNote;
    }

    public String getMaintenanceSolution() {
        return maintenanceSolution;
    }

    public void setMaintenanceSolution(String maintenanceSolution) {
        this.maintenanceSolution = maintenanceSolution;
    }

    public String getMaintenanceEvidenceImage() {
        return maintenanceEvidenceImage;
    }

    public void setMaintenanceEvidenceImage(String maintenanceEvidenceImage) {
        this.maintenanceEvidenceImage = maintenanceEvidenceImage;
    }

    public Timestamp getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Timestamp maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplaintMaintenanceViewEntity that = (ComplaintMaintenanceViewEntity) o;

        if (complaintId != that.complaintId) return false;
        if (userId != that.userId) return false;
        if (resId != that.resId) return false;
        if (maintenanceId != that.maintenanceId) return false;
        if (userIndex != null ? !userIndex.equals(that.userIndex) : that.userIndex != null) return false;
        if (complaint != null ? !complaint.equals(that.complaint) : that.complaint != null) return false;
        if (complaintDate != null ? !complaintDate.equals(that.complaintDate) : that.complaintDate != null)
            return false;
        if (complaintEvidenceImage != null ? !complaintEvidenceImage.equals(that.complaintEvidenceImage) : that.complaintEvidenceImage != null)
            return false;
        if (complaintStatus != null ? !complaintStatus.equals(that.complaintStatus) : that.complaintStatus != null)
            return false;
        if (maintenanceHandler != null ? !maintenanceHandler.equals(that.maintenanceHandler) : that.maintenanceHandler != null)
            return false;
        if (maintenanceStatus != null ? !maintenanceStatus.equals(that.maintenanceStatus) : that.maintenanceStatus != null)
            return false;
        if (maintenanceInspectionNote != null ? !maintenanceInspectionNote.equals(that.maintenanceInspectionNote) : that.maintenanceInspectionNote != null)
            return false;
        if (maintenanceSolution != null ? !maintenanceSolution.equals(that.maintenanceSolution) : that.maintenanceSolution != null)
            return false;
        if (maintenanceEvidenceImage != null ? !maintenanceEvidenceImage.equals(that.maintenanceEvidenceImage) : that.maintenanceEvidenceImage != null)
            return false;
        if (maintenanceDate != null ? !maintenanceDate.equals(that.maintenanceDate) : that.maintenanceDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = complaintId;
        result = 31 * result + userId;
        result = 31 * result + (userIndex != null ? userIndex.hashCode() : 0);
        result = 31 * result + (complaint != null ? complaint.hashCode() : 0);
        result = 31 * result + resId;
        result = 31 * result + (complaintDate != null ? complaintDate.hashCode() : 0);
        result = 31 * result + (complaintEvidenceImage != null ? complaintEvidenceImage.hashCode() : 0);
        result = 31 * result + (complaintStatus != null ? complaintStatus.hashCode() : 0);
        result = 31 * result + maintenanceId;
        result = 31 * result + (maintenanceHandler != null ? maintenanceHandler.hashCode() : 0);
        result = 31 * result + (maintenanceStatus != null ? maintenanceStatus.hashCode() : 0);
        result = 31 * result + (maintenanceInspectionNote != null ? maintenanceInspectionNote.hashCode() : 0);
        result = 31 * result + (maintenanceSolution != null ? maintenanceSolution.hashCode() : 0);
        result = 31 * result + (maintenanceEvidenceImage != null ? maintenanceEvidenceImage.hashCode() : 0);
        result = 31 * result + (maintenanceDate != null ? maintenanceDate.hashCode() : 0);
        return result;
    }
}
