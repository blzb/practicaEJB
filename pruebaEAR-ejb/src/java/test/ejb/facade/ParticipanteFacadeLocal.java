/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb.facade;

import java.util.List;
import javax.ejb.Local;
import test.jpa.Participante;

/**
 *
 * @author Angel
 */
@Local
public interface ParticipanteFacadeLocal {
    public List<Participante> getAll();
    public Participante get(Long id) ;
    public void save(Participante p);
    public void delete(Participante p);    
}
