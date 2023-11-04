package com.fot.hms.repo;

import com.fot.hms.model.MaintainceEntity;
import com.fot.hms.model.ViewMaintainceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaintainceRepo extends JpaRepository<MaintainceEntity, Integer> {

}
