/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import java.util.Date;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Angel
 * @version 
 * 
 */
@Local
public interface FechaSessionBeanLocal {

    Date getFecha();
    
}
