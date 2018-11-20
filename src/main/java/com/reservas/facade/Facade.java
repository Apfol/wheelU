package com.reservas.facade;

import com.reservas.proxy.IProxy;

public class Facade implements IProxy{

	@Override
	public void crearPasajero(String nombre, String correo, String contrasena, String edad, String tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearConductor(String nombre, String correo, String contrasena, String edad, String tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearAdministrador(String nombre, String correo, String contrasena, String edad, String tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long iniciarSesion(String correo, String contrasena) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
