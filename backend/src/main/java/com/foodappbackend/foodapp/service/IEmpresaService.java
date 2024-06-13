package com.foodappbackend.foodapp.service;

import com.foodappbackend.foodapp.entity.Empresa;

import java.util.List;

public interface IEmpresaService {
    Empresa save(Empresa empresa);

    List<Empresa> findAll();

    Empresa findById(Long id);

    Empresa updateEmpresa(Empresa empresa);

    void deleteById(Long id);
}
