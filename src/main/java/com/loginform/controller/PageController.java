package com.loginform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginform.dao.UserRepository;
import com.loginform.user.User;
import com.loginform.verificador.Verificador;

@Controller
public class PageController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/loggedIn")
	public String loggedInPage(Model model) {
		return "view/loggedIn";
	}

	@GetMapping("/main")
	public String mainPage(Model model) {
		return "view/main";
	}
	
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
		String view;
		String msg = "Cadastro efetuado com sucesso.";			
		String loginCadastrado = dadosDoFormulario.getLogin();
		String loginExistente = userRepo.findAll().toString();	
		model.addAttribute("msgCadastro", msg);
		if (Verificador.verify(loginCadastrado, loginExistente)){
			msg = "Já existe um USUÁRIO cadastrando com este LOGIN!";	
			view = "view/try_again";
		}else {
		userRepo.save(new User(dadosDoFormulario.getLogin(), dadosDoFormulario.getPassword()));
		view = "view/registered";
		}
		return view;
	}

}
