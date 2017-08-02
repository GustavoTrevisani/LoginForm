package com.loginform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/login")
	public String form() {
		System.out.println("teste");
		return "view/form";

	}

}
