package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
	public static void mostrar(Connection conexion) {

		try {
			String consulta = "SELECT * FROM empleado";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int idEmpleado = resultado.getInt("idEmpleado");
				String Nombre = resultado.getString("Nombre");
				String cargo = resultado.getString("Cargo");
				Date fecha_ingreso = resultado.getDate("Fecha_ingreso");
				
				System.out.println();
				System.out.println("idEmpleado: " + idEmpleado + ", Nombre: " + Nombre + ", Enum: " + cargo
						+ ", Fecha_ingreso: " + fecha_ingreso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarEmpleado(Connection conexion, int idEmpleado, String nombre, String cargo,
			Date fechaSQL) {
		try {
			String consulta = "INSERT INTO empleado VALUES (?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, idEmpleado);
			sentencia.setString(2, nombre);
			sentencia.setString(3, cargo);
			sentencia.setDate(4, fechaSQL);

			int resultado = sentencia.executeUpdate();

			if (resultado > 0) {
				System.out.println("---\nId Empleado:" + idEmpleado + " Nombre: " + nombre + " Cargo: " + cargo
						+ " Fecha_ingreso: " + fechaSQL + "\n-----");
			} else {

				System.out.println("No se pudo insertar el empleado");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void borrarEmpleado(Connection conexion, int idEmpleadoBorrar) {
		int lineas = 0;
		try {
			String consultaBorrado = "DELETE FROM empleado WHERE idEmpleado=?";
			PreparedStatement sentenciaBorrar = conexion.prepareStatement(consultaBorrado);
			sentenciaBorrar.setInt(1, idEmpleadoBorrar);

			lineas = sentenciaBorrar.executeUpdate();
			if (lineas > 0) {
				System.out.println("[info] Se ha borrado el empleado" + idEmpleadoBorrar);
			} else {
				System.err.println("[error] No se ha podido borrar el empleado con id: " + idEmpleadoBorrar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean buscarEmpleado(Connection conexion, int idEmpleadoBorrar) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM empleado WHERE idEmpleado = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idEmpleadoBorrar);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Empleado encontrado");
					return true;
				} else {
					System.err.println("[error] No encontrado empleado con id: " + idEmpleadoBorrar);
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean buscarEmpleadoModificar(Connection conexion, int idEmpleadoModificar) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM empleado WHERE idEmpleado = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idEmpleadoModificar);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Empleado encontrado");
					return true;
				} else {
					System.err.println("[error] No encontrado empleado con id: " + idEmpleadoModificar);
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
