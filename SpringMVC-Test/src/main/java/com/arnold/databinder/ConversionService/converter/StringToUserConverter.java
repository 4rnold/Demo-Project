package com.arnold.databinder.ConversionService.converter;

import com.arnold.databinder._domain.User;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConverter implements Converter<String,User> {

	@Override
	public User convert(String source) {
		User user = new User();
		if(source != null){
			String[] items = source.split(":");
			user.setUserName(items[0]);
			user.setPassword(items[1]);
			user.setRealName(items[2]);
		}
		return user;
	}
}