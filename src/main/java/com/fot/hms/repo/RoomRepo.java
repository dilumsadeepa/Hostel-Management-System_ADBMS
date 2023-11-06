package com.fot.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fot.hms.model.RoomEntity;
public interface RoomRepo extends JpaRepository<RoomEntity, Integer> {
    RoomEntity findByRoomNo(int roomNo);
}
