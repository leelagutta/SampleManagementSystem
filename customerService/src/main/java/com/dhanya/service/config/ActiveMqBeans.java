package com.dhanya.service.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.model.producer.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;

/**
 * Setting up activeMq bean configuration
 * @author Leela Gutta
 *
 */
@Configuration
@PropertySource("classpath:/common.properties")
public class ActiveMqBeans {
	
	@Autowired
	private Environment env;
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() { //creating connection factory to connect to message broker
		ActiveMQConnectionFactory activeMq = new ActiveMQConnectionFactory();
		activeMq.setUserName(env.getProperty("activeMqBeans.user"));
	    activeMq.setPassword(env.getProperty("activeMqBeans.password"));
		activeMq.setBrokerURL(env.getProperty("activeMqBeans.url"));
		return activeMq;
	}
	
	@Bean(name="destination")
	public ActiveMQQueue getGestinationQueue() {
		ActiveMQQueue queue = new ActiveMQQueue(env.getProperty("activeMqBeans.destination"));
		return queue;
	}
	

	@Bean(name="JmsTemplate")
	public JmsTemplate template() {
		JmsTemplate temp = new JmsTemplate(connectionFactory());
		temp.setDefaultDestination(getGestinationQueue()); //setting default destination to send messages
		//temp.setMessageConverter(messageConvertor()); // Converts messages to and from jSON
		return temp;
	}
	
	@Bean(name="messageSender")
	public MessageSender sender() {
		MessageSender sender = new MessageSender(template());
		return sender;
	}
}