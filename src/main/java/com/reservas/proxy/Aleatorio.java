package com.reservas.proxy;

public class Aleatorio {
	
	private String documento;
	private String aleatorio;
	
	public Aleatorio() {
		
	}
	
	public Aleatorio(String correo, String aleatorio) {
		this.documento = correo;
		this.aleatorio = aleatorio;
	}

	public String getCorreo() {
		return documento;
	}

	public void setCorreo(String correo) {
		this.documento = correo;
	}

	public String getAleatorio() {
		return aleatorio;
	}

	public void setAleatorio(String aleatorio) {
		this.aleatorio = aleatorio;
	}
	
}
