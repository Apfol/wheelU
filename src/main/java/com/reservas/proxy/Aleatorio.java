package com.reservas.proxy;

public class Aleatorio {
	
	private String correo;
	private long aleatorio;
	
	public Aleatorio(String correo, long aleatorio) {
		super();
		this.correo = correo;
		this.aleatorio = aleatorio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getAleatorio() {
		return aleatorio;
	}

	public void setAleatorio(long aleatorio) {
		this.aleatorio = aleatorio;
	}
	
}
