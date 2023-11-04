package com.fot.hms.service;

import com.fot.hms.model.RolesEntity;
import com.fot.hms.repo.RolesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepo rolesRepository;

    public RolesService(RolesRepo rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public RolesEntity createRole(RolesEntity role) {
        return rolesRepository.save(role);
    }

    public List<RolesEntity> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Optional<RolesEntity> getRoleById(int id) {
        return rolesRepository.findById(id);
    }

    public RolesEntity updateRole(RolesEntity role) {
        return rolesRepository.save(role);
    }

    public void deleteRole(int id) {
        rolesRepository.deleteById(id);
    }
}
