
package com.parroquia.controller;

import com.parroquia.ejb.FeligresFacadeLocal;
import com.parroquia.model.Feligres;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class feligresController implements Serializable{

    @EJB
    private FeligresFacadeLocal feligresEJB;
    
    @Inject
    private Feligres feligres;
    
    private List<Feligres> feligreces;
    
    @PostConstruct
    public void init(){
       
       feligreces = feligresEJB.findAll();
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }

    public List<Feligres> getFeligreces() {
        return feligreces;
    }

    public void setFeligreces(List<Feligres> feligreces) {
        this.feligreces = feligreces;
    }
    
    public void registrar(){
        try{
           feligresEJB.create(feligres);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
        }catch(Exception e){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Erro al registrar"));
        }
    }
}
