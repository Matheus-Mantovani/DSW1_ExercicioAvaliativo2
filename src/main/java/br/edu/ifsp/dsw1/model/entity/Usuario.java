package br.edu.ifsp.dsw1.model.entity;

public class Usuario {
	private String login;
	private String senha;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
