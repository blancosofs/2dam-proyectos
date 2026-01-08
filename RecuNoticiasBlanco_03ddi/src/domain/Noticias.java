package domain;

public class Noticias {
	String id;
	String nombre;
	String url;
	String css;
	
	public Noticias() {}
	
	public Noticias(String id, String nombre, String url, String css) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.css = css;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return "Noticias [id=" + id + ", nombre=" + nombre + ", url=" + url + ", css=" + css + "]";
	}
	
	
		
}
