package com.fot.hms.controller;

import com.fot.hms.model.MaintainceEntity;
import com.fot.hms.model.ViewMaintainceEntity;
import com.fot.hms.service.MaintainceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintaince")
public class MaintainceController {

    private final MaintainceService maintainceService;

    public MaintainceController(MaintainceService maintainceService) {
        this.maintainceService = maintainceService;
    }

    @PostMapping("/create")
    public MaintainceEntity createMaintaince(@RequestBody MaintainceEntity maintaince) {
        return maintainceService.createMaintaince(maintaince);
    }

    @GetMapping("/all")
    public List<MaintainceEntity> getAllMaintainces() {
        return maintainceService.getAllMaintainces();
    }

    // Get all maintainces from MySQL view
    @GetMapping("/alldata")
    public List<ViewMaintainceEntity> getAllViewMaintainces() {
        return maintainceService.getAllViewMaintainces();
    }

    @GetMapping("/{id}")
    public MaintainceEntity getMaintainceById(@PathVariable int id) {
        return maintainceService.getMaintainceById(id).orElse(null);
    }

    @PutMapping("/update")
    public MaintainceEntity updateMaintaince(@RequestBody MaintainceEntity maintaince) {
        return maintainceService.updateMaintaince(maintaince);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMaintaince(@PathVariable int id) {
        maintainceService.deleteMaintaince(id);
    }
}
