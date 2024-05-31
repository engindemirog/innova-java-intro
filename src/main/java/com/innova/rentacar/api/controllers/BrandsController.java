package com.innova.rentacar.api.controllers;

import com.innova.rentacar.business.abstracts.BrandService;
import com.innova.rentacar.business.abstracts.ModelService;
import com.innova.rentacar.business.dtos.requests.CreateBrandRequest;
import com.innova.rentacar.business.dtos.requests.CreateModelRequest;
import com.innova.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.innova.rentacar.business.dtos.responses.*;
import com.innova.rentacar.entities.Brand;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest brand){
        return this.brandService.add(brand);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse add(@Valid @RequestBody UpdateBrandRequest brand){
        return this.brandService.update(brand);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id){
        brandService.delete(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdBrandResponse getAll(@PathParam("id") int id){
        return brandService.getById(id);
    }

}

