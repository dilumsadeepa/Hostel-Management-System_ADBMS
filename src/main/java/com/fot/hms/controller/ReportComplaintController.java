package com.fot.hms.controller;

import com.fot.hms.model.ReportComplaintEntity;
import com.fot.hms.service.ReportComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/report-mp")
public class ReportComplaintController {
    private final ReportComplaintService reportComplaintService;

    @Autowired
    public ReportComplaintController(ReportComplaintService reportComplaintService) {
        this.reportComplaintService = reportComplaintService;
    }

    @GetMapping("/generateReportmp")
    public List<ReportComplaintEntity> generateComplaintReport(@RequestBody Map<String, Object> requestData) {
        String startComplaintDate = (String) requestData.get("startComplaintDate");
        String endComplaintDate = (String) requestData.get("endComplaintDate");
        return reportComplaintService.generateComplaintReport(startComplaintDate, endComplaintDate);
    }

}
