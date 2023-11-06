package com.fot.hms.repo;

import com.fot.hms.model.ReportStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ReportStatusRepo extends JpaRepository<ReportStatusEntity, Long>{

    @Query(value = "CALL GetComplaintMaintenance(:startDate, :endDate)", nativeQuery = true)
    List<ReportStatusEntity> GetComplaintMaintenance(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );


}
