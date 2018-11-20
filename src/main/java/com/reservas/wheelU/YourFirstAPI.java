package com.reservas.wheelU;

import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.reservas.entidades.Reserva;
import com.reservas.entidades.Usuario;
import com.reservas.facade.Facade;
import com.reservas.proxy.Aleatorio;
import com.reservas.proxy.Proxy;

/**
 * Add your first API methods in this class, or you may create another class. In
 * that case, please update your web.xml accordingly.
 **/
@Api(name = "reservas", version = "v1", namespace = @ApiNamespace(ownerDomain = "wheelU.reservas.com", ownerName = "wheelU.reservas.com", packagePath = ""))
public class YourFirstAPI {

	Facade facade = Facade.getInstance();
	Proxy proxy = Proxy.getInstance();

	@ApiMethod(name = "obtenerReservas")
	public ArrayList<Reserva> reservas() {
		return facade.getReservas();
	}

	@ApiMethod(name = "obtenerUsuarios")
	public ArrayList<Usuario> obtenerUsuarios() {
		return facade.getUsuarios();
	}

	@ApiMethod(name = "quemarUsuarios")
	public void usuariosDummy() {
		facade.usuariosDummy();
	}

	@ApiMethod(name = "quemarReservas")
	public void reservasDummy() {
		facade.reservasDummy();
	}

	@ApiMethod(name = "iniciarSesion")
	public Aleatorio login(@Named("Correo") String correo, @Named("Password") String password) throws UnauthorizedException {
		Aleatorio aleatorio = proxy.iniciarSesion(correo, password);
		if (aleatorio.getCorreo() == null) {
			throw new UnauthorizedException("Invalid credentials");
		}
		Proxy proxy = Proxy.getInstance();
		return proxy.iniciarSesion(correo, password);
	}

	@ApiMethod(name = "ModificarReserva")
	public Reserva modificarReserva(@Named("NombreReserva") String nombreReserva, @Named("IDRutaReservada") int IDRutaReservada, 
			@Named("DocumentoPasajero") String documentoPasajero, Aleatorio aleatorio) throws UnauthorizedException {
		if (!facade.isSesion(aleatorio, documentoPasajero)) {
			throw new UnauthorizedException("Invalid credentials");
		}
		
		Reserva reservaModificada = facade.modificarReserva(nombreReserva, IDRutaReservada, documentoPasajero);
		
		if (reservaModificada == null) {
			throw new UnauthorizedException("Reserva no encontrada");
		}
		
		return reservaModificada;
	}
	
	@ApiMethod(name = "ConsultarReservas")
	public ArrayList<Reserva> consultarReservas(@Named("DocumentoPasajero") String documentoPasajero, Aleatorio aleatorio) throws UnauthorizedException {
		if (!facade.isSesion(aleatorio, documentoPasajero)) {
			throw new UnauthorizedException("Invalid credentials");
		}
		ArrayList<Reserva> reservasPasajero = facade.consultarReservas(documentoPasajero);
		if (reservasPasajero.isEmpty()) {
			throw new UnauthorizedException("Reservas no encontradas");
		}
		return reservasPasajero;
	}

}
