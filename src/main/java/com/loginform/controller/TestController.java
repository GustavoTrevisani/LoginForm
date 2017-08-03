package com.loginform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginform.dao.UserRepository;
import com.loginform.user.User;

@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	@GetMapping("/create-user")
	public String createUser() {
		userRepo.save(new User("asdf", "senhafoda"));
		return "user created";
		
	}
	@GetMapping("/list-user")
	public String listUser() {
		StringBuffer b = new StringBuffer();
		
//		List<User> listaDeUser = (List<User>) userRepo.findAll();
//		for(int i = 0; i< listaDeUser.size(); i++) {
//			User u = listaDeUser.get(i);
//			b.append(u.toString());
//			b.append("\n");
//		
//		}
		for(User u: userRepo.findAll()) {
			b.append(u.toString()).append("\n");
		}
		return b.toString();
				
	}


}
