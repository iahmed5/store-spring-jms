package com.company.storespringjms;

import com.company.storespringjms.util.Sender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@SpringBootApplication
public class SpringExternalFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExternalFactoryApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(
				SpringExternalFactoryApplication.class, args
		);
		Sender sender = context.getBean(Sender.class);
		sender.sendMessage("order-queue", "Hello World - External Factory");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}
}
