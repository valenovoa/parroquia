
package com.parroquia.controller;

import com.parroquia.ejb.FeligresFacadeLocal;
import com.parroquia.model.Feligres;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named
@RequestScoped
public class BuscarController implements Serializable{
    
    @EJB
    private FeligresFacadeLocal feliEJB;
    
    private List<Feligres> feligress;
    private Feligres feligres;
    
    @PostConstruct
    public void init(){
        feligress = feliEJB.findAll();
    }

    public List<Feligres> getFeligress() {
        return feligress;
    }

    public void setFeligress(List<Feligres> feligress) {
        this.feligress = feligress;
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }
    //guarda los datos del feligres temporalmente para mandarlos al otro controlador
     public void asignar(Feligres feligres){
        this.feligres = feligres;
    }
    
    
}
