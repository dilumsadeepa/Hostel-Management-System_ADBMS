package com.adms.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hostels", schema = "hms", catalog = "")
public class HostelsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "hostel_name", nullable = false, length = 255)
    private String hostelName;
    @Basic
    @Column(name = "hostel_id", nullable = false, length = 50)
    private String hostelId;
    @Basic
    @Column(name = "warden_id", nullable = false)
    private int wardenId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getHostelId() {
        return hostelId;
    }

    public void setHostelId(String hostelId) {
        this.hostelId = hostelId;
    }

    public int getWardenId() {
        return wardenId;
    }

    public void setWardenId(int wardenId) {
        this.wardenId = wardenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostelsEntity that = (HostelsEntity) o;

        if (id != that.id) return false;
        if (wardenId != that.wardenId) return false;
        if (hostelName != null ? !hostelName.equals(that.hostelName) : that.hostelName != null) return false;
        if (hostelId != null ? !hostelId.equals(that.hostelId) : that.hostelId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hostelName != null ? hostelName.hashCode() : 0);
        result = 31 * result + (hostelId != null ? hostelId.hashCode() : 0);
        result = 31 * result + wardenId;
        return result;
    }
}
