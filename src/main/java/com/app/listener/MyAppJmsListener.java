package com.app.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class MyAppJmsListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage t=(TextMessage)message;
		try {
			System.out.println("Consumer 1 start");
			System.out.println(t.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
