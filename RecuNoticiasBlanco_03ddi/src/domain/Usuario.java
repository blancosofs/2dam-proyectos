package domain;

import java.util.Arrays;

public class Usuario {
	String nombre;
	String pass;
	String email;
	String cargo;
	
	boolean loggeado;
	boolean preferencias;
	
	int[] noticiasTXT;
	
	public Usuario() {}

	public Usuario(String nombre, String pass, String email, String cargo, boolean loggeado, boolean preferencias,
			int[] noticiasTXT) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.cargo = cargo;
		this.loggeado = loggeado;
		this.preferencias = preferencias;
		this.noticiasTXT = noticiasTXT;
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

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public int[] getNoticiasTXT() {
		return noticiasTXT;
	}

	public void setNoticiasTXT(int[] noticiasTXT) {
		this.noticiasTXT = noticiasTXT;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", email=" + email + ", cargo=" + cargo + ", loggeado="
				+ loggeado + ", preferencias=" + preferencias + ", noticiasTXT=" + Arrays.toString(noticiasTXT) + "]";
	}
	
}
