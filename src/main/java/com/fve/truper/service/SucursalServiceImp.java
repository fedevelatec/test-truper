package com.fve.truper.service;

import com.fve.truper.entity.Sucursal;
import com.fve.truper.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SucursalServiceImp implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal save(Sucursal sucursal) {
        Sucursal newSucursal = sucursalRepository.save(sucursal);
        return newSucursal;
    }
}
