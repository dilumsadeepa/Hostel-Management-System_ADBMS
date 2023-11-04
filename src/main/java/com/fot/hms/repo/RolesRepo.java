package com.fot.hms.repo;

import com.fot.hms.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository <RolesEntity, Integer> {
}
