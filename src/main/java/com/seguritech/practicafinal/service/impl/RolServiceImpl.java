package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Rol;
import com.seguritech.practicafinal.domain.repositories.RolRepository;
import com.seguritech.practicafinal.service.RolService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Werner
 */
@Service
@Transactional
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findOne(Long id) {
        return rolRepository.findOne(id);
    }

    @Override
    public List<Rol> findByDescripcion(String descripcion) {
        return rolRepository.findByDescripcion(descripcion);
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(Long id) {
        rolRepository.delete(id);
    }

}
