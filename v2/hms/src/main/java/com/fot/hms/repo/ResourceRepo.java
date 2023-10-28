package com.fot.hms.repo;

import com.fot.hms.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<ResourceEntity, Integer> {
}
