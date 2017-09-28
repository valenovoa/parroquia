
package com.parroquia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "persona")
@XmlRootElement
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "carnet")
    private String carnet;
    
    @Column(name = "curso_actual")
    private int cursoActual;
    
    @Column(name = "dui")
    private String dui;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getCursoActual() {
        return cursoActual;
    }

    public void setCursoActual(int cursoActual) {
        this.cursoActual = cursoActual;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + '}';
    }
    
    

    
    
}
