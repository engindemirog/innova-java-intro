package com.innova.rentacar.repositories;

import com.innova.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Optional<Brand> findByNameIgnoreCase(String name);
}