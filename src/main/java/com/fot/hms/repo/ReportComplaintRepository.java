package com.fot.hms.repo;

import com.fot.hms.model.ReportComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportComplaintRepository extends JpaRepository<ReportComplaintEntity, Long> {

    @Query(value = "CALL GenerateComplaintReport(:startComplaintDate, :endComplaintDate)", nativeQuery = true)
    List<ReportComplaintEntity> generateComplaintReport(
            @Param("startComplaintDate") String startComplaintDate,
            @Param("endComplaintDate") String endComplaintDate
    );
}


