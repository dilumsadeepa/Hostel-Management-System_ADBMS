package com.fot.hms.service;

import com.fot.hms.model.ReportStatusEntity;
import com.fot.hms.repo.ReportStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportStatusService {
    @Autowired

    private ReportStatusRepo repository;

    public List<ReportStatusEntity> GetComplaintMaintenance(Date startDate, Date endDate) {
        return repository.GetComplaintMaintenance(startDate, endDate);
    }
}
