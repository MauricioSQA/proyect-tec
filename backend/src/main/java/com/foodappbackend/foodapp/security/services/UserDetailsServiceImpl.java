package com.foodappbackend.foodapp.security.services;

import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.entity.Usuario;
import com.foodappbackend.foodapp.repository.EmpresaRepository;
import com.foodappbackend.foodapp.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;



    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);
        }
        return new CustomUserDetails(usuario);
    }*/


    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario != null){
            return new CustomUserDetails(usuario);
        }

        Empresa empresa = empresaRepository.findByUsername(username);
        if(empresa != null){
            return new CustomUserDetails(empresa);
        }
    throw new UsernameNotFoundException("Usuario o Empresa no encontrado");
    }
}
