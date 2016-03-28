package com.sdtLabalatory.libary_life.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdtLabalatory.libary_life.app.repository.dao.UserDao;
import com.sdtLabalatory.libary_life.domain.service.UserService;
import com.sdtLabalatory.libary_life.model.UserPrincipal;

@Service()
@Transactional
public class UserServiceImplement implements UserService {

	@Autowired
	private UserDao userRepository;

	@Override
	public UserPrincipal getUser(String login, String password) {

		UserPrincipal user = userRepository
				.getUser(login, password);
		return user;
	}

	@Override
	public UserPrincipal getUserByID(Long userId) {

		UserPrincipal user = userRepository.getUserByID(userId);
		
		return user;
	}

	@Override
	public UserPrincipal getUserByName(String name) {
		UserPrincipal user = userRepository.getUserByName(name);
		return user;
	}

	@Override
	public List<UserPrincipal> getUsers() {
		List<UserPrincipal> users = userRepository.findAll();
		return users;
	}

	@Override
	public void saveUser(UserPrincipal user) {
		userRepository.save(user);
		
	}


}
