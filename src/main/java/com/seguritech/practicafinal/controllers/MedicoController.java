package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Medico;
import com.seguritech.practicafinal.service.MedicoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Seguritech1
 */
@RestController
public class MedicoController {
    
    private final MedicoService medicoService;
    
     public MedicoController(MedicoService medicoService ) {
        this.medicoService = medicoService;
    }
     
        @GetMapping(value = "/medicos")
        public List<Medico> findAllMedicos(){
        return medicoService.findAll();
        }
       
        @GetMapping("/medicos/{medico_id}")
        public ResponseEntity<Medico> getMedico(@PathVariable("medico_id") Long id) {
        Medico medico = medicoService.findOne(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }
        
        @PostMapping("/medicos")
        public ResponseEntity<Medico> create(@RequestBody Medico medico) throws URISyntaxException {
        if (medico.getMedico_id() != null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.created(new URI("/medico/" + medico.getMedico_id())).body(medico);
    }
        
        @GetMapping(value = "/medicos", params = {"especialidad"})
        public List<Medico> listAll(int especialidad) {
        List<Medico> medicos = medicoService.findByEspecialidad(especialidad);
        return medicos;
    }
        
        @PutMapping("/medicos")
        public ResponseEntity<Medico> update(@RequestBody Medico medico) throws Exception {
        if (medico.getMedico_id() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }
        
    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Medico> deleteMedico(@PathVariable("id") Long id) {
        medicoService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
