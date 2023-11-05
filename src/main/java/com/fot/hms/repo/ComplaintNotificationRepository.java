package com.fot.hms.repo;

import com.fot.hms.model.ComplaintNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
public interface ComplaintNotificationRepository extends JpaRepository<ComplaintNotificationEntity, Integer> {
}
