
package com.parroquia.controller;


import com.parroquia.ejb.PersonaFacadeLocal;
import com.parroquia.ejb.UsuarioFacadeLocal;
import com.parroquia.model.Persona;
import com.parroquia.model.Usuario;
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
public class UsuarioController implements Serializable{
    
   @EJB
    private UsuarioFacadeLocal usuarioEJB;
   @EJB
   private PersonaFacadeLocal personaEJB;
   
    @Inject
    private Usuario usuario;
    @Inject
    private Persona persona; 
    
    private List<Persona> personas;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init(){
       //usuario = new Usuario();
      // persona = new Persona();
      usuarios = usuarioEJB.findAll();
      personas = personaEJB.findAll();
       
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
    
    
    public void registrar(){
        try{
            this.usuario.setCodigo(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Erro al registrar"));
        }
    }
}
