package com.reservas.wheelU;

import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.reservas.entidades.Reserva;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "skeleton-api",
     version = "v1")
public class API {
	
	public static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	
	
	public ArrayList<Reserva> reservasDummy() {
		
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		reservas.add(new Reserva("Reserva1", 2, 1073525507));
		
		return null;
	}
	
}
