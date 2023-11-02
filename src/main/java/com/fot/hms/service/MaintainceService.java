package com.fot.hms.service;

import com.fot.hms.model.MaintainceEntity;
import com.fot.hms.model.ViewMaintainceEntity;
import com.fot.hms.repo.MaintainceRepo;
import com.fot.hms.repo.ViewMaintainceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintainceService {

    private final MaintainceRepo maintainceRepo;
    private final ViewMaintainceRepo viewMaintainceRepo;

    public MaintainceService(MaintainceRepo maintainceRepo, final ViewMaintainceRepo viewMaintainceRepo) {
        this.maintainceRepo = maintainceRepo;
        this.viewMaintainceRepo = viewMaintainceRepo;
    }

    // Create operation
    public MaintainceEntity createMaintaince(MaintainceEntity maintaince) {
        return maintainceRepo.save(maintaince);
    }

    // Read operation
    public List<MaintainceEntity> getAllMaintainces() {
        return maintainceRepo.findAll();
    }

    // Read operation - Fetch data from the MySQL view
    public List<ViewMaintainceEntity> getAllViewMaintainces() {
        return this.viewMaintainceRepo.getAllViewMaintainces();
    }

    public Optional<MaintainceEntity> getMaintainceById(int id) {
        return maintainceRepo.findById(id);
    }

    // Update operation
    public MaintainceEntity updateMaintaince(MaintainceEntity maintaince) {
        return maintainceRepo.save(maintaince);
    }

    // Delete operation
    public void deleteMaintaince(int id) {
        maintainceRepo.deleteById(id);
    }
}
