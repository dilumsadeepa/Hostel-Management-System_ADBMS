package com.fot.hms.controller;

import com.fot.hms.model.ReportStatusEntity;
import com.fot.hms.service.ReportStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/complaint-status")
public class ReportStatusController {


    private final ReportStatusService complaintDataService;
    @Autowired
public ReportStatusController(ReportStatusService complaintDataService){
        this.complaintDataService=complaintDataService;
    }


    @PostMapping("/report-status")
    public List<ReportStatusEntity> GetComplaintMaintenance(@RequestBody Map<String, Object> requestData){
        String startDate = (String) requestData.get("startDate");
        String endDate = (String) requestData.get("endDate");
        return ReportStatusService.GetComplaintMaintenance(startDate, endDate);

    }


}
