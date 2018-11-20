package com.reservas.facade;

import java.util.ArrayList;
import java.util.Hashtable;

import com.reservas.entidades.Conductor;
import com.reservas.entidades.Pasajero;
import com.reservas.entidades.Reserva;
import com.reservas.entidades.Usuario;
import com.reservas.flyweight.Factory;
import com.reservas.proxy.Aleatorio;
import com.reservas.proxy.IProxy;
import com.reservas.proxy.Proxy;
import com.reservas.proxy.UsuarioLogin;


public class Facade implements IProxy {
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private static Hashtable<String, Long> aleatorios = new Hashtable<String, Long>();
	
	private static Facade mFacade;
	private  Factory fabricaUsers = new Factory();;
	
	public static Facade getInstance() {
		if (mFacade == null) {
			mFacade = new Facade();
			mFacade.fabricaUsers.cargarUsuarios(mFacade.getUsuarios());
		}
		return mFacade;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public Aleatorio iniciarSesion(String correo, String password) {
		long aleatorio =  (long) (Math.random() * 2E13+1);
		aleatorios.put(correo, aleatorio);
		return new Aleatorio(correo, aleatorio);
	}
	
	public void usuariosDummy() {
		usuarios.add(new Conductor("Jario lopez", "jairolo@unisabana.edu.co", "jario123", "1073525507"));
		Proxy.getUsuarios().add(new UsuarioLogin("jairolo@unisabana.edu.co", "jario123"));
		usuarios.add(new Conductor("Sara Bustos", "sarabu@unisabana.edu.co", "sara123", "1045676829"));
		Proxy.getUsuarios().add(new UsuarioLogin("sarabu@unisabana.edu.co", "sara123"));
		usuarios.add(new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889"));
		Proxy.getUsuarios().add(new UsuarioLogin("anaga@unisabana.edu.co", "ana123"));
		usuarios.add(new Pasajero("Juan Correa", "juanco@unisabana.edu.co", "juan123", "216654382"));
		Proxy.getUsuarios().add(new UsuarioLogin("juanco@unisabana.edu.co", "juan123"));
	}
	
	public void reservasDummy() {
		reservas.add(new Reserva("Reserva1", 2, 1073525507));
	}

	public ArrayList<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
