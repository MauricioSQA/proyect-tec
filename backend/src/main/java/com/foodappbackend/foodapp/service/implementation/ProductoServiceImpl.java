package com.foodappbackend.foodapp.service.implementation;


import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.entity.Producto;
import com.foodappbackend.foodapp.repository.ProductoRepository;
import com.foodappbackend.foodapp.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findByEmpresaId(Long id) {
        return productoRepository.findByEmpresaId(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public Producto updateProducto(Producto producto) {

        Producto existingProducto = productoRepository.findById(producto.getId()).get();
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setPrecioOriginal(producto.getPrecioOriginal());
        existingProducto.setPrecioOferta(producto.getPrecioOferta());
        existingProducto.setCant_disponible(producto.getCant_disponible());
        return productoRepository.save(existingProducto);
    }

    @Override
    public void deleteById(Long id) {productoRepository.deleteById(id);

    }




}
