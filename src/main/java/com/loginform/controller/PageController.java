package com.loginform.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loginform.user.User;

@Controller
public class PageController {

	@GetMapping("/login")
	public String form(Model model) {
		model.addAttribute(new User());
		System.out.println("Getmap");
		return "view/form";

	}
	
	@PostMapping("/login")
	public String result(Model model) {		
		System.out.println("Postmap");
		return "view/form";
	}

}
