package com.adms.hms.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "maintenance", schema = "hms", catalog = "")
public class MaintenanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "maintenance_id", nullable = false)
    private int maintenanceId;
    @Basic
    @Column(name = "asset_id", nullable = false)
    private int assetId;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @Basic
    @Column(name = "type", nullable = false, length = 255)
    private String type;
    @Basic
    @Column(name = "evidence_image", nullable = true, length = 255)
    private String evidenceImage;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "complaint_id", nullable = true)
    private Integer complaintId;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvidenceImage() {
        return evidenceImage;
    }

    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaintenanceEntity that = (MaintenanceEntity) o;

        if (maintenanceId != that.maintenanceId) return false;
        if (assetId != that.assetId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (evidenceImage != null ? !evidenceImage.equals(that.evidenceImage) : that.evidenceImage != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (complaintId != null ? !complaintId.equals(that.complaintId) : that.complaintId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maintenanceId;
        result = 31 * result + assetId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (evidenceImage != null ? evidenceImage.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (complaintId != null ? complaintId.hashCode() : 0);
        return result;
    }
}
