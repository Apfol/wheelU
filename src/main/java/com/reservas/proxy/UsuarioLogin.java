package com.reservas.proxy;

public class UsuarioLogin {
	
	private String correo;
	private String password;
	
	public UsuarioLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioLogin(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String documento) {
		this.correo = documento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
