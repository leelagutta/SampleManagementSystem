package org.EmailSystem.config;
import java.util.Properties;
import org.EmailSystem.consumer.EmailConsumer;
import org.EmailSystem.createEmail.GenerateEmail;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 * Bean configuration for activeMQ and message consumer
 * @author Leela Gutta
 */

@PropertySource("classpath:/common.properties")
public class EmailBeans {
	
	@Autowired
	private Environment env;
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() { //creating connection factory to connect to message broker
		ActiveMQConnectionFactory activeMq = new ActiveMQConnectionFactory();
		activeMq.setUserName((env.getProperty("activeMqBeans.user")));
		activeMq.setPassword((env.getProperty("activeMqBeans.password")));
		activeMq.setBrokerURL((env.getProperty("activeMqBeans.url")));
		return activeMq;
	}
	
	@Bean(name="destination")
	public ActiveMQQueue destinationQ() //declaring a ActiveMQ message destination
	{
		ActiveMQQueue queue = new ActiveMQQueue(env.getProperty("activeMqBeans.destination"));
		return queue;
	}
	
	@Bean(name="emailconsumer") //Class that implements Message Listener
	public EmailConsumer emailconsumer() {
		EmailConsumer consumer = new EmailConsumer(generateEmail());
		return consumer;
	}
	
	@Bean(name="defaultMessageListenerContainer") //instead of the receiver class implementing messageListener interface, declare it as bean 
	public DefaultMessageListenerContainer ListenerContainer() {
		DefaultMessageListenerContainer one = new DefaultMessageListenerContainer();
		one.setConnectionFactory(connectionFactory());
		one.setDestination(destinationQ());
		one.setMessageListener(emailconsumer());
		one.afterPropertiesSet();
		one.start();
		return one;
	}
	
	@Bean(name = "mailSender")
	public MailSender mailSender() {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost(env.getProperty("mailServer.host"));
		mail.setPort(587);
		mail.setUsername(env.getProperty("mailServer.user"));
		mail.setPassword(env.getProperty("mailServer.password"));
		mail.setJavaMailProperties(javaMailProperties());
		return mail;
	}
	
	@Bean(name = "javaMailProp")
	public Properties javaMailProperties() {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.auth", env.getProperty("mailServer.auth"));
		prop.setProperty("mail.smtp.starttls.enable",
				env.getProperty("mailServer.starttls"));
		return prop;
	}
	
	@Bean(name = "generateEmail")
	public GenerateEmail generateEmail() {
		GenerateEmail sendMail = new GenerateEmail(mailSender());
		return sendMail;
		
	}
	
	
}
