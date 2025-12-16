package db4o_ejemplo;

public class Estudiantes {
	String nombre;
	int id;
	double notaFinal;
	
	
	public Estudiantes(String nombre, int id, double notaFinal) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.notaFinal = notaFinal;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
}
