package com.innova.rentacar.business.abstracts;

import com.innova.rentacar.business.dtos.requests.CreateBrandRequest;
import com.innova.rentacar.business.dtos.requests.CreateModelRequest;
import com.innova.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.innova.rentacar.business.dtos.responses.*;
import com.innova.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);
    void  delete(int id);
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);
}

