package com.adms.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms", schema = "hms", catalog = "")
public class RoomsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "room_num", nullable = false, length = 12)
    private String roomNum;
    @Basic
    @Column(name = "hostel_id", nullable = false)
    private int hostelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (id != that.id) return false;
        if (hostelId != that.hostelId) return false;
        if (roomNum != null ? !roomNum.equals(that.roomNum) : that.roomNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomNum != null ? roomNum.hashCode() : 0);
        result = 31 * result + hostelId;
        return result;
    }
}
