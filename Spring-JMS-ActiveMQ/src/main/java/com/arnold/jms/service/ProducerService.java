package com.arnold.jms.service;

import javax.jms.Destination;

public interface ProducerService {

	public void sendMessage(Destination destination, final String message);
}
