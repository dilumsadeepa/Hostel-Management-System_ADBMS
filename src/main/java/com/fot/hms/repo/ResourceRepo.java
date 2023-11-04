package com.fot.hms.repo;

import com.fot.hms.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceRepo extends JpaRepository<ResourceEntity, Integer> {

    @Query("SELECT r FROM ResourceEntity r WHERE r.resId = :resId")
    ResourceEntity findByResId(@Param("resId") int resId);


}
