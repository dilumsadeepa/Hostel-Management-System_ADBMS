package com.fot.hms.controller;

import com.fot.hms.model.RolesEntity;
import com.fot.hms.service.RolesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping
    public RolesEntity createRole(@RequestBody RolesEntity role) {
        return rolesService.createRole(role);
    }

    @GetMapping
    public List<RolesEntity> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RolesEntity getRoleById(@PathVariable int id) {
        return rolesService.getRoleById(id).orElse(null); // handle if the role is not found
    }

    @PutMapping
    public RolesEntity updateRole(@RequestBody RolesEntity role) {
        return rolesService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id) {
        rolesService.deleteRole(id);
    }
}
