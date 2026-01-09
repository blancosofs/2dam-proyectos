package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import domain.Cambio;
import domain.Venta;

public class VentaDAO {

	public static ArrayList<Venta> mostrar(Connection conexion) {
		ArrayList<Venta> ventasArrayList = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM venta";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados, tiene que coincidir con el sql !!
			while (resultado.next()) {
				int idVenta = resultado.getInt("idVenta");
				Date Fecha = resultado.getDate("Fecha");
				double Monto = resultado.getDouble("Monto");
				String tipo_pago = resultado.getString("tipo_pago");
				int idEmpleado = resultado.getInt("EMPLEADO_idEMPLEADO");
				int stock_idStand = resultado.getInt("stock_STAND_idStand");
				int stock_idZona = resultado.getInt("stock_STAND_ZONA_idzona");
				int idJuguete = resultado.getInt("stock_JUGUETE_idJuguete");

				Venta v = new Venta(idVenta, Fecha, Monto, tipo_pago, idEmpleado, stock_idStand, stock_idZona,
						idJuguete);
				ventasArrayList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventasArrayList;

	}

	public static void insertarVenta(Connection conexion, LocalDate fechaSQL, double monto, String tipoPago,
			int idEmpleadoV, int idStandV, int idZonaV, int idJugueteB, int cantidad) {
		try {

			String consultaInsert = "INSERT INTO venta VALUES (DEFAULT,?,?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consultaInsert);

			sentencia.setDate(1, java.sql.Date.valueOf(fechaSQL));
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

	public static void mostrarStock(Connection conexion, int idStandV, int idJugueteB) {
		try {
			String consulta = "SELECT * from stock WHERE STAND_idStand = ? AND JUGUETE_idJuguete =?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idStandV);
			sentencia.setInt(2, idJugueteB);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				int idS = resultado.getInt("STAND_idStand");
				int idZ = resultado.getInt("STAND_ZONA_idzona");
				int idJ = resultado.getInt("JUGUETE_idJuguete");
				int cant = resultado.getInt("CANTIDAD");

				System.out.println();
				System.out.println("idZona: " + idZ + ", idStand: " + idS + "   <->  " + ", idJuguete: " + idJ
						+ ", Cantidad: " + cant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarStock1(Connection conexion, int idJugueteB) {
		try {
			String consulta = "SELECT * from stock WHERE JUGUETE_idJuguete =?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idJugueteB);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				int idS = resultado.getInt("STAND_idStand");
				int idZ = resultado.getInt("STAND_ZONA_idzona");
				int idJ = resultado.getInt("JUGUETE_idJuguete");
				int cant = resultado.getInt("CANTIDAD");

				System.out.println();
				System.out.println("idZona: " + idZ + ", idStand: " + idS + "   <->  " + ", idJuguete: " + idJ
						+ ", Cantidad: " + cant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void productoMasVendido(Connection conexion) {
		try {
			String consulta = "select j.Nombre as NombreJuguete, COUNT(v.idventa) AS TotalVentas FROM venta v JOIN juguete j ON v.stock_JUGUETE_idJuguete = j.idJuguete GROUP BY v.stock_JUGUETE_idJuguete ORDER BY TotalVentas limit 1;";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				String NombreJuguete = resultado.getString("NombreJuguete");
				String TotalVentas = resultado.getString("TotalVentas");

				System.out.println();
				System.out.println("Nombre Juguete: " + NombreJuguete + ", Total Ventas: " + TotalVentas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void empleadosMasVenden(Connection conexion) {
		try {
			String consulta = "select e.nombre as NombreEmpleado, COUNT(v.idventa) as TotalVentas from venta v join empleado e on v.EMPLEADO_idEMPLEADO = e.idEmpleado group by v.EMPLEADO_idEMPLEADO order by TotalVentas limit 1;";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				String NombreEmpleado = resultado.getString("NombreEmpleado");
				String TotalVentas = resultado.getString("TotalVentas");

				System.out.println();
				System.out.println("Nombre Empleado: " + NombreEmpleado + ", Total Ventas: " + TotalVentas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean buscarVenta(Connection conexion, int idVentaC) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM venta WHERE idventa = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idVentaC);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Venta encontrada");
					return true;
				} else {
					System.err.println("[error] Venta con el id pedido no encontrado");
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Cambio> mostrarCambio(Connection conexion) {
		ArrayList<Cambio> cambiosArrayList = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM cambio";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados, tiene que coincidir con el sql !!
			while (resultado.next()) {
				int idCAMBIO = resultado.getInt("idCAMBIO");
				String MOTIVO = resultado.getString("MOTIVO");
				Date Fecha = resultado.getDate("Fecha");
				int STOCK_STAND_idStand_Original = resultado.getInt("STOCK_STAND_idStand_Original");
				int STOCK_STAND_ZONA_idzona_Original = resultado.getInt("STOCK_STAND_ZONA_idzona_Original");
				int STOCK_JUGUETE_idJuguete_Original = resultado.getInt("STOCK_JUGUETE_idJuguete_Original");
				int STOCK_STAND_idStand_Nuevo = resultado.getInt("STOCK_STAND_idStand_Nuevo");
				int STOCK_STAND_ZONA_idzona_Nuevo = resultado.getInt("STOCK_STAND_ZONA_idzona_Nuevo");
				int STOCK_JUGUETE_idJuguete_Nuevo = resultado.getInt("STOCK_JUGUETE_idJuguete_Nuevo");
				int EMPLEADO_idEMPLEADO = resultado.getInt("EMPLEADO_idEMPLEADO");

				Cambio c = new Cambio(idCAMBIO, MOTIVO, Fecha, STOCK_STAND_idStand_Original,
						STOCK_STAND_ZONA_idzona_Original, STOCK_JUGUETE_idJuguete_Original, STOCK_STAND_idStand_Nuevo,
						STOCK_STAND_ZONA_idzona_Nuevo, STOCK_JUGUETE_idJuguete_Nuevo, EMPLEADO_idEMPLEADO);
				cambiosArrayList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cambiosArrayList;

	}

	public static boolean buscarEmpleado(Connection conexion, int idEmpleadoC) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM venta WHERE EMPLEADO_idEMPLEADO = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idEmpleadoC);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Empleado encontrado");
					return true;
				} else {
					System.err.println("[error] No encontrado en la venta el empleado con id: " + idEmpleadoC);
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void insertarCambio(Connection conexion, String motivo, LocalDate fechaSQL, int idEmpleadoC) {
		try {

			String consultaInsert = "INSERT INTO cambio VALUES (DEFAULT,?,?,NULL,NULL,NULL,NULL,NULL,NULL,?);";
			PreparedStatement sentencia = conexion.prepareStatement(consultaInsert);

			sentencia.setString(1, motivo);
			sentencia.setDate(2, java.sql.Date.valueOf(fechaSQL));
			sentencia.setInt(3, idEmpleadoC);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("[info] Cambio realizado ");
				mostrar(conexion);
			} else {
				System.err.println("[error] no se pudo cambiar");
			}
			// sumar stock de una con un upadate [por implementar]

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
