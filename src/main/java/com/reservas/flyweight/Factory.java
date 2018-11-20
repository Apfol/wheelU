package com.reservas.flyweight;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.reservas.entidades.Usuario;


public class Factory {

	private HashMap usBasicInf = new HashMap();

	public void añadirUsuario(IUsuario usEspe) {

		if (!usBasicInf.containsKey(usEspe.getDocumento())) {
			usBasicInf.put(usEspe.getDocumento(), usEspe);
		} else {
			JOptionPane.showMessageDialog(null, "El usuario ya existe");
		}

	}

	public void cargarUsuarios(ArrayList<Usuario> usuarios) {
		this.usBasicInf.clear();
		for (IUsuario ius : usuarios) {
			this.añadirUsuario(ius);
		}
	}
}
