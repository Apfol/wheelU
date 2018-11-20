package com.reservas.entidades;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Pasajero extends Usuario{
	
	public Pasajero(String nombre, String correo, String contrasena, String documento) {
        super(nombre, correo, contrasena, documento);
    }

    public Pasajero() {
    
    }

    @Override
    public void consultar() {
    	String datosUsuarios = "";
        ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us: usuarios) {
            if(us instanceof Pasajero) {
                datosUsuarios += us.getNombre() + " " + us.getCorreo() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, datosUsuarios);
    }

    @Override
    public void eliminar(String correo) {
    	ArrayList<Usuario> usuarios = this.getUsuarios();
        for (Usuario us : usuarios) {
            if (us.getCorreo().equals(correo)) {
                usuarios.remove(us);
            }
        }
    }
}
