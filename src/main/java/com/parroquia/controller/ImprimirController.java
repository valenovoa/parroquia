
package com.parroquia.controller;

import com.parroquia.ejb.FeligresFacadeLocal;
import com.parroquia.model.Feligres;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ImprimirController implements Serializable{
    
    
    
    @Inject
    private BuscarController buscarController;
    private Feligres feligres;
    
    @PostConstruct
    public void init(){
        this.feligres = buscarController.getFeligres();
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }
    
    
    
}
