package com.arnold.jms.MessageConverter.service;

import javax.jms.Destination;
import java.io.Serializable;

public interface EntityProducerService {
  
    public void sendMessage(Destination destination, final Serializable obj);
}  