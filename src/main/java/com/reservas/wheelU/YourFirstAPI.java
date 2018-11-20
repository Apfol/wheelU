package com.reservas.wheelU;

import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.reservas.entidades.Reserva;
import com.reservas.facade.Facade;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "reservas", version = "v1", namespace = @ApiNamespace(ownerDomain = "wheelU.reservas.com", ownerName = "wheelU.reservas.com", packagePath = ""))
public class YourFirstAPI {
	
	
	Facade facade = Facade.getInstance();
	
	public static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	@ApiMethod(name = "devolverReservas")
	public ArrayList<Reserva> reservas() {
		return reservas;
	}
	
	@ApiMethod(name= "Quemar usuarios")
	public void usuariosDummy() {
		facade.usuariosDummy();
	}
	
	
	public void reservasDummy() {
		
		//ArrayList<Reserva> reservas = new ArrayList<>();
		
		reservas.add(new Reserva("Reserva1", 2, 1073525507));
	}
	
}
