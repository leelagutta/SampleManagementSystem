package org.EmailSystem;

import org.EmailSystem.config.EmailBeans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Leela Gutta
 */

public class EmailLauncher {

	public static void main(String[] args) throws Exception {

		// Starts new application context to load the email beans
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				EmailBeans.class);
		context.getBean("defaultMessageListenerContainer");
	}
}
