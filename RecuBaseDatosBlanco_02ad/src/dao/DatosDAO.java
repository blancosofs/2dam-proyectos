package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosDAO {
	public static void mostrarPorPrecio(Connection conexion) {
		try {
			String consulta = "SELECT * FROM juguete ORDER BY Precio DESC";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				int idJuguete = resultado.getInt("idJuguete");
				String Nombre = resultado.getString("Nombre");
				String Descripcion = resultado.getString("Descripcion");
				Double Precio = resultado.getDouble("Precio");
				int Cantidad_stock = resultado.getInt("cantidad_stock");
				System.out.println();
				System.out.println("idJuguete: " + idJuguete + ", Nombre: " + Nombre + ", Descripcion: " + Descripcion
						+ ", Precio: " + Precio + ", Cantidad_stock: " + Cantidad_stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void mostrarStock(Connection conexion) {
		try {
			String consulta = "SELECT s.STAND_idStand AS idStand,sd.ZONA_idZona AS idZona, j.idJuguete AS idJuguete, s.CANTIDAD AS Cantidad FROM stock s\n"
					+ "JOIN stand sd ON s.STAND_idStand = sd.idStand AND s.STAND_ZONA_idZona = sd.ZONA_idZona JOIN juguete j ON s.JUGUETE_idJuguete = j.idJuguete\n"
					+ "ORDER BY idStand, idJuguete";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				int idS = resultado.getInt("idStand");
				int idZ = resultado.getInt("idZona");
				int idJ = resultado.getInt("idJuguete");
				int cant = resultado.getInt("Cantidad");

				System.out.println();
				System.out.println("iZona: " + idZ + ", idStand: " + idS + "<->" + ", idJuguete: " + idJ + ", Cantidad: " + cant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void datosMes(Connection conexion) {
		try {
			String consulta = "SELECT MONTH(Fecha) AS Mes, COUNT(*) AS NumVentas, SUM(Monto) AS Total FROM venta GROUP BY MONTH(Fecha) ORDER BY Mes";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				int mes = resultado.getInt("Mes");
				int numV = resultado.getInt("NumVentas");
				int total = resultado.getInt("Total");

				System.out.println();
				System.out.println("Mes: " + mes + ", NumVentas: " + numV + ", Total: " + total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void datosEmpleado(Connection conexion) {
		try {
			String consulta = "SELECT EMPLEADO_idEMPLEADO, MOTIVO FROM cambio;";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();
			
			while (resultado.next()) {
				String MOTIVO = resultado.getString("MOTIVO");
				int EMPLEADO_idEMPLEADO = resultado.getInt("EMPLEADO_idEMPLEADO");

				System.out.println();
				System.out.println("Empleado: " + EMPLEADO_idEMPLEADO + ", Motivo devolucion:: " + MOTIVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
