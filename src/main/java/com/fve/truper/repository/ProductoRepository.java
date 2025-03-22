package com.fve.truper.repository;

import com.fve.truper.entity.Orden;
import com.fve.truper.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = """
    select p from Producto p \s
        where p.orden.ordenId = :ordenId \s
    """)
    public List<Producto> findByOrden(Integer ordenId);

    @Query(value = """
    select p from Producto p \s
        where p.orden.ordenId = :ordenId \s
            and p.codigo = :codigo\s
    """)
    public Producto getByCodeAndOrden(String codigo, Integer ordenId );

    Producto getByProductoId(int productoId);
}
