package com.arnold.Basic.Reflection;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 反射示例
 * @author 菠萝大象
 */
public class Person<T, K extends Comparable<? super T> & Serializable>
		extends SuperPerson<String>	implements Handle<Date> {
	
	private T t;
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public void add(List<? extends T> list){
		for(T t : list){
			add(t);
		}
	}
	
	public void add(T t){};
	
	public void add(T t, List<? super T> list){
		list.add(t);
	}
	
	public static <T extends Comparable<? super T>> T max(List<? extends T> list){
		Iterator<? extends T> it = list.iterator();
		T result = it.next();
		while(it.hasNext()){
			T t = it.next();
			if(t.compareTo(result) > 0) 
				result = t;
		}
		return result;
	}
}

