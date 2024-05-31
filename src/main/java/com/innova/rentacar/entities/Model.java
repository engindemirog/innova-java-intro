package com.innova.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
}
