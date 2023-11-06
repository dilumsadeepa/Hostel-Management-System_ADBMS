package com.fot.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint-status")
public class ReportStatusController {

    @Autowired

    private ComplaintDataService complaintDataService;
}
