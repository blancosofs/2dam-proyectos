package db4o_ejemplo;

public class Estudiantes {
	int id;
	String nombre;
	int edad;
	double notaFinal;
	
	public Estudiantes() {}
	
	public Estudiantes(int id, String nombre, int edad, double notaFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.notaFinal = notaFinal;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	@Override
	public String toString() {
		return "Estudiantes [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", notaFinal=" + notaFinal + "]";
	}
	
}
