package com.arnold.web.converter.controller;

import com.arnold.web.XmlAndJsonRequest.domain.User;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        if (text != null) {
            String[] items = text.split(":");
            user.setUserName(items[0]+"by propertyeEditor");
        }
        setValue(user);
    }
}
