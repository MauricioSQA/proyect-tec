package com.foodappbackend.foodapp.repository;

import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByUsername(String username);

}
