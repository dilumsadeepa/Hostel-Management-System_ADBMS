package com.fot.hms.repo;

import com.fot.hms.model.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComplaintRepo extends JpaRepository<ComplaintEntity, Integer>{

    @Modifying
    @Query("DELETE FROM ComplaintEntity c WHERE c.complaintId = :complaintId")
    void deleteComplaintById(@Param("complaintId") int complaintId);
    Optional<ComplaintEntity> findByComplaintId(int complaintId); // Change the method name here


}
