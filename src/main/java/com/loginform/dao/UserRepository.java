package com.loginform.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.loginform.user.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findByLoginAndPassword(String login, String password);
	
	public List<User> findByLogin(String login);
	
	

	
	
}
