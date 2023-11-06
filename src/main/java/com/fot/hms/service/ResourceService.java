package com.fot.hms.service;

import com.fot.hms.model.ResourceEntity;
import com.fot.hms.repo.ResourceRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepo resourceRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ResourceService(ResourceRepo resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    public List<ResourceEntity> findallAssets(){
        return resourceRepo.findAll();
    }

    public void deleteresource(int resId){
        resourceRepo.deleteById(resId);
    }

    public ResourceEntity addresource(ResourceEntity resourceEntity){
        return resourceRepo.save(resourceEntity);
    }

    public ResourceEntity findResourceById(int resId) {
        return resourceRepo.findByResId(resId);
    }

    public List<ResourceEntity> getResourcesInRoom(int roomNumber) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("GetResourcesInRoom");
        storedProcedure.registerStoredProcedureParameter("roomNumber", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("roomNumber", roomNumber);
        storedProcedure.execute();

        List<ResourceEntity> resultList = storedProcedure.getResultList();

        return resultList;
    }

}
