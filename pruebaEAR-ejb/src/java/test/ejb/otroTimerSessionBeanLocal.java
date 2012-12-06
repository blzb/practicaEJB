/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import javax.ejb.Local;

/**
 *
 * @author Angel
 */
@Local
public interface otroTimerSessionBeanLocal {
    
    public void myTimer();
}
