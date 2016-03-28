package com.sdtLabalatory.libary_life.domain.service;

import java.util.List;

import com.sdtLabalatory.libary_life.model.UserPrincipal;



public interface UserService {
	
	 // Авторизация пользователя на сайте
	 UserPrincipal getUser(String login, String password);
	 
	 //возвращает пользователя по ИД
	 UserPrincipal getUserByID(Long userId);
	 
	 //возвращает пользователя по имени
	 UserPrincipal getUserByName(String name);
	 
	 // метод возвращает список всех клиентов
	 List<UserPrincipal> getUsers();
     
		 
	 // сохранение введенной информации об аккаунте от клиента
	 void saveUser(UserPrincipal user);



}
