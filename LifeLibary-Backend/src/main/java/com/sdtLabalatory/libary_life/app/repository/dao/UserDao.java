package com.sdtLabalatory.libary_life.app.repository.dao;

import com.sdtLabalatory.libary_life.app.repository.base.GenericDao;
import com.sdtLabalatory.libary_life.model.UserPrincipal;

public interface UserDao extends GenericDao<UserPrincipal, Long> {

	UserPrincipal getUser(String login, String password);

	UserPrincipal getUserByID(Long userId);

	UserPrincipal getUserByName(String name);

}
