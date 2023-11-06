package com.fot.hms.service;

import com.fot.hms.model.ReportStatusEntity;
import com.fot.hms.repo.ReportStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReportStatusService {
    @Autowired

    private static ReportStatusRepo repository;


    @Autowired
    public void ReportStatusRepo(ReportStatusRepo repository) {
        this.repository = repository;
    }


    public static List<ReportStatusEntity> GetComplaintMaintenance(String startDate, String endDate) {

        return repository.GetComplaintMaintenance(startDate, endDate);
    }
}
