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
    public ResponseEntity<RoomEntity> getRoomByRoomNo(@PathVariable int roomNo) {
        RoomEntity room = roomService.findByRoomNo(roomNo);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createRoom")
    public ResponseEntity<RoomEntity> createRoom(@RequestBody RoomEntity room) {
        RoomEntity savedRoom = roomService.saveRoom(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @PutMapping("/editRoom/{roomNo}")
    public ResponseEntity<RoomEntity> updateRoom(@PathVariable int roomNo, @RequestBody RoomEntity updatedRoom) {
        RoomEntity updatedEntity = roomService.updateRoom(roomNo, updatedRoom);
        if (updatedEntity != null) {
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{roomNo}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomNo) {
        roomService.deleteRoom(roomNo);
        return ResponseEntity.noContent().build();
    }

}
