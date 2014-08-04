package br.com.geraldoferraz.geradordevo.ejbs;

import br.com.geraldoferraz.geradordevo.entidades.Usuario;

public class ExemploEJB {

	private String teste;

	@SuppressWarnings("unused")
	private String metodoPrivado() {
		return "";
	}

	public Usuario buscarUsuario(Long id) {
		return null;
	}

	public void salvarUsuario(Usuario usuario) {
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

}
