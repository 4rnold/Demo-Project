package com.arnold.JavaConcurrencyInPractice.chapter3.publishEscape;

public class Client {
  
    /**
	 *
     * @param args 
     * @throws InterruptedException 
     */  
    public static void main(String[] args) throws InterruptedException {  
        EventSource es = new EventSource();  
        new ThisEscape(es);  
  
    }  
  
}  