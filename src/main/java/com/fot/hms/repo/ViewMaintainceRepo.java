package com.fot.hms.repo;

import com.fot.hms.model.ViewMaintainceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewMaintainceRepo extends JpaRepository<ViewMaintainceEntity, Integer>{
    @Query(value = "SELECT * FROM ViewMaintaince", nativeQuery = true)
    List<ViewMaintainceEntity> getAllViewMaintainces();
}
