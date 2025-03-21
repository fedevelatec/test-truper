package com.fve.truper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productoId;
    private String codigo;
    private String descripcion;
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "ordenId")
    private Orden orden;
}
