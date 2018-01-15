
package com.parroquia.ejb;

import com.parroquia.model.Feligres;
import java.util.List;
import javax.ejb.Local;


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
