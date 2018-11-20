package com.reservas.entidades;

public class Reserva {
	
	private String nombreReserva;
	private int IDRutaReservada;
	private int documentosPasajero;
	
	public Reserva(String nombreReserva, int iDRutaReservada, int documentosPasajero) {
		this.nombreReserva = nombreReserva;
		IDRutaReservada = iDRutaReservada;
		this.documentosPasajero = documentosPasajero;
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

	public int getDocumentosPasajero() {
		return documentosPasajero;
	}

	public void setDocumentosPasajero(int documentosPasajero) {
		this.documentosPasajero = documentosPasajero;
	}
	
}
