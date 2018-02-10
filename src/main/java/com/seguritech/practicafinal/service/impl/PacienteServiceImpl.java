package com.seguritech.practicafinal.service.impl;

import com.seguritech.practicafinal.domain.Paciente;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seguritech.practicafinal.domain.repositories.PacienteRepository;
import com.seguritech.practicafinal.service.PacienteService;

/**
 *
 * @author Seguritech1
 */
@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findOne(Long id) {
        return pacienteRepository.findOne(id);
    }

    @Override
    public List<Paciente> findByObra(int obra) {
        return pacienteRepository.findByObra(obra);
    }

    @Override
    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.delete(id);
    }

}
