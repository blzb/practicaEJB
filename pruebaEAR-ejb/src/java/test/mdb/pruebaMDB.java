/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import test.ejb.facade.ParticipanteFacadeLocal;
import test.jpa.Participante;

/**
 *
 * @author Angel
 */
@MessageDriven(mappedName = "jms/testQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class pruebaMDB implements MessageListener {
    @EJB
    private ParticipanteFacadeLocal participanteFacade;
    public pruebaMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage txt = (TextMessage)message;
        try{
        System.out.println(message.getJMSType()+":"+message.getJMSTimestamp()+":"+txt.getText());
        Participante p = new Participante();
        p.setNombre(txt.getText());
        p.setApellidoMaterno(txt.getText());
        p.setApellidoPaterno(txt.getText());
        participanteFacade.save(p);
        }catch(Exception e){
            e.printStackTrace();            
        }
    }
}
