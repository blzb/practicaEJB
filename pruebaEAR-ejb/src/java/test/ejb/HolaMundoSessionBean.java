/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ejb;

import java.util.Enumeration;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Angel
 */
@Stateless
@WebService
public class HolaMundoSessionBean implements HolaMundoSessionBeanLocal {

    @Resource(mappedName = "queueConnectionFactory")
    javax.jms.QueueConnectionFactory queueConnectionFactory;
    @Resource(mappedName = "jms/testQueue")
    javax.jms.Queue queue;
    @EJB
    private FechaSessionBeanLocal fechaBean;

    @Override
    @WebMethod
    public String getSaludo(@WebParam(name = "nombre") String nombre) {
        if (nombre == null) {
            throw new RuntimeException("Error en el EJB");
        }
        try {
            Connection connection =
                    queueConnectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            TextMessage message = session.createTextMessage(nombre);
            MessageProducer producer = session.createProducer(queue);
            producer.send(message);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
            ex.printStackTrace();
        }

        return "HOLA " + nombre + "::" + fechaBean.getFecha();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
