
package com.parroquia.ejb;

import com.parroquia.model.Feligres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
