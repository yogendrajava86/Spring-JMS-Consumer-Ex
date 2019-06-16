package com.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

@Configuration
@ComponentScan("com.app")
@EnableJms
public class AppConfig {
	
	@Autowired
	private MessageListener messageListener;
	
	@Bean
	public ConnectionFactory cf() {
		ActiveMQConnectionFactory c=new ActiveMQConnectionFactory();
		c.setBrokerURL("tcp://localhost:61616");
		return c;
	}
	
	@Bean
	public MessageListenerContainer ms() {
		DefaultMessageListenerContainer dm=new DefaultMessageListenerContainer();
		dm.setDestinationName("my-qu1");
		
		/* If you want access broadcast message then setPubSubDomain(true) and use Destination as Topic instead of Queue*/
		//dm.setPubSubDomain(true);
		//dm.setDestinationName("my-tpq1");
		dm.setConnectionFactory(cf());
		dm.setMessageListener(messageListener);
		
		return dm;
	}

}
