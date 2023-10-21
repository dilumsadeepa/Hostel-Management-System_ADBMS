package com.adms.hms.Repo;

import com.adms.hms.model.AssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepo extends JpaRepository<AssetsEntity, Integer> {

}
