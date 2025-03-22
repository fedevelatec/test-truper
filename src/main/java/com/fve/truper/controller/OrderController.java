package com.fve.truper.controller;

import com.fve.truper.aop.LogExecutionTime;
import com.fve.truper.entity.Orden;
import com.fve.truper.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orden")
@RequiredArgsConstructor
public class OrderController {

    private final OrdenService ordenService;

    @PostMapping
    @LogExecutionTime
    public ResponseEntity<Orden> save(@RequestBody Orden orden) {
        final Orden newOrden = ordenService.save(orden);
        return ResponseEntity.ok(newOrden);
    }

    @GetMapping(value = "/{id}")
    @LogExecutionTime
    public ResponseEntity<Orden> findById(@PathVariable("id") Long id) {
        final Orden newOrden = ordenService.findById(id);
        return ResponseEntity.ok(newOrden);
    }
}
