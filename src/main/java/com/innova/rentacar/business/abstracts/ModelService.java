package com.innova.rentacar.business.abstracts;

import com.innova.rentacar.business.dtos.requests.CreateModelRequest;
import com.innova.rentacar.business.dtos.responses.CreatedModelResponse;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
}
