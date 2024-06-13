package com.foodappbackend.foodapp.security.services;

import com.foodappbackend.foodapp.entity.Rol;
import com.foodappbackend.foodapp.entity.Usuario;
import com.foodappbackend.foodapp.security.repository.RoleRepository;
import com.foodappbackend.foodapp.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario buscarPorNombre(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setUsername(usuario.getUsername());
        usuario.setRoles(usuario.getRoles());
        usuario.setPassword(usuario.getPassword());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        for (Rol rol : usuario.getRoles()) {
            rol.getUsuarios().add(usuarioGuardado);
        }

        return usuarioGuardado;
    }

}
