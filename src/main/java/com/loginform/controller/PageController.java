package com.loginform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginform.dao.TaskRepository;
import com.loginform.dao.UserRepository;
import com.loginform.tasks.TaskList;

import com.loginform.user.User;

@Controller
public class PageController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TaskRepository taskRepo;

	@GetMapping("/home")
	public String homePage(Model model) {
		return "view/home";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userData", new User());
		return "view/register";
	}

	@PostMapping("/registered")
	public String registerRequest(@ModelAttribute User usuario, Model model) {
		String view;
		String msg = "Cadastro efetuado com sucesso.";
		List<User> user = userRepo.findByLogin(usuario.getLogin());
		if (user.size() > 0) {
			msg = "Já existe um USUÁRIO cadastrado com este LOGIN!";
			view = "view/try_register_again";
			model.addAttribute("registerMsg", msg);
		} else {
			userRepo.save(new User(usuario.getLogin(), usuario.getPassword()));
			model.addAttribute("registerMsg", msg);
			view = "view/registered";
		}
		return view;
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("userData", new User());
		return "view/login";
	}

	@PostMapping("/loggedIn")
	public String loginRequest(@ModelAttribute User usuario, @ModelAttribute TaskList tarefa, Model model) {
		List<User> users = userRepo.findByLoginAndPassword(usuario.getLogin(), usuario.getPassword());
		if (users.size() > 0) {
			model.addAttribute("userData", usuario);
			model.addAttribute("task", tarefa);
			return "view/user_home";
		} else {
			model.addAttribute("userData", new User());
			model.addAttribute("msg", "Erro no login ou senha, tente novmente");
			return "view/login";
		}
	}

	@PostMapping("/tasks")
	public String taskPage(@ModelAttribute TaskList tarefa, Model model) {
		List<String> taskList = new ArrayList<String>();
		for (int i = 0; i < taskRepo.count(); i++) {
			taskList.add(taskRepo.findOne((long) i).getTask());
		}
		model.addAttribute("task", new TaskList());
		System.out.println(taskList);
		taskRepo.save(new TaskList(tarefa.getTask(), tarefa.getBeginDate(), tarefa.getEndDate()));
		return "view/user_home";
	}
}

/*
 * @PostMapping("/loggedIn") public String metodoTeste(@ModelAttribute User
 * dadosDoFormulario, Model model) { String msg =
 * "Cadastro efetuado com sucesso."; String loginCadastrado =
 * dadosDoFormulario.getLogin(); String loginExistente =
 * userRepo.findAll().toString(); String passwordCadastrado =
 * dadosDoFormulario.getPassword(); String passwordExistente =
 * userRepo.findAll().toString(); String view; if
 * (Verificador.verifyLoginMatch(loginCadastrado, loginExistente,
 * passwordCadastrado , passwordExistente)){ msg = "Logado com Sucesso";
 * model.addAttribute("msgCadastro", msg); view = "view/user_home"; }else { view
 * = "view/try_login_again"; }
 * 
 * return view; }
 */
