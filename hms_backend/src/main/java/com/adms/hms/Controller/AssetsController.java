package com.adms.hms.Controller;

import com.adms.hms.Service.AssetService;
import com.adms.hms.model.AssetsEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    private final AssetService assetService;


    public AssetsController(AssetService assetService) {
        this.assetService = assetService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<AssetsEntity>> getAllEmloyee (){
        List<AssetsEntity> assets = assetService.findallAssets();
        return  new ResponseEntity<>(assets, HttpStatus.OK);
    }
}
