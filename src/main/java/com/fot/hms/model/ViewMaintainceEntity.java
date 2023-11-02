package com.fot.hms.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ViewMaintaince", schema = "hms", catalog = "")
public class ViewMaintainceEntity {
    @Id
    @Column(name = "maintenance_id")
    private int maintenanceId;
    @Basic
    @Column(name = "maintaince_complaint_id")
    private int maintainceComplaintId;
    @Basic
    @Column(name = "maintaince_handler")
    private String maintainceHandler;
    @Basic
    @Column(name = "maintaince_status")
    private String maintainceStatus;
    @Basic
    @Column(name = "maintaince_inspection_note")
    private String maintainceInspectionNote;
    @Basic
    @Column(name = "maintaince_solution")
    private String maintainceSolution;
    @Basic
    @Column(name = "maintaince_evidence_image")
    private String maintainceEvidenceImage;
    @Basic
    @Column(name = "maintaince_date")
    private Timestamp maintainceDate;
    @Basic
    @Column(name = "complaint_complaint_id")
    private int complaintComplaintId;
    @Basic
    @Column(name = "complaint_user_id")
    private int complaintUserId;
    @Basic
    @Column(name = "complaint_res_id")
    private int complaintResId;
    @Basic
    @Column(name = "users_id")
    private int usersId;
    @Basic
    @Column(name = "users_username")
    private String usersUsername;
    @Basic
    @Column(name = "users_email")
    private String usersEmail;
    @Basic
    @Column(name = "resource_res_id")
    private int resourceResId;
    @Basic
    @Column(name = "resource_res_name")
    private String resourceResName;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getMaintainceComplaintId() {
        return maintainceComplaintId;
    }

    public void setMaintainceComplaintId(int maintainceComplaintId) {
        this.maintainceComplaintId = maintainceComplaintId;
    }

    public String getMaintainceHandler() {
        return maintainceHandler;
    }

    public void setMaintainceHandler(String maintainceHandler) {
        this.maintainceHandler = maintainceHandler;
    }

    public String getMaintainceStatus() {
        return maintainceStatus;
    }

    public void setMaintainceStatus(String maintainceStatus) {
        this.maintainceStatus = maintainceStatus;
    }

    public String getMaintainceInspectionNote() {
        return maintainceInspectionNote;
    }

    public void setMaintainceInspectionNote(String maintainceInspectionNote) {
        this.maintainceInspectionNote = maintainceInspectionNote;
    }

    public String getMaintainceSolution() {
        return maintainceSolution;
    }

    public void setMaintainceSolution(String maintainceSolution) {
        this.maintainceSolution = maintainceSolution;
    }

    public String getMaintainceEvidenceImage() {
        return maintainceEvidenceImage;
    }

    public void setMaintainceEvidenceImage(String maintainceEvidenceImage) {
        this.maintainceEvidenceImage = maintainceEvidenceImage;
    }

    public Timestamp getMaintainceDate() {
        return maintainceDate;
    }

    public void setMaintainceDate(Timestamp maintainceDate) {
        this.maintainceDate = maintainceDate;
    }

    public int getComplaintComplaintId() {
        return complaintComplaintId;
    }

    public void setComplaintComplaintId(int complaintComplaintId) {
        this.complaintComplaintId = complaintComplaintId;
    }

    public int getComplaintUserId() {
        return complaintUserId;
    }

    public void setComplaintUserId(int complaintUserId) {
        this.complaintUserId = complaintUserId;
    }

    public int getComplaintResId() {
        return complaintResId;
    }

    public void setComplaintResId(int complaintResId) {
        this.complaintResId = complaintResId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUsersUsername() {
        return usersUsername;
    }

    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public int getResourceResId() {
        return resourceResId;
    }

    public void setResourceResId(int resourceResId) {
        this.resourceResId = resourceResId;
    }

    public String getResourceResName() {
        return resourceResName;
    }

    public void setResourceResName(String resourceResName) {
        this.resourceResName = resourceResName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewMaintainceEntity that = (ViewMaintainceEntity) o;

        if (maintenanceId != that.maintenanceId) return false;
        if (maintainceComplaintId != that.maintainceComplaintId) return false;
        if (complaintComplaintId != that.complaintComplaintId) return false;
        if (complaintUserId != that.complaintUserId) return false;
        if (complaintResId != that.complaintResId) return false;
        if (usersId != that.usersId) return false;
        if (resourceResId != that.resourceResId) return false;
        if (maintainceHandler != null ? !maintainceHandler.equals(that.maintainceHandler) : that.maintainceHandler != null)
            return false;
        if (maintainceStatus != null ? !maintainceStatus.equals(that.maintainceStatus) : that.maintainceStatus != null)
            return false;
        if (maintainceInspectionNote != null ? !maintainceInspectionNote.equals(that.maintainceInspectionNote) : that.maintainceInspectionNote != null)
            return false;
        if (maintainceSolution != null ? !maintainceSolution.equals(that.maintainceSolution) : that.maintainceSolution != null)
            return false;
        if (maintainceEvidenceImage != null ? !maintainceEvidenceImage.equals(that.maintainceEvidenceImage) : that.maintainceEvidenceImage != null)
            return false;
        if (maintainceDate != null ? !maintainceDate.equals(that.maintainceDate) : that.maintainceDate != null)
            return false;
        if (usersUsername != null ? !usersUsername.equals(that.usersUsername) : that.usersUsername != null)
            return false;
        if (usersEmail != null ? !usersEmail.equals(that.usersEmail) : that.usersEmail != null) return false;
        if (resourceResName != null ? !resourceResName.equals(that.resourceResName) : that.resourceResName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maintenanceId;
        result = 31 * result + maintainceComplaintId;
        result = 31 * result + (maintainceHandler != null ? maintainceHandler.hashCode() : 0);
        result = 31 * result + (maintainceStatus != null ? maintainceStatus.hashCode() : 0);
        result = 31 * result + (maintainceInspectionNote != null ? maintainceInspectionNote.hashCode() : 0);
        result = 31 * result + (maintainceSolution != null ? maintainceSolution.hashCode() : 0);
        result = 31 * result + (maintainceEvidenceImage != null ? maintainceEvidenceImage.hashCode() : 0);
        result = 31 * result + (maintainceDate != null ? maintainceDate.hashCode() : 0);
        result = 31 * result + complaintComplaintId;
        result = 31 * result + complaintUserId;
        result = 31 * result + complaintResId;
        result = 31 * result + usersId;
        result = 31 * result + (usersUsername != null ? usersUsername.hashCode() : 0);
        result = 31 * result + (usersEmail != null ? usersEmail.hashCode() : 0);
        result = 31 * result + resourceResId;
        result = 31 * result + (resourceResName != null ? resourceResName.hashCode() : 0);
        return result;
    }
}
