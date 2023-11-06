package com.fot.hms.controller;

import com.fot.hms.model.ReportStatusEntity;
import com.fot.hms.service.ReportStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/complaint-status")
public class ReportStatusController {

    @Autowired

    private ReportStatusService complaintDataService;

    @GetMapping("report-status")
    public List<ReportStatusEntity> getComplaintDataBetweenDates(
            @RequestParam(name = "startDate") Date startDate,
            @RequestParam(name = "endDate") Date endDate) {
        return complaintDataService.GetComplaintMaintenance(startDate, endDate);
    }
}
