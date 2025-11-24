package domain;

public class Planta {
	int codigo;
	String nombre;
	String foto;
	String descripcion;

	Float precio;
	int stock;

	//para crear algo de 0 por si acaso
	public Planta() {};
	
	//completo
	public Planta(int codigo, String nombre, String foto, String descripcion, Float precio, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	// para el xml
	public Planta(int codigo, String nombre, String foto, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", nombre=" + nombre + ", foto=" + foto + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + "]";
	}

}
