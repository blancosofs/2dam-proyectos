package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {
	public static void mostrar(Connection conexion) {
		try {
			String consulta = "SELECT * FROM venta";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados, tiene que coincidir con el sql !!
			while (resultado.next()) {
				int idVenta = resultado.getInt("idVenta");
				Date Fecha = resultado.getDate("Fecha");
				double Monto = resultado.getDouble("Monto");
				int idEmpleado = resultado.getInt("EMPLEADO_idEMPLEADO");
				int stock_idStand = resultado.getInt("stock_STAND_idStand");
				int stock_idZona = resultado.getInt("stock_STAND_ZONA_idzona");
				int idJuguete = resultado.getInt("stock_JUGUETE_idJuguete");

				System.out.println();
				System.out.println("idVenta: " + idVenta + ", Fecha: " + Fecha + ", Monto: " + Monto + ", idEmpleado: "
						+ idEmpleado + ", stock_idStand: " + stock_idStand + ", stock_idZona: " + stock_idZona
						+ ", idJuguete: " + idJuguete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarVenta(Connection conexion, Date fechaSQL, double monto, String tipoPago, int idEmpleadoV,
			int idStandV, int idZonaV, int idJugueteB, int cantidad) {
		try {

			String consultaInsert = "INSERT INTO venta VALUES (DEFAULT,?,?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consultaInsert);

			sentencia.setDate(1, fechaSQL);
			sentencia.setDouble(2, monto);
			sentencia.setString(3, tipoPago);
			sentencia.setInt(4, idEmpleadoV);
			sentencia.setInt(5, idStandV);
			sentencia.setInt(6, idZonaV);
			sentencia.setInt(7, idJugueteB);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("[info] Venta realizada ");
				mostrar(conexion);
			} else {
				System.err.println("[error] no se pudo vender");
			}

			// restar stock de una
			String consultaBorrarStock = "UPDATE stock SET CANTIDAD = CANTIDAD - ? WHERE STAND_idStand = ? AND STAND_ZONA_idzona = ? AND JUGUETE_idJuguete = ?";
			PreparedStatement sentenciaBorrar = conexion.prepareStatement(consultaBorrarStock);
			sentenciaBorrar.setInt(1, cantidad);
			sentenciaBorrar.setInt(2, idStandV);
			sentenciaBorrar.setInt(3, idZonaV);
			sentenciaBorrar.setInt(4, idJugueteB);

			sentenciaBorrar.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarStand(Connection conexion) {
		try {
			String consulta = "SELECT * FROM stand";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados, tiene que coincidir con el sql !!
			while (resultado.next()) {
				int idStand = resultado.getInt("idStand");
				String Nombre = resultado.getString("Nombre");
				String Descripcion = resultado.getString("Descripcion");
				int idZona = resultado.getInt("ZONA_idZona");

				System.out.println();
				System.out.println("idStand: " + idStand + ", Nombre: " + Nombre + ", Descripcion: " + Descripcion
						+ ", idZona: " + idZona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
