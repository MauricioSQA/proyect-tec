package com.foodappbackend.foodapp.security.loader;

import com.foodappbackend.foodapp.entity.Rol;
import com.foodappbackend.foodapp.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Autowired
    private RoleRepository rolRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            cargarRolesPorDefecto();
        };
    }

    private void cargarRolesPorDefecto() {
        if (!rolRepository.existsByNombre("ROLE_USER")) {
            Rol userRol = new Rol();
            userRol.setNombre("ROLE_USER");
            rolRepository.save(userRol);
        }

        if (!rolRepository.existsByNombre("ROLE_ADMIN")) {
            Rol adminRol = new Rol();
            adminRol.setNombre("ROLE_ADMIN");
            rolRepository.save(adminRol);
        }
    }

}
