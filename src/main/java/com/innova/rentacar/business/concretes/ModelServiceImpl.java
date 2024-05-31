package com.innova.rentacar.business.concretes;

import com.innova.rentacar.business.abstracts.ModelService;
import com.innova.rentacar.business.dtos.requests.CreateModelRequest;
import com.innova.rentacar.business.dtos.responses.CreatedModelResponse;
import com.innova.rentacar.business.rules.ModelBusinessRules;
import com.innova.rentacar.entities.Brand;
import com.innova.rentacar.entities.Model;
import com.innova.rentacar.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {

        modelBusinessRules.checkIfModelExists(createModelRequest.getName());

        Model model = new Model();
        model.setName(createModelRequest.getName());
        model.setId(createModelRequest.getId());

        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());

        model.setBrand(brand);


        Model createdModel = modelRepository.save(model);

        CreatedModelResponse createdModelResponse
                = new CreatedModelResponse(createdModel.getId(), createdModel.getBrand().getId(), createdModel.getName());

        return createdModelResponse;
    }
}

//Country->countries->id,name
//City->countryId