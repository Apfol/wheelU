package com.reservas.facade;

import java.util.ArrayList;

import com.reservas.entidades.Conductor;
import com.reservas.entidades.Pasajero;
import com.reservas.entidades.Usuario;
import com.reservas.flyweight.Factory;
import com.reservas.proxy.IProxy;


public class Facade implements IProxy {
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static Facade mFacade;
	private  Factory fabricaUsers = new Factory();;
	
	public static Facade getInstance() {
		if (mFacade == null) {
			mFacade = new Facade();
			mFacade.fabricaUsers.cargarUsuarios(mFacade.getUsuarios());
		}
		return mFacade;
	}
	
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

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
	
	public void usuariosDummy() {
		usuarios.add(new Conductor("Jario lopez", "jairolo@unisabana.edu.co", "jario123", "1073525507"));
		//FacadeProxy.getUsuarios().add(new UsuarioLogin("jairolo@unisabana.edu.co", "jario123"));
		usuarios.add(new Conductor("Sara Bustos", "sarabu@unisabana.edu.co", "sara123", "1045676829"));
		//FacadeProxy.getUsuarios().add(new UsuarioLogin("sarabu@unisabana.edu.co", "sara123"));
		usuarios.add(new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889"));
		//FacadeProxy.getUsuarios().add(new UsuarioLogin("anaga@unisabana.edu.co", "ana123"));
		usuarios.add(new Pasajero("Juan Correa", "juanco@unisabana.edu.co", "juan123", "216654382"));
		//FacadeProxy.getUsuarios().add(new UsuarioLogin("juanco@unisabana.edu.co", "juan123"));
	}
	
}
