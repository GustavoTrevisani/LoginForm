package com.loginform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginform.dao.UserRepository;
import com.loginform.user.User;

@Controller
public class PageController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/register")
	public String formCadastro(Model model) {
		model.addAttribute("dadosDoFormulario", new User());
		return "view/register";
	}

	@GetMapping("/login")
	public String formlogin(Model model) {
		model.addAttribute("dadosDoFormulario", new User());
		return "view/login";
	}

	@PostMapping("/registered")
	public String recebeRequisicao(@ModelAttribute User dadosDoFormulario, Model model) {
		String msg = "teste";		
		userRepo.save(new User(dadosDoFormulario.getLogin(), dadosDoFormulario.getPassword()));
		model.addAttribute("msgCadastro", msg);
		return "view/result";

	}

}
