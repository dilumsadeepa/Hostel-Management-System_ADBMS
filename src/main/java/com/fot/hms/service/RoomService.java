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

    public Optional<RoomEntity> findRoomById(int roomNo) {
        return roomRepo.findById(roomNo);
    }

    public RoomEntity saveRoom(RoomEntity roomEntity) {
        return roomRepo.save(roomEntity);
    }

    public void deleteRoom(int roomNo) {
        roomRepo.deleteById(roomNo);
    }


}
