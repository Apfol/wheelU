package com.reservas.proxy;

public interface IProxy {
	void crearPasajero(String nombre, String correo, String contrasena, String edad, String tipo);
	void crearConductor(String nombre, String correo, String contrasena, String edad, String tipo);
	void crearAdministrador(String nombre, String correo, String contrasena, String edad, String tipo);
	long iniciarSesion(String correo, String contrasena);
}
