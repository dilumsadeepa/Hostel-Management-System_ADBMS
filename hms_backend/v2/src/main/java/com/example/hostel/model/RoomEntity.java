package com.example.hostel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Room", schema = "hms", catalog = "")
@IdClass(RoomEntityPK.class)
public class RoomEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_no", nullable = false)
    private int roomNo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hostel_no", nullable = false)
    private int hostelNo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "floor_no", nullable = false)
    private int floorNo;
    @ManyToOne
    @JoinColumn(name = "room_no", referencedColumnName = "room_no", nullable = false)
    private ResourceEntity resourceByRoomNo;

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

    public ResourceEntity getResourceByRoomNo() {
        return resourceByRoomNo;
    }

    public void setResourceByRoomNo(ResourceEntity resourceByRoomNo) {
        this.resourceByRoomNo = resourceByRoomNo;
    }
}
