/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb.facade;

import com.sun.xml.ws.api.tx.at.Transactional;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import test.jpa.Participante;

/**
 *
 * @author Angel
 */
@Stateless
@WebService
public class ParticipanteFacade implements ParticipanteFacadeLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name="cursoPU")
    EntityManager em;
    @Override
    @WebMethod
    public List<Participante> getAll(){
        return em.createQuery("select p from Participante p").getResultList();
    }
    @Override
    @WebMethod
    public Participante get(@WebParam(name="id")Long id) {
        return em.find(Participante.class, id);
    }
    @Override
    @WebMethod
    public void save(@WebParam(name="participante")Participante p){
        em.persist(p);
    }
    @Override  
    @WebMethod
    public void delete(@WebParam(name="participante")Participante p){
        em.remove(p);
    }

}
