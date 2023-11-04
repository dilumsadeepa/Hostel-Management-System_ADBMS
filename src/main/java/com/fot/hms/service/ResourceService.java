package com.fot.hms.service;

import com.fot.hms.model.ResourceEntity;
import com.fot.hms.repo.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepo resourceRepo;

    @Autowired
    public ResourceService(ResourceRepo resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    public List<ResourceEntity> findallAssets(){
        return resourceRepo.findAll();
    }


    public ResourceEntity addresource(ResourceEntity resourceEntity){
        return resourceRepo.save(resourceEntity);
    }

    public ResourceEntity findResourceById(int resId) {
        return resourceRepo.findByResId(resId);
    }


    public void deleteResourceEntityById(int resourceId) {
        resourceRepo.deleteById(resourceId);
    }

}
