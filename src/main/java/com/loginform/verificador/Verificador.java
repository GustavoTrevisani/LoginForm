package com.loginform.verificador;

public class Verificador {

	public static Boolean verify(String loginCadastro, String loginExistente) {
		Boolean alreadyExist = false;
		if (loginExistente.contains(loginCadastro)) {
			alreadyExist = true;
		}
		return alreadyExist;
	}
}
