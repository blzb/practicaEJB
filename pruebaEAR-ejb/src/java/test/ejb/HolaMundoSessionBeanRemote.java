/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Angel
 */
@Remote
public interface HolaMundoSessionBeanRemote {
    String getSaludo(String nombre);    
}
