package com.seguritech.practicafinal.controllers;

import com.seguritech.practicafinal.domain.Paciente;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.seguritech.practicafinal.service.PacienteService;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Seguritech1
 */
@RestController
public class PacienteController {

//    private final PersonaRepository personaRepository;
//    private final MedicoRepository medicoRepository;
    
    private final PacienteService pacienteService;
    
    
    public PacienteController(PacienteService pacienteService ) {
        this.pacienteService = pacienteService;
    }
    
    @GetMapping(value = "/pacientes")
    public List<Paciente> findAllPacientes(){
        List<Paciente> usuarios = pacienteService.findAll();
        return usuarios;
    } 

    @GetMapping("/pacientes/{paciente_id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("paciente_id") Long id) {
        Paciente paciente = pacienteService.findOne(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }
    
    @PostMapping("/pacientes")
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) throws URISyntaxException {
        if (paciente.getPaciente_id() != null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.created(new URI("/pacientes/" + paciente.getPaciente_id())).body(paciente);
    }

    @GetMapping(value = "/pacientes", params = {"obra"})
    public List<Paciente> listAll(int obra) {
        List<Paciente> paciente = pacienteService.findByObra(obra);
        return paciente;
    }
    
    
    @PutMapping("/pacientes")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) throws Exception {
        if (paciente.getPaciente_id() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }
    
    
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable("id") Long id) {
        pacienteService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
