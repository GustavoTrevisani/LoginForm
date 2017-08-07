package com.loginform.controller;

import java.util.List;

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
	
	@GetMapping("/home")
	public String homePage(Model model) {
		return "view/home";
	}
	
	@GetMapping("/register")
	public String formCadastro(Model model) {
		model.addAttribute("dadosDoFormulario", new User());
		return "view/register";
	}
		
	@PostMapping("/registered")
	public String recebeRequisicao(@ModelAttribute User dadosDoFormulario, Model model) {
		String view;
		String msg = "Cadastro efetuado com sucesso.";			
		String loginCadastrado = dadosDoFormulario.getLogin();
		String loginExistente = userRepo.findAll().toString();	
		if (Verificador.verifyLoginDuplicity(loginCadastrado, loginExistente)){
			msg = "Já existe um USUÁRIO cadastrando com este LOGIN!";	
			view = "view/try_register_again";
			model.addAttribute("msgCadastro", msg);
		}else {
			userRepo.save(new User(dadosDoFormulario.getLogin(), dadosDoFormulario.getPassword()));
			model.addAttribute("msgCadastro", msg);
			view = "view/registered";
		}
		return view;
	}

	@GetMapping("/login")
	public String formlogin(Model model) {
		model.addAttribute("dadosDoFormulario", new User());
		return "view/login";
	}
	
	@PostMapping("/loggedIn")
	public String metodoTeste(@ModelAttribute User dadosDoFormulario, Model model) {
		List<User> users = userRepo.findByLoginAndPassword(dadosDoFormulario.getLogin(), dadosDoFormulario.getPassword());
		if(users.size() > 0) {
			return "view/user_home";
		} else {
			model.addAttribute("dadosDoFormulario", new User());
			model.addAttribute("msg", "Erro no login ou senha, tente novmente");
			return "view/login";
		}
	/*
	@PostMapping("/loggedIn")
	public String metodoTeste(@ModelAttribute User dadosDoFormulario, Model model) {
		String msg = "Cadastro efetuado com sucesso.";			
		String loginCadastrado = dadosDoFormulario.getLogin();
		String loginExistente = userRepo.findAll().toString();
		String passwordCadastrado = dadosDoFormulario.getPassword();
		String passwordExistente = userRepo.findAll().toString();
		String view;
		if (Verificador.verifyLoginMatch(loginCadastrado, loginExistente, passwordCadastrado , passwordExistente)){
			msg = "Logado com Sucesso";				
			model.addAttribute("msgCadastro", msg);
			view = "view/user_home";
		}else {
		view = "view/try_login_again";
		}
		
		return view;
	}
	*/
	
	}
	
	



}
