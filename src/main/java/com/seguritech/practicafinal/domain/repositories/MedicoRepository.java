/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.practicafinal.domain.repositories;

import com.seguritech.practicafinal.domain.Medico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Seguritech1
 */

public interface MedicoRepository extends JpaRepository<Medico, Long>{

    public List<Medico> findByEspecialidad(int especialidad);
    
}

