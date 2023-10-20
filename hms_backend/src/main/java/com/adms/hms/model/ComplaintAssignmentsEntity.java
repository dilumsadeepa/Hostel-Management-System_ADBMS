package com.adms.hms.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "complaint_assignments", schema = "hms", catalog = "")
public class ComplaintAssignmentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "assignment_id", nullable = false)
    private int assignmentId;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "complaint_id", nullable = false)
    private int complaintId;
    @Basic
    @Column(name = "assigned_date", nullable = false)
    private Timestamp assignedDate;

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public Timestamp getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Timestamp assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplaintAssignmentsEntity that = (ComplaintAssignmentsEntity) o;

        if (assignmentId != that.assignmentId) return false;
        if (roleId != that.roleId) return false;
        if (complaintId != that.complaintId) return false;
        if (assignedDate != null ? !assignedDate.equals(that.assignedDate) : that.assignedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignmentId;
        result = 31 * result + roleId;
        result = 31 * result + complaintId;
        result = 31 * result + (assignedDate != null ? assignedDate.hashCode() : 0);
        return result;
    }
}
