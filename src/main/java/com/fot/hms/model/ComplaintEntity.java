package com.fot.hms.model;
import jakarta.persistence.*;
import java.time.LocalDate; // Import LocalDateTime
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.util.Date;

@Entity
@Table(name = "complaint", schema = "hms", catalog = "")
public class ComplaintEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id", nullable = false)
    private int complaintId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "user_index", nullable = false)
    private String userIndex;

    @Column(name = "complaint", columnDefinition = "TEXT", length = 2000)
    private String complaint;

    @Column(name = "res_id", nullable = false)
    private int resId;

    @Column(name = "complaint_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate complaintDate;

    @Column(name = "evidence_image")
    private String evidenceImage;

    @Column(name = "status")
    private String status;

    @Column(name = "is_deleted" , columnDefinition = "BOOLEAN DEFAULT false")
    private boolean IsDeleted;

    public boolean setIsDeleted() {
        return this.IsDeleted;
    }

    public void setIsDeleted(final boolean isDeleted) {
        this.IsDeleted = isDeleted;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "user_index", referencedColumnName = "index_no", insertable = false, updatable = false)
    private UsersEntity userByIndex;

    @ManyToOne
    @JoinColumn(name = "res_id", referencedColumnName = "res_id", insertable = false, updatable = false)
    private ResourceEntity resource;


    public ComplaintEntity() {

    }

    public ComplaintEntity(int userId, String userIndex, String complaint, int resId, LocalDate complaintDate, String evidenceImage, String status, Boolean IsDeleted, UsersEntity user, UsersEntity userByIndex, ResourceEntity resource) {
        this.userId = userId;
        this.userIndex = userIndex;
        this.complaint = complaint;
        this.resId = resId;
        this.complaintDate = complaintDate;
        this.evidenceImage = evidenceImage;
        this.status = status;
        this.IsDeleted = IsDeleted;
        this.user = user;
        this.userByIndex = userByIndex;
        this.resource = resource;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getEvidenceImage() {
        return evidenceImage;
    }

    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public UsersEntity getUserByIndex() {
        return userByIndex;
    }

    public void setUserByIndex(UsersEntity userByIndex) {
        this.userByIndex = userByIndex;
    }

    public ResourceEntity getResource() {
        return resource;
    }

    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ComplaintEntity{" +
                "complaintId=" + complaintId +
                ", userId=" + userId +
                ", userIndex='" + userIndex + '\'' +
                ", complaint='" + complaint + '\'' +
                ", resId=" + resId +
                ", complaintDate=" + complaintDate +
                ", evidenceImage='" + evidenceImage + '\'' +
                ", status='" + status + '\'' +
                ", IsDeleted=" + IsDeleted  + '\'' +
                ", user=" + user +
                ", userByIndex=" + userByIndex +
                ", resource=" + resource +
                '}';
    }
}
