package com.example.hostel.Controller;


import com.example.hostel.Service.ResourceService;
import com.example.hostel.model.ResourceEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/res")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResourceEntity>> getAllResource (){
        List<ResourceEntity> resource = resourceService.findallAssets();
        return  new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
