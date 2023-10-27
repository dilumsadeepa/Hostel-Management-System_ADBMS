package com.adms.hms.Service;

import com.adms.hms.Repo.AssetRepo;
import com.adms.hms.model.AssetsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class AssetService {
    private final AssetRepo assetRepo;

    @Autowired
    public AssetService(AssetRepo assetRepo) {
        this.assetRepo=assetRepo;
    }

    public List<AssetsEntity> findallAssets(){
        return assetRepo.findAll();
    }

    public void deleteAsset(int id){
        assetRepo.deleteById(id);
    }

    public AssetsEntity addasset(AssetsEntity assetsEntity){
        return assetRepo.save(assetsEntity);
    }

}
