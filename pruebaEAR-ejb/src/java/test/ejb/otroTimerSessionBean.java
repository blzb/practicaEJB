/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author Angel
 */
@Stateless
public class otroTimerSessionBean implements otroTimerSessionBeanLocal {

    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9-17", dayOfWeek = "Mon-Fri")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
