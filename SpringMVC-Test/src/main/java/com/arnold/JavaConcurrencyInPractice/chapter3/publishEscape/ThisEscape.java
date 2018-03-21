package com.arnold.JavaConcurrencyInPractice.chapter3.publishEscape;

import com.arnold.JavaConcurrencyInPractice.chapter3.publishEscape.EventListener;

import java.awt.*;

public class ThisEscape {
	private String name = null;
  
    public ThisEscape(EventSource source) {  
        source.registerListener(new EventListener() {
  
            @Override
			public void onEvent(Event event) {
                doSomething(event);  
            }  
  
        });  
        name = "TEST";  
    }  
  
    /** 
     * 
     * @param event 
     */  
    protected void doSomething(Event event) {  
        System.out.println(name.toString());  
    }  
}  
