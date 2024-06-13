package com.foodappbackend.foodapp.service;

import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.entity.Producto;


import java.util.List;

public interface IProductoService {

    Producto save(Producto producto);

    List<Producto> findByEmpresaId(Long id);

    List<Producto> findAll();

    Producto findById(Long id);

    Producto updateProducto(Producto producto);

    void deleteById(Long id);

}
