package com.reservas.proxy;

import java.util.ArrayList;

import com.reservas.facade.Facade;



public class Proxy implements IProxy{
	
	private static Proxy mProxy;
	public static ArrayList<UsuarioLogin> usuarios = new ArrayList<UsuarioLogin>();
	private Facade facade;

	public static Proxy getInstance() {
		if(mProxy == null) {
			mProxy = new Proxy();
		}
		return mProxy;
	}

	@Override
	public Aleatorio iniciarSesion(String correo, String password) {
		for(UsuarioLogin usLogin: usuarios) {
			if (correo.equals(usLogin.getCorreo()) && password.equals(usLogin.getPassword())) {
				facade = Facade.getInstance();
				return facade.iniciarSesion(usLogin.getCorreo(), usLogin.getPassword());
			}
		}
		return new Aleatorio(null, "0");
	}
	
	public static ArrayList<UsuarioLogin> getUsuarios() {
		return usuarios;
	}


	public static void setUsuarios(ArrayList<UsuarioLogin> usuarios) {
		Proxy.usuarios = usuarios;
	}
	
}
