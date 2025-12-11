package domain;

public class Usuario {
	String id;
	String nombre;
	String pass;
	String email;
	
	public Usuario() {}
	
	public Usuario(String id, String nombre, String pass, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", email=" + email + "]";
	}
	
	
}
