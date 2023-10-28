package com.example.hostel.Repo;

import com.example.hostel.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<ResourceEntity, Integer> {
}
