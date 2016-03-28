package com.sdtLabalatory.libary_life.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sdtLabalatory.libary_life.domain.service.UserService;
import com.sdtLabalatory.libary_life.model.UserPrincipal;
 
@Component
public class StringToUserPrincipalConverter implements Converter<String, UserPrincipal> {
 
    @Autowired
	private UserService userService;
     
    @Override
    public UserPrincipal convert(String userId) {
        return userService.getUserByID(new Long(userId));
    }
 
}