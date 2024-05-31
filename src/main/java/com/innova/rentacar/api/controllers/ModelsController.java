package com.innova.rentacar.api.controllers;

import com.innova.rentacar.business.abstracts.ModelService;
import com.innova.rentacar.business.dtos.requests.CreateModelRequest;
import com.innova.rentacar.business.dtos.responses.CreatedModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelsController {
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest model){
        return this.modelService.add(model);
    }
}
