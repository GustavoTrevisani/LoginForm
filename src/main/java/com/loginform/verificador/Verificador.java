package com.loginform.verificador;

public class Verificador {

	public static Boolean verifyLoginDuplicity(String loginCadastro, String loginExistente) {
		Boolean alreadyExist = false;
		if (loginExistente.contains(loginCadastro)) {
			alreadyExist = true;
		}
		return alreadyExist;
	}
	public static Boolean verifyLoginMatch(String loginCadastro, String loginExistente, String passwordCadastro, String passwordExistente) {
		Boolean loginMatcht = false;
		if (loginExistente.contains(loginCadastro) && passwordExistente.contains(passwordCadastro)) {
			loginMatcht = true;
		}
		return loginMatcht;
	}
}