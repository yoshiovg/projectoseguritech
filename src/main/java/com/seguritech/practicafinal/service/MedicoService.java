package com.seguritech.practicafinal.service;

import com.seguritech.practicafinal.domain.Medico;
import java.util.List;

/**
 *
 * @author Seguritech1
 */
public interface MedicoService {

    List<Medico> findAll();

    Medico findOne(Long id);

    List<Medico> findByEspecialidad(int especialidad);

    void save(Medico medico);

    void delete(Long id);
}
