
package com.parroquia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "feligres")
public class Feligres implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "nomMama")
    private String nomMama;
    
    @Column(name = "nomPapa")
    private String nomPapa;
    
    @Column(name = "nomMadrina")
    private String nomMadrina;

    @Column(name = "nomPadrino")
    private String nomPadrino;
    
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
   
    @Column(name = "fechaBautizo")
    @Temporal(TemporalType.DATE)
    private Date fechaBautizo;
  
    @Column(name = "lugar")
    private String lugar;
  
    @Column(name = "nomParroco")
    private String nomParroco;
    
    @Column(name="numLibro")
    private int numLibro;
    
     @Column(name="numPagina")
    private int numPagina;
    
     @Column(name = "lugarNacimiento")
     private String lugarNacimiento;

    public Feligres() {
    }

    public Feligres(int codigo) {
        this.codigo = codigo;
    }

    public Feligres(int codigo, String nombres, String apellidos, String nomMama, String nomPapa, Date fechaNacimiento, Date fechaBautizo, String lugar, String nomParroco, int numLibro, int numPagina ) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nomMama = nomMama;
        this.nomPapa = nomPapa;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBautizo = fechaBautizo;
        this.lugar = lugar;
        this.nomParroco = nomParroco;
        this.numLibro=numLibro;
        this.numPagina=numPagina;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNomMama() {
        return nomMama;
    }

    public void setNomMama(String nomMama) {
        this.nomMama = nomMama;
    }

    public String getNomPapa() {
        return nomPapa;
    }

    public void setNomPapa(String nomPapa) {
        this.nomPapa = nomPapa;
    }

    public String getNomMadrina() {
        return nomMadrina;
    }

    public void setNomMadrina(String nomMadrina) {
        this.nomMadrina = nomMadrina;
    }

    public String getNomPadrino() {
        return nomPadrino;
    }

    public void setNomPadrino(String nomPadrino) {
        this.nomPadrino = nomPadrino;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaBautizo() {
        return fechaBautizo;
    }

    public void setFechaBautizo(Date fechaBautizo) {
        this.fechaBautizo = fechaBautizo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNomParroco() {
        return nomParroco;
    }

    public void setNomParroco(String nomParroco) {
        this.nomParroco = nomParroco;
    }

    public int getNumLibro() {
        return numLibro;
    }

    public void setNumLibro(int numLibro) {
        this.numLibro = numLibro;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codigo;
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
        final Feligres other = (Feligres) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Feligres{" + "codigo=" + codigo + '}';
    }

    
    
    
}
