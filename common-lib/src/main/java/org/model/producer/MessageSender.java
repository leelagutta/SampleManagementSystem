package org.model.producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
/**
 * Common Message producer. Any class can use it to send messages to activeMQ
 * @author Leela Gutta
 *
 */


public class MessageSender {       
	
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public MessageSender(JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public <T>void sendMessage(T data) {
		jmsTemplate.convertAndSend(data);
		
	}	
}