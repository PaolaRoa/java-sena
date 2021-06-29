package com.sena.inventory.brand;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    public Brand editBrand(Brand brand) {
        boolean exists = brandRepository.existsById(brand.getId());
        if(exists){
            Brand brandInDB = brandRepository.findById(brand.getId()).get();
            if(brandInDB != null){
                brandInDB.setName(brand.getName());
                return brandRepository.save(brandInDB);
            }
        }
        return null;
    }
}
