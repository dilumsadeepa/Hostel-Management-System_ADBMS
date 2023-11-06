package com.fot.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fot.hms.model.ComplaintMaintenanceViewEntity;

public interface ComplaintMaintenanceViewRepository  extends JpaRepository<ComplaintMaintenanceViewEntity, Integer> {
    ComplaintMaintenanceViewEntity findByComplaintId(int complaintId);
}
