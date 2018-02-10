package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Paciente;
import java.util.List;

/**
 *
 * @author Seguritech1
 */
public interface PacienteService {

    List<Paciente> findAll();

    Paciente findOne(Long id);

    List<Paciente> findByObra(int obra);

    void save(Paciente paciente);

    void delete(Long id);
}
