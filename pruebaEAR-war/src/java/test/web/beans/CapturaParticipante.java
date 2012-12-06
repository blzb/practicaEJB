/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.web.beans;

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
public class CapturaParticipante {
    @EJB
    private ParticipanteFacadeLocal participanteFacadeLocal;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String guardar(){
        Participante p = new Participante();
        p.setApellidoMaterno(apellidoMaterno);
        p.setApellidoPaterno(apellidoPaterno);
        p.setNombre(nombre);
        participanteFacadeLocal.save(p);
        participanteFacadeLocal.delete(p);
        return "listaParticipantes";
        
    }
    /**
     * Creates a new instance of CapturaParticipante
     */
    public CapturaParticipante() {
    }
}
