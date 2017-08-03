package com.loginform.dao;

import org.springframework.data.repository.CrudRepository;

import com.loginform.user.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
