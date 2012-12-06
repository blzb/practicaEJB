/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.web.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import test.ejb.facade.ParticipanteFacadeLocal;
import test.jpa.Participante;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class ListaParticipantes {
    @EJB
    private ParticipanteFacadeLocal participanteFacade;    
    
    /**
     * Creates a new instance of ListaParticipantes
     */
    public List<Participante> getParticipantes(){
        return participanteFacade.getAll();
    }
    public ListaParticipantes() {
    }
}
