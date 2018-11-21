package com.reservas.entidades;

public class Reserva {
	
	private String nombreReserva;
	private String IDRutaReservada;
	private String documentoPasajero;
	
	public Reserva(String nombreReserva, String iDRutaReservada, String documentoPasajero) {
		super();
		this.nombreReserva = nombreReserva;
		this.IDRutaReservada = iDRutaReservada;
		this.documentoPasajero = documentoPasajero;
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
		return documentoPasajero;
	}
	public void setDocumentoPasajero(String documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}
	
}
