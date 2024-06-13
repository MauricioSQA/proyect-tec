package com.foodappbackend.foodapp.repository;

import com.foodappbackend.foodapp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto>findByEmpresaId(Long id);
}
