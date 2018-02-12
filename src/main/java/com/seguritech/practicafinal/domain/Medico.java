package com.seguritech.practicafinal.domain;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author Seguritech1
 */
@Entity
@Table(name = "medicos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="medico_id")
    private Long medico_id;
    private String nombre;

    @Column(name="especialidad_id")
    private int especialidad;

    private String estado;

    public Long getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Long medico_id) {
        this.medico_id = medico_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
   

}
