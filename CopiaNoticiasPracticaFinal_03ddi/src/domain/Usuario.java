package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Usuario {
	String id;
	String nombre;
	String pass;
	String email;
	String cargo;
	
	boolean loggeado;
	boolean preferencias;
	
	public Usuario() {}
	
	public Usuario(String id, String nombre, String pass, String email, String cargo, boolean loggeado,
			boolean preferencias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.cargo = cargo;
		this.loggeado = loggeado;
		this.preferencias = preferencias;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public boolean isLoggeado() {
		return loggeado;
	}

	public void setLoggeado(boolean loggeado) {
		this.loggeado = loggeado;
	}

	public boolean isPreferencias() {
		return preferencias;
	}

	public void setPreferencias(boolean preferencias) {
		this.preferencias = preferencias;
	}

	public void setCargo(String cargo) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("TXT/usuarios"));
			String linea;
			while ((linea = lector.readLine()) != null) {
				if (cargo.equals("*") || cargo.equals("#")) {
					this.cargo = cargo;
				} 
			}
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", email=" + email + ", cargo=" + cargo
				+ ", loggeado=" + loggeado + ", preferencias=" + preferencias + "]";
	}

	
}
