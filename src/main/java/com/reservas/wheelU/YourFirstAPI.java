package com.reservas.wheelU;

import java.util.ArrayList;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.NotFoundException;
import com.reservas.entidades.Reserva;
import com.reservas.entidades.Usuario;
import com.reservas.facade.Facade;
import com.reservas.proxy.Aleatorio;
import com.reservas.proxy.Proxy;

/**
 * Add your first API methods in this class, or you may create another class. In
 * that case, please update your web.xml accordingly.
 **/
@Api(name = "reservas", version = "v1", 
namespace = @ApiNamespace(ownerDomain = "wheelU.reservas.com", 
			ownerName = "wheelU.reservas.com", packagePath = ""))

public class YourFirstAPI {

	Facade facade = Facade.getInstance();
	Proxy proxy = Proxy.getInstance();

	@ApiMethod(name = "obtener_reservas", httpMethod = ApiMethod.HttpMethod.GET)
	public ArrayList<Reserva> reservas() {
		return facade.getReservas();
	}

	@ApiMethod(name = "obtener_usuarios", httpMethod = ApiMethod.HttpMethod.GET)
	public ArrayList<Usuario> obtenerUsuarios() {
		return facade.getUsuarios();
	}

	@ApiMethod(name = "quemar_usuarios")
	public void usuariosDummy() {
		facade.usuariosDummy();
	}

	@ApiMethod(name = "quemar_reservas")
	public void reservasDummy() {
		facade.reservasDummy();
	}

	@ApiMethod(name = "iniciar_sesion", httpMethod = ApiMethod.HttpMethod.GET)
	public Aleatorio login(@Named("correo") String correo, @Named("password") String password)
			throws ForbiddenException {
		Aleatorio aleatorio = proxy.iniciarSesion(correo, password);
		if (aleatorio.getAleatorio().equals("0")) {
			throw new ForbiddenException("Invalid credentials");
		}
		Proxy proxy = Proxy.getInstance();
		return proxy.iniciarSesion(correo, password);
	}

	@ApiMethod(name = "modificar_reserva", httpMethod = ApiMethod.HttpMethod.PUT)
	public Reserva modificarReserva(@Named("nombreReservaModificar") String nombreReserva,
			@Named("IDRutaReservada") String IDRutaReservada, @Named("documentoPasajero") String documentoPasajero,
			Aleatorio aleatorio) throws ServiceException {
		if (!facade.isSesion(aleatorio, documentoPasajero)) {
			throw new ForbiddenException("Invalid credentials");
		}

		Reserva reservaModificada = facade.modificarReserva(nombreReserva, IDRutaReservada, documentoPasajero);

		if (reservaModificada == null) {
			throw new NotFoundException("Reserva no encontrada");
		}

		return reservaModificada;
	}

	@ApiMethod(name = "consultar_reservas", httpMethod = ApiMethod.HttpMethod.GET)
	public ArrayList<Reserva> consultarReservas(@Named("documentoPasajero") String documentoPasajero,
			Aleatorio aleatorio) throws ServiceException {
		if (!facade.isSesion(aleatorio, documentoPasajero)) {
			throw new ForbiddenException("Invalid credentials");
		}
		ArrayList<Reserva> reservasPasajero = facade.consultarReservas(documentoPasajero);
		if (reservasPasajero.isEmpty()) {
			throw new NotFoundException("Reservas no encontradas");
		}
		return reservasPasajero;
	}
	
	
	@ApiMethod(name = "crear_reserva", httpMethod = ApiMethod.HttpMethod.POST)
	public Reserva crearReserva(@Named("nombreReserva") String nombreReserva,
			@Named("IDRutaReservada") String IDRutaReservada, @Named("documentoPasajero") String documentoPasajero,
			Aleatorio aleatorio) throws ServiceException{
		if (!facade.isSesion(aleatorio, documentoPasajero)) {
			throw new ForbiddenException("Invalid credentials");
		}

		Reserva reserva =new Reserva(nombreReserva, IDRutaReservada, documentoPasajero);
		facade.addReserva(reserva);

		return reserva;		
	}
	@ApiMethod(name = "eliminar_reserva", httpMethod = ApiMethod.HttpMethod.DELETE)
	public void eliminarReserva(@Named("IdRuta") String idRuta,@Named("DocPasajero") String docPasa) throws ServiceException {
		
		facade.eliminarReserva(idRuta, docPasa);
	}
	
	@ApiMethod(name = "obtener_usuario")
	public Usuario obtenerUsuario(@Named("documento") String documento, Aleatorio aleatorio) throws ForbiddenException {
		if (!facade.isSesion(aleatorio, documento)) {
			throw new ForbiddenException("Invalid credentials");
		}
		return facade.obtenerUsuario(documento);
	}

}
