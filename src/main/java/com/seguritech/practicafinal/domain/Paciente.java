package com.seguritech.practicafinal.domain;


import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author Seguritech1
 */
@Entity
@Table(name = "pacientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="paciente_id")
    private Long paciente_id;
    private String dni;
    private String nombre;
    private String e_mail;
    private String telefono;
    
    @Column(name="obra_social_id")
    private int obra;
    
    private String estado;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    public int getObra() {
        return obra;
    }

    public void setObra(int obra) {
        this.obra = obra;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    
}
