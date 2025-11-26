package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControlErrores {
	public static boolean comprobarJuguetesVacio(Connection conexion) {
		try {
			String consulta = "SELECT COUNT(*) FROM juguete ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); //primera columna
				if (nFilas != 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean comprobarEmpleadosVacio(Connection conexion) {
		try {
			String consulta = "SELECT COUNT(*) FROM empleado ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); //primera columna
				if (nFilas != 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
