package com.fot.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room", schema = "hms", catalog = "")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "room_no", nullable = false)
    private int roomNo;

    @jakarta.persistence.Column(name = "hostel_no", nullable = false)
    private int hostelNo;

    @jakarta.persistence.Column(name = "floor_no", nullable = false)
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

        RoomEntity that = (RoomEntity) o;

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
