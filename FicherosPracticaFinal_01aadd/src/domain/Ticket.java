package domain;

import java.util.ArrayList;

public class Ticket {
	
	public Ticket() {
		// si no empiezas se va a nullpointer
	    this.ventaPlanta = new ArrayList<>();
	}

	public Ticket(int numTicket, int codigoEmpleado, String nombreEmpleado, String fechaVenta,
			ArrayList<VentaPlanta> ventaPlanta, float totalVenta, boolean devolucion) {
		super();
		this.numTicket = numTicket;
		this.codigoEmpleado = codigoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.fechaVenta = fechaVenta;
		this.ventaPlanta = ventaPlanta;
		this.totalVenta = totalVenta;
		this.devolucion = devolucion;
	}

	int numTicket;
	
	int codigoEmpleado;
	String nombreEmpleado;
	
	String fechaVenta;

	ArrayList<VentaPlanta> ventaPlanta; //porque compras varias plantas, por eso array list y no clase de una

	float totalVenta;

	boolean devolucion;

	public int getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(int numTicket) {
		this.numTicket = numTicket;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public ArrayList<VentaPlanta> getVentaPlanta() {
		return ventaPlanta;
	}

	public void setVentaPlanta(ArrayList<VentaPlanta> ventaPlanta) {
		this.ventaPlanta = ventaPlanta;
	}

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}

	public boolean isDevolucion() {
		return devolucion;
	}

	public void setDevolucion(boolean devolucion) {
		this.devolucion = devolucion;
	}

	@Override
	public String toString() {
		return "Ticket [numTicket=" + numTicket + ", codigoEmpleado=" + codigoEmpleado + ", nombreEmpleado="
				+ nombreEmpleado + ", fechaVenta=" + fechaVenta + ", ventaPlanta=" + ventaPlanta + ", totalVenta="
				+ totalVenta + ", devolucion=" + devolucion + "]";
	}
	
	

}