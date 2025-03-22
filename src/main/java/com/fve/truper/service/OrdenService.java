package com.fve.truper.service;

import com.fve.truper.entity.Orden;

public interface OrdenService {

    public Orden save(final Orden orden);

    public Orden findById(Long id);
}
