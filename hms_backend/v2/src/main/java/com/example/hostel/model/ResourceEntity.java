package com.example.hostel.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Resource", schema = "hms", catalog = "")
public class ResourceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "res_id", nullable = false)
    private int resId;
    @Basic
    @Column(name = "room_no", nullable = true)
    private Integer roomNo;
    @Basic
    @Column(name = "res_name", nullable = true, length = 255)
    private String resName;
    @Basic
    @Column(name = "installation_date", nullable = true)
    private Date installationDate;
    @Basic
    @Column(name = "last_maintenance_date", nullable = true)
    private Date lastMaintenanceDate;
    @Basic
    @Column(name = "status", nullable = true, length = 10)
    private String status;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceEntity that = (ResourceEntity) o;

        if (resId != that.resId) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (resName != null ? !resName.equals(that.resName) : that.resName != null) return false;
        if (installationDate != null ? !installationDate.equals(that.installationDate) : that.installationDate != null)
            return false;
        if (lastMaintenanceDate != null ? !lastMaintenanceDate.equals(that.lastMaintenanceDate) : that.lastMaintenanceDate != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resId;
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (resName != null ? resName.hashCode() : 0);
        result = 31 * result + (installationDate != null ? installationDate.hashCode() : 0);
        result = 31 * result + (lastMaintenanceDate != null ? lastMaintenanceDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
