package com.fot.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room", schema = "hms", catalog = "")
public class RoomEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_id")
    private int roomId;


    @Basic
    @Column(name = "room_no", nullable = false)
    private int roomNo;

    @Basic
    @Column(name = "hostel_no", nullable = false)
    private int hostelNo;

    @Basic
    @Column(name = "floor_no", nullable = false)
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
