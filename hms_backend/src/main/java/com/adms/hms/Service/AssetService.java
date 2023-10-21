package com.adms.hms.Service;

import com.adms.hms.Repo.AssetRepo;
import com.adms.hms.model.AssetsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
