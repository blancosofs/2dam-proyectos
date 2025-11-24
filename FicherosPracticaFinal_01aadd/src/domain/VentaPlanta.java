package domain;

public class VentaPlanta {
	int codigoProducto;
	float precioUnidad;
	int cantidad;
	
	public VentaPlanta() {}
	
	public VentaPlanta(int codigoProducto, float precioUnidad, int cantidad) {
		super();
		this.codigoProducto = codigoProducto;
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "VentaPlanta [codigoProducto=" + codigoProducto + ", precioUnidad=" + precioUnidad + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
