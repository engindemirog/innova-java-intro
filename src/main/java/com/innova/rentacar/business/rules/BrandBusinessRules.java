package com.innova.rentacar.business.rules;

import com.innova.rentacar.entities.Brand;
import com.innova.rentacar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandExistsByName(String brandName){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);

        if(brand.isPresent()){
            throw new RuntimeException("Brand already exists");
        }
    }

    public Brand checkIfBrandExistsById(int id){
        Optional<Brand> brand = brandRepository.findById(id);

        if(!brand.isPresent()){
            throw new RuntimeException("Brand does not exists");
        }

        return brand.get();

    }
}
