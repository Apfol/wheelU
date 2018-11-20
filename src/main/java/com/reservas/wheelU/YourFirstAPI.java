package com.reservas.wheelU;

import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.reservas.entidades.Reserva;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "reservas", version = "v1", namespace = @ApiNamespace(ownerDomain = "wheelU.reservas.com", ownerName = "wheelU.reservas.com", packagePath = ""))
public class YourFirstAPI {
	
	public static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	
	@ApiMethod(name = "reserva")
	public ArrayList<Reserva> reservasDummy() {
		
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		reservas.add(new Reserva("Reserva1", 2, 1073525507));
		
		return reservas;
	}
	
}
