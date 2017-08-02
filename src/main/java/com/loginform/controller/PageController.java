package com.loginform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
public class PageController {
	
	@RequestMapping("/login")
	public String form(Model model) {
		System.out.println("teste");		
		return "view/form";
		
	}
	
	

}
