package domain;

import java.sql.Date;

public class Venta {
	int id;
	Date fecha;
	double monto;
	String tipoPago;
	int id_empleado;
	int id_stand;
	int id_zona;
	int id_juguete;
	
	public Venta() {}

	public Venta(int id, Date fecha, double monto, String tipoPago, int id_empleado, int id_stand, int id_zona,
			int id_juguete) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.tipoPago = tipoPago;
		this.id_empleado = id_empleado;
		this.id_stand = id_stand;
		this.id_zona = id_zona;
		this.id_juguete = id_juguete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getId_stand() {
		return id_stand;
	}

	public void setId_stand(int id_stand) {
		this.id_stand = id_stand;
	}

	public int getId_zona() {
		return id_zona;
	}

	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
	}

	public int getId_juguete() {
		return id_juguete;
	}

	public void setId_juguete(int id_juguete) {
		this.id_juguete = id_juguete;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", tipoPago=" + tipoPago + ", id_empleado="
				+ id_empleado + ", id_stand=" + id_stand + ", id_zona=" + id_zona + ", id_juguete=" + id_juguete + "]";
	}
	
}
