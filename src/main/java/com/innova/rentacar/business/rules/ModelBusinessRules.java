package com.innova.rentacar.business.rules;

import com.innova.rentacar.entities.Brand;
import com.innova.rentacar.entities.Model;
import com.innova.rentacar.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelExists(String modelName){
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);

        if(model.isPresent()){
            throw new RuntimeException("Model already exists");
        }
    }
}
