package com.fot.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.fot.hms.model.RoomEntity;
import com.fot.hms.repo.RoomRepo;
@Service
public class RoomService {
    private final RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public List<RoomEntity> findAllRooms() {
        return roomRepo.findAll();
    }

    public RoomEntity findByRoomNo(int roomNo) {
        return roomRepo.findByRoomNo(roomNo);
    }

    public RoomEntity saveRoom(RoomEntity room) {
        return roomRepo.save(room);
    }

    public RoomEntity updateRoom(int roomNo, RoomEntity updatedRoom) {
        RoomEntity existingRoom = roomRepo.findByRoomNo(roomNo);
        if (existingRoom != null) {
            existingRoom.setHostelNo(updatedRoom.getHostelNo());
            existingRoom.setFloorNo(updatedRoom.getFloorNo());

            return roomRepo.save(existingRoom);
        } else {
            return null; // You may handle this case as needed (e.g., return an error response)
        }
    }

    public void deleteRoom(int roomNo) {
        RoomEntity room = findByRoomNo(roomNo);
        if (room != null) {
            roomRepo.delete(room);
        }
    }


}
