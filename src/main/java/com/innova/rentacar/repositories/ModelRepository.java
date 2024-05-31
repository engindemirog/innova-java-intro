package com.innova.rentacar.repositories;

import com.innova.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    Optional<Model> findByNameIgnoreCase(String name);
}
