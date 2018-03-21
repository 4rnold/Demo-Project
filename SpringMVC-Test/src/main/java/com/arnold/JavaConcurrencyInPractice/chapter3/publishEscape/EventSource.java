package com.arnold.JavaConcurrencyInPractice.chapter3.publishEscape;

public class EventSource {
  
    public void registerListener(EventListener listener) {
		listener.onEvent(null);
    }  
  
}  