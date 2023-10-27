package com.adms.hms.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "complains", schema = "hms", catalog = "")
public class ComplainsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "complain_id", nullable = false)
    private int complainId;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "room_id", nullable = false)
    private int roomId;
    @Basic
    @Column(name = "asset_id", nullable = false)
    private int assetId;
    @Basic
    @Column(name = "evidence_image", nullable = true, length = 255)
    private String evidenceImage;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "status", nullable = false)
    private Object status;

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainsEntity that = (ComplainsEntity) o;

        if (complainId != that.complainId) return false;
        if (roomId != that.roomId) return false;
        if (assetId != that.assetId) return false;
        if (userId != that.userId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (evidenceImage != null ? !evidenceImage.equals(that.evidenceImage) : that.evidenceImage != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = complainId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + roomId;
        result = 31 * result + assetId;
        result = 31 * result + (evidenceImage != null ? evidenceImage.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
