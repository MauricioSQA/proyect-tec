package com.foodappbackend.foodapp.service.implementation;

import com.foodappbackend.foodapp.entity.Empresa;
import com.foodappbackend.foodapp.repository.EmpresaRepository;
import com.foodappbackend.foodapp.service.IEmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa findById(Long id) {
        return empresaRepository.findById(id).get();
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        Empresa existingEmpresa = empresaRepository.findById(empresa.getId()).get();
        existingEmpresa.setNombre(empresa.getNombre());
        existingEmpresa.setDireccion(empresa.getDireccion());
        existingEmpresa.setHorario(empresa.getHorario());
       // existingEmpresa.setEmail(empresa.getEmail());
        existingEmpresa.setTelefono(empresa.getTelefono());
        existingEmpresa.setTipo(empresa.getTipo());
        existingEmpresa.setLogo(empresa.getLogo());
        return empresaRepository.save(existingEmpresa);
    }

    @Override
    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }

}
