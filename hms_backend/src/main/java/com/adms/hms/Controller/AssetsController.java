package com.adms.hms.Controller;
import com.adms.hms.Service.AssetService;
import com.adms.hms.model.AssetsEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    private final AssetService assetService;

    public AssetsController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssetsEntity>> getAllAssets (){
        List<AssetsEntity> assets = assetService.findallAssets();
        return  new ResponseEntity<>(assets, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AssetsEntity> addAssets(@RequestBody AssetsEntity assetsEntity){
        AssetsEntity newAsset = assetService.addasset(assetsEntity);
        return new ResponseEntity<>(newAsset,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AssetsEntity> updateAssets(@RequestBody AssetsEntity assetsEntity){
        AssetsEntity updateAsset = assetService.addasset(assetsEntity);
        return new ResponseEntity<>(updateAsset,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssets(@PathVariable("id") int id){
        assetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
