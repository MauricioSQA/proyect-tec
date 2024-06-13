package com.foodappbackend.foodapp.security.repository;

import com.foodappbackend.foodapp.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
