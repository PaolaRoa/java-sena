package com.sena.inventory.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/brands")
public class BrandController {

    private final BrandService brandService;
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    @PutMapping
    public Brand editBrand(@RequestBody Brand brand){
        return brandService.editBrand(brand);
    }
}
