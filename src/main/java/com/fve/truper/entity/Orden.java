package com.fve.truper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordenId;
    private Date fecha;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "sucursalId")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<Producto> productos;
}
