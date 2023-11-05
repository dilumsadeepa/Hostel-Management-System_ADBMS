package com.fot.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fot.hms.model.RoomEntity;
import com.fot.hms.service.RoomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomEntity>> getAllRooms() {
        List<RoomEntity> rooms = roomService.findAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomNo}")
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable int roomNo) {
        Optional<RoomEntity> room = roomService.findRoomById(roomNo);
        return room.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createRoom")
    public ResponseEntity<RoomEntity> addRoom(@RequestBody RoomEntity roomEntity) {
        RoomEntity newRoom = roomService.saveRoom(roomEntity);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @PutMapping("/editRoom/{roomNo}")
    public ResponseEntity<RoomEntity> updateRoom(@PathVariable int roomNo, @RequestBody RoomEntity roomEntity) {
        if (roomService.findRoomById(roomNo).isPresent()) {
            roomEntity.setRoomNo(roomNo);
            RoomEntity updatedRoom = roomService.saveRoom(roomEntity);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{roomNo}")
    public ResponseEntity<?> deleteRoom(@PathVariable int roomNo) {
        if (roomService.findRoomById(roomNo).isPresent()) {
            roomService.deleteRoom(roomNo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
