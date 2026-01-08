package domain;

import java.sql.Date;

public class Empleado {
	int id;
	String nombre;
	String cargo;
	Date fechaIngreso;
	
	public Empleado() {}

	public Empleado(int id, String nombre, String cargo, Date fechaIngreso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaIngreso = fechaIngreso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaIngreso=" + fechaIngreso
				+ "]";
	}

}
