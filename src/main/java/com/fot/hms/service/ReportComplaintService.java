package com.fot.hms.service;


import com.fot.hms.model.ReportComplaintEntity;
import com.fot.hms.repo.ReportComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportComplaintService {

    private final ReportComplaintRepository reportComplaintRepository;

    @Autowired
    public ReportComplaintService(ReportComplaintRepository reportComplaintRepository) {
        this.reportComplaintRepository = reportComplaintRepository;
    }

    public List<ReportComplaintEntity> generateComplaintReport(String startComplaintDate, String endComplaintDate) {
        return reportComplaintRepository.generateComplaintReport(startComplaintDate, endComplaintDate);
    }
}
