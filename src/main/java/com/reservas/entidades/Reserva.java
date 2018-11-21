package com.reservas.entidades;

public class Reserva {
	
	private String nombreReserva;
	private String IDRutaReservada;
	private String correoPasajero;
	
	public Reserva(String nombreReserva, String iDRutaReservada, String documentoPasajero) {
		super();
		this.nombreReserva = nombreReserva;
		this.IDRutaReservada = iDRutaReservada;
		this.correoPasajero = documentoPasajero;
	}
	public String getNombreReserva() {
		return nombreReserva;
	}
	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}
	public String getIDRutaReservada() {
		return IDRutaReservada;
	}
	public void setIDRutaReservada(String iDRutaReservada) {
		this.IDRutaReservada = iDRutaReservada;
	}
	public String getDocumentoPasajero() {
		return correoPasajero;
	}
	public void setDocumentoPasajero(String documentoPasajero) {
		this.correoPasajero = documentoPasajero;
	}
	
}
