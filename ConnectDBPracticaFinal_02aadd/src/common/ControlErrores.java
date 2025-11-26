package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControlErrores {
	//true == vacio
	public static boolean comprobarJuguetesVacio(Connection conexion) {
		boolean vacio = true; //vacio
		try {
			String consulta = "SELECT COUNT(*) FROM juguete ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); //primera columna
				if (nFilas <= 0) {
					return vacio=true;
				} else {
					System.out.println("Total de filas en juguete: "+nFilas);
					insertarJuguetesVacio(conexion);
					return vacio=false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	public static boolean comprobarEmpleadosVacio(Connection conexion) {
		boolean vacio = true; //vacio
		try {
			String consulta = "SELECT COUNT(*) FROM empleado ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); //primera columna
				if (nFilas != 0) {
					return vacio=true;
				} else {
					System.out.println("Total de filas en juguete: "+nFilas);
					insertarEmpleadosVacio(conexion);
					return vacio=false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}
	
	public static void insertarJuguetesVacio(Connection conexion) {
		

		
	}
	
	public static void insertarEmpleadosVacio(Connection conexion) {
	}
}
