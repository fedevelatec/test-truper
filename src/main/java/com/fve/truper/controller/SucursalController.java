package com.fve.truper.controller;

import com.fve.truper.entity.Sucursal;
import com.fve.truper.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sucrusal")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping("/alta")
    public ResponseEntity<Sucursal> save(@RequestBody Sucursal sucursal) {
        final Sucursal newSucursal = sucursalService.save(sucursal);
        return ResponseEntity.ok(newSucursal);
    }
}
