package com.fot.hms.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@jakarta.persistence.Table(name = "maintaince", schema = "hms", catalog = "")
public class MaintainceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "maintenance_id", nullable = false)
    private int maintenanceId;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    @Basic
    @Column(name = "complaint_id", nullable = false)
    private int complaintId;

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    @Basic
    @Column(name = "res_id", nullable = false)
    private int resId;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Basic
    @Column(name = "handler", nullable = false, length = 255)
    private String handler;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "inspection_note", nullable = false, length = -1)
    private String inspectionNote;

    public String getInspectionNote() {
        return inspectionNote;
    }

    public void setInspectionNote(String inspectionNote) {
        this.inspectionNote = inspectionNote;
    }

    @Basic
    @Column(name = "solution", nullable = false, length = -1)
    private String solution;

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Basic
    @Column(name = "evidence_image", nullable = true, length = 255)
    private String evidenceImage;

    public String getEvidenceImage() {
        return evidenceImage;
    }

    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaintainceEntity that = (MaintainceEntity) o;

        if (maintenanceId != that.maintenanceId) return false;
        if (complaintId != that.complaintId) return false;
        if (resId != that.resId) return false;
        if (handler != null ? !handler.equals(that.handler) : that.handler != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (inspectionNote != null ? !inspectionNote.equals(that.inspectionNote) : that.inspectionNote != null)
            return false;
        if (solution != null ? !solution.equals(that.solution) : that.solution != null) return false;
        if (evidenceImage != null ? !evidenceImage.equals(that.evidenceImage) : that.evidenceImage != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maintenanceId;
        result = 31 * result + complaintId;
        result = 31 * result + resId;
        result = 31 * result + (handler != null ? handler.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (inspectionNote != null ? inspectionNote.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (evidenceImage != null ? evidenceImage.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
