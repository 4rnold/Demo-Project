package com.arnold.web.XmlAndJsonRequest.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@XStreamAlias("message")
public class User {

    @XStreamAlias("id")
    @XStreamAsAttribute
    private String userId;

    @XStreamAsAttribute
    @Pattern(regexp = "w{4,30}")
    private String userName;

    @XStreamAsAttribute
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @XStreamAsAttribute
//    @DecimalMin(value="1000.00")
//    @DecimalMax(value="100000.00")
    @DateTimeFormat(pattern = "#,###.##")
    private long salary;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
