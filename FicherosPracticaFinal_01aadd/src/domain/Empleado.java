package domain;

import java.io.Serializable;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empleado implements Serializable{
	int identificacion;
	String nombre;
	String password;
	String cargo;

	public Empleado() {
	};

	public Empleado(int identificacion, String nombre, String password, String cargo) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.password = password;
		this.cargo = cargo;
	}

	public int generarId() {
		Random rand = new Random();
		identificacion = rand.nextInt(9000) + 1000;
		return identificacion;
	}

	public static boolean validarPassword(String pwd) {
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{5,7}$");
		Matcher matcher = pattern.matcher(pwd);

		if (matcher.find()) {
			System.out.println("Contraseña valida :) ");
			return true;
		} else {
			System.out.println("Contraseña invalida :( ");
			return false;
		}
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!validarPassword(password)) {
			System.err.println("no valido");
		} else {
			this.password = password;
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		cargo = cargo.trim().toLowerCase();
		if (cargo.equals("vendedor") || cargo.equals("gestor")) {
			this.cargo = cargo;
		} else {
			System.err.println("cargo no valido");
		}
	}

	@Override
	public String toString() {
		//lo del zerofill
		return String.format("Empleado [identificacion=%04d, nombre=%s, contrasena=%s cargo=%s ]",identificacion,nombre,password,cargo);
	}

}
