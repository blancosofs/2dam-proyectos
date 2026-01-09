package dao;
import domain.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoDAO {
	
	//aqui te pillas el molde y le metes los datos
	public static ArrayList<Empleado> leerObjetoEmpleado(Connection conexion) {
		ArrayList<Empleado> empleadosArrayList = new ArrayList<>();
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
				Empleado e = new Empleado(idEmpleado, Nombre, cargo, fecha_ingreso);
				empleadosArrayList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleadosArrayList;
	}

	public static void insertarEmpleado(Connection conexion, String nombre, String cargo,
			LocalDate fechaSQL) {
		try {
			String consulta = "INSERT INTO empleado VALUES (DEFAULT,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setString(1, nombre);
			sentencia.setString(2, cargo);
			//cuidado
			//sentencia.setDate(3, java.sql.Date.valueOf(fechaSQL));
			sentencia.setDate(3, java.sql.Date.valueOf(fechaSQL));

			int resultado = sentencia.executeUpdate();

			if (resultado > 0) {
				System.out.println("---\nNombre: " + nombre + " Cargo: " + cargo
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

	public static boolean buscarEmpleadoModificar(Connection conexion, int idEmpleadoB) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM empleado WHERE idEmpleado = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idEmpleadoB);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Empleado encontrado");
					return true;
				} else {
					System.err.println("[error] No encontrado empleado con id: " + idEmpleadoB);
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void modificarEmpleado(Connection conexion, String nombreB, String cargoB, LocalDate fechaSQL2,int idEmpleadoB) {
		try {
			String consulta = "UPDATE empleado SET Nombre=?, Cargo=?, Fecha_ingreso=? WHERE idEmpleado=?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setString(1, nombreB);
			sentencia.setString(2, cargoB);
			sentencia.setDate(3, java.sql.Date.valueOf(fechaSQL2));
			sentencia.setInt(4, idEmpleadoB);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("---\nNombre: " + nombreB + " Cargo: " + cargoB
						+ " Fecha_ingreso: " + fechaSQL2 + "\n-----");
			} else {
				System.err.println("[error] No se puedo modificar Empleado con id" + idEmpleadoB);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
