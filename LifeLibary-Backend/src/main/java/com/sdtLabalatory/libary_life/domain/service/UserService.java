package com.sdtLabalatory.libary_life.domain.service;

import java.util.List;

import com.sdtLabalatory.libary_life.model.UserPrincipal;



public interface UserService {
	
	 // ����������� ������������ �� �����
	 UserPrincipal getUser(String login, String password);
	 
	 //���������� ������������ �� ��
	 UserPrincipal getUserByID(Long userId);
	 
	 //���������� ������������ �� �����
	 UserPrincipal getUserByName(String name);
	 
	 // ����� ���������� ������ ���� ��������
	 List<UserPrincipal> getUsers();
     
		 
	 // ���������� ��������� ���������� �� �������� �� �������
	 void saveUser(UserPrincipal user);



}
