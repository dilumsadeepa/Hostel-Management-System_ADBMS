package com.example.hostel.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class RoomEntityPK implements Serializable {
    @Column(name = "room_no", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomNo;
    @Column(name = "hostel_no", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelNo;
    @Column(name = "floor_no", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int floorNo;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getHostelNo() {
        return hostelNo;
    }

    public void setHostelNo(int hostelNo) {
        this.hostelNo = hostelNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntityPK that = (RoomEntityPK) o;

        if (roomNo != that.roomNo) return false;
        if (hostelNo != that.hostelNo) return false;
        if (floorNo != that.floorNo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomNo;
        result = 31 * result + hostelNo;
        result = 31 * result + floorNo;
        return result;
    }
}
