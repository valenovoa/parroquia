/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parroquia.ejb;

import com.parroquia.model.Feligres;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valer
 */
@Local
public interface FeligresFacadeLocal {

    void create(Feligres feligres);

    void edit(Feligres feligres);

    void remove(Feligres feligres);

    Feligres find(Object id);

    List<Feligres> findAll();

    List<Feligres> findRange(int[] range);

    int count();
    
}
