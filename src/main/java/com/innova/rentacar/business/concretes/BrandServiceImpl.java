package com.innova.rentacar.business.concretes;

import com.innova.rentacar.business.abstracts.BrandService;
import com.innova.rentacar.business.dtos.requests.CreateBrandRequest;
import com.innova.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.innova.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.innova.rentacar.business.dtos.responses.GetAllBrandResponse;
import com.innova.rentacar.business.dtos.responses.GetByIdBrandResponse;
import com.innova.rentacar.business.dtos.responses.UpdatedBrandResponse;
import com.innova.rentacar.business.rules.BrandBusinessRules;
import com.innova.rentacar.entities.Brand;
import com.innova.rentacar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {

        brandBusinessRules.checkIfBrandExistsByName(createBrandRequest.getName());

        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setId(createBrandRequest.getId());

        Brand createdBrand = brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse=new CreatedBrandResponse(createdBrand.getId(), createdBrand.getName());

        return createdBrandResponse;
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.checkIfBrandExistsById(updateBrandRequest.getId());

        Brand brand = new Brand();
        brand.setName(updateBrandRequest.getName());
        brand.setId(updateBrandRequest.getId());

        Brand updatedBrand = brandRepository.save(brand);

        UpdatedBrandResponse updatedBrandResponse=new UpdatedBrandResponse(updatedBrand.getId(), updatedBrand.getName());

        return updatedBrandResponse;
    }

    @Override
    public void delete(int id) {
        brandBusinessRules.checkIfBrandExistsById(id);
        brandRepository.deleteById(id);
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> response = new ArrayList<>();

        for (Brand brand:brands) {
            GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();
            getAllBrandResponse.setId(brand.getId());
            getAllBrandResponse.setName(brand.getName());

            response.add(getAllBrandResponse);
        }

        return response;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand =  brandBusinessRules.checkIfBrandExistsById(id);

        GetByIdBrandResponse getByIdBrandResponse = new GetByIdBrandResponse();
        getByIdBrandResponse.setId(brand.getId());
        getByIdBrandResponse.setName(brand.getName());

        return getByIdBrandResponse;
    }
}

