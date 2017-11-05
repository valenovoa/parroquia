/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parroquia.ejb;

import com.parroquia.model.Feligres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valer
 */
@Stateless
public class FeligresFacade extends AbstractFacade<Feligres> implements FeligresFacadeLocal {

    @PersistenceContext(unitName = "parroquiaPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeligresFacade() {
        super(Feligres.class);
    }
    
}
