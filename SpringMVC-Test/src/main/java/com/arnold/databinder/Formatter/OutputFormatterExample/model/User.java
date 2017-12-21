package com.arnold.databinder.Formatter.OutputFormatterExample.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

public class User {
	@DateTimeFormat(pattern="dd-MM-yyyy")                           //注解加在实例变量上
    private Date birthday;
    @NumberFormat(style= NumberFormat.Style.NUMBER,pattern="#,###")               //说是这两个属性互斥，怎么可以同时出现呢？
    private int total;
    @NumberFormat(style= NumberFormat.Style.PERCENT)
    private double discount;
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private double money;
    //。。。。。。。


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}