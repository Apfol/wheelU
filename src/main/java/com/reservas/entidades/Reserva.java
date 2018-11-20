package com.reservas.entidades;

public class Reserva {
	
	private String nombreReserva;
	private int IDRutaReservada;
	private String documentoPasajero;
	
	public Reserva(String nombreReserva, int iDRutaReservada, String documentoPasajero) {
		super();
		this.nombreReserva = nombreReserva;
		IDRutaReservada = iDRutaReservada;
		this.documentoPasajero = documentoPasajero;
	}
	public String getNombreReserva() {
		return nombreReserva;
	}
	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}
	public int getIDRutaReservada() {
		return IDRutaReservada;
	}
	public void setIDRutaReservada(int iDRutaReservada) {
		IDRutaReservada = iDRutaReservada;
	}
	public String getDocumentoPasajero() {
		return documentoPasajero;
	}
	public void setDocumentoPasajero(String documentoPasajero) {
		this.documentoPasajero = documentoPasajero;
	}
	
}
