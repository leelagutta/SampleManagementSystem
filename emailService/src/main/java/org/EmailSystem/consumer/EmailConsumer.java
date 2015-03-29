package org.EmailSystem.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.EmailSystem.createEmail.GenerateEmail;
import org.apache.log4j.Logger;
import org.model.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Message consumer that implements MessageListener
 * @author Leela Gutta
 */

public class EmailConsumer implements MessageListener {
	
	private static final Logger log = Logger.getLogger(EmailConsumer.class.getName());

	@Autowired
	private GenerateEmail generateEmail;

	public EmailConsumer(GenerateEmail generateEmail) {
		this.generateEmail = generateEmail;

	}

	/**
	 * OnMessage method is called by default when
	 * defaultMessageListenerContainer is set as Message listener bean Generates
	 * and sends an email
	 */
	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {

			ObjectMessage msg = (ObjectMessage) message;
			CustomerModel customer = new CustomerModel();

			try {
				customer = (CustomerModel) msg.getObject();
                generateEmail.sendMail(customer.getEmail(),
						customer.getFirstName(), customer.getLastName());
			} catch (JMSException e) {
				e.printStackTrace();
				log.info(e);
			}

		}

	}

}
