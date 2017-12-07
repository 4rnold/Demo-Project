package com.arnold.web.converter;

import com.arnold.web.XmlAndJsonRequest.domain.User;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConverter implements Converter<String,User> {

    @Override
    public User convert(String source) {
        User user = new User();
        if (source != null) {
            String[] items = source.split(":");
            user.setUserId(items[0]);
            user.setUserName(items[1]);
        }
        return user;
    }
}
