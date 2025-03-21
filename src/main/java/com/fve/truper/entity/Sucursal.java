package com.fve.truper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sucursalId;
    private String nombre;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Orden> ordenes;
}
