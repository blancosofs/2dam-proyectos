package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ticket {
   
	public static int contador = 1;
	
	int numTicket;

	int codigoEmpleado;

	String nombreEmpleado;

	LocalDate fechaVenta;

	ArrayList<VentaPlanta> ventaPlanta; // porque compras varias plantas, por eso array list y no clase de una

	float totalVenta;

	boolean devolucion;

	public Ticket() {
		// si no empiezas se va a nullpointer
		this.ventaPlanta = new ArrayList<>();
	}

	public Ticket(int codigoEmpleado, String nombreEmpleado, LocalDate fechaVenta,
			ArrayList<VentaPlanta> ventaPlanta, float totalVenta, boolean devolucion) {
		super();
		this.numTicket = contador++;
		this.codigoEmpleado = codigoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.fechaVenta = fechaVenta;
		this.ventaPlanta = ventaPlanta;
		this.totalVenta = totalVenta;
		this.devolucion = devolucion;
	}

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

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
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