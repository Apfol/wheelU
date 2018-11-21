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
	private static Hashtable<String, String> aleatoriosHash = new Hashtable<String, String>();
	
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
	public Usuario getUsuario(String idUs) {
		Usuario usu = null; 
		for (Usuario us : usuarios) {
			if(us.getDocumento().equals(idUs)) {
				usu = us;
				return usu;
			}
		}
		return usu;
	}
	
	public void eliminarReserva(String idRuta, String docPasa) {
		for (Reserva reserva : reservas) {
			if(reserva.getIDRutaReservada().equals(idRuta)) {
				for(Usuario us: usuarios) {
					if(us.getDocumento().equals(docPasa)) {
						reservas.remove(reserva);
						break;
					}
				}
			}
		}
	}
	
	public void addReserva(Reserva res) {
		reservas.add(res);
	}

	@Override
	public Aleatorio iniciarSesion(String correo, String password) {
		String aleatorio =  String.valueOf((long) (Math.random() * 2E13+1));
		aleatoriosHash.put(aleatorio, correo);
		return new Aleatorio(correo, aleatorio);
	}
	
	public void usuariosDummy() {
		usuarios.add(new Conductor("Jario lopez", "jairolo@unisabana.edu.co", "jairo123", "1073525507"));
		Proxy.getUsuarios().add(new UsuarioLogin("jairolo@unisabana.edu.co", "jairo123"));
		usuarios.add(new Conductor("Sara Bustos", "sarabu@unisabana.edu.co", "sara123", "1045676829"));
		Proxy.getUsuarios().add(new UsuarioLogin("sarabu@unisabana.edu.co", "sara123"));
		usuarios.add(new Pasajero("Ana Garcia", "anaga@unisabana.edu.co", "ana123", "1234567889"));
		Proxy.getUsuarios().add(new UsuarioLogin("anaga@unisabana.edu.co", "ana123"));
		usuarios.add(new Pasajero("Juan Correa", "juanco@unisabana.edu.co", "juan123", "216654382"));
		Proxy.getUsuarios().add(new UsuarioLogin("juanco@unisabana.edu.co", "juan123"));
	}
	
	public void reservasDummy() {
		reservas.add(new Reserva("Reserva1", "2", "1073525507"));
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public Reserva modificarReserva(String nombreReserva, String iDRutaReservada, String documentoPasajero) {
		Reserva reservaModificada = new Reserva(nombreReserva, iDRutaReservada, documentoPasajero);
		int contador = 0;
		for(Reserva reserva: reservas) {
			if(reserva.getNombreReserva().equals(nombreReserva)) {
				reservas.set(contador, reservaModificada);
				return reservaModificada;
			}
			contador++;
		}
		return null;
	}

	public boolean isSesion(Aleatorio aleatorio, String documento) {
		if(aleatoriosHash.containsKey(aleatorio.getAleatorio()) && documento.equals(aleatoriosHash.get(aleatorio.getAleatorio()))) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Reserva> consultarReservas(String documentoPasajero) {
		ArrayList<Reserva> reservasPasajero = new ArrayList<>();
		for(Reserva reserva: reservas) {
			if(documentoPasajero.equals(reserva.getDocumentoPasajero())) {
				reservasPasajero.add(reserva);
			}
		}
		return reservasPasajero;
	}

	public Usuario obtenerUsuario(String documentoPasajero) {
		for(Usuario usuario: usuarios) {
			if(usuario.getCorreo().equals(documentoPasajero)) {
				return usuario;
			}
		}
		return null;
	}
	
}
