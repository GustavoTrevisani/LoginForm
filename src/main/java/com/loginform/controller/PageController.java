package com.loginform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.loginform.user.User;



@Controller
public class PageController {


	@GetMapping("/login")
	public String form(Model model) {
		model.addAttribute("dadosDoFormulario", new User());
		System.out.println("Getmap");
		return "view/form";

	}

	@PostMapping("/loginAction")
	public String recebeRequisicao(@ModelAttribute User dadosDoFormulario, Model model) {
		model.addAttribute("loginUsuario", dadosDoFormulario.getLogin());
		System.out.println(dadosDoFormulario.getLogin());
		System.out.println(dadosDoFormulario.getPassword());
		return "view/result";
	}

}
