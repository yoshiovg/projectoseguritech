package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Seguritech1
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    public List<Paciente> findByObra(int obra);
    
}
