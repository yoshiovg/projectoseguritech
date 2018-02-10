package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.domain.repositories.MedicoRepository;
import com.seguritech.practicafinal.service.MedicoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Seguritech1
 */
@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;
    
    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    
    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();    
    }

    @Override
    public Medico findOne(Long id) {
        return medicoRepository.findOne(id);
    }

    @Override
    public List<Medico> findByEspecialidad(int especialidad) {
        return medicoRepository.findByEspecialidad(especialidad);
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.delete(id);
    }
    
}
