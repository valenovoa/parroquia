
package com.parroquia.model;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Feligress {

    private int codigo;
    private String nombres;
    private String apellidos;
    private String nomMama;
    private String nomPapa;
    private String nomMadrina;
    private String nomPadrino;
    private Date fechaNacimiento;
    private Date fechaBautizo;
    private String lugar;
    private String nomParroco;
    private int numLibro;
    private int numPagina;
    private String lugarNacimiento;

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
    
    

}
