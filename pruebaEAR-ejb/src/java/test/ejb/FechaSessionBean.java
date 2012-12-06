/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Angel
 */
@Stateless
public class FechaSessionBean implements FechaSessionBeanLocal{

    
    @Override
    public Date getFecha() {
        return new Date();
    }
   @PostConstruct
   public void construir(){
    
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
