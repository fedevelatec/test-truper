package com.fve.truper.controller;

import com.fve.truper.entity.Orden;
import com.fve.truper.entity.Producto;
import com.fve.truper.repository.OrdenRepository;
import com.fve.truper.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final OrdenRepository ordenRepository;
    private final ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @PutMapping//("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
//        @PathVariable Integer ordenId) {
        //Orden orden = ordenRepository.findById(pr)
        Producto updateProd = productoRepository.save(producto);
        return ResponseEntity.ok(updateProd);
            //Producto productoFound = productoRepository.getByProductoId(producto.getProductoId());
    }
}
