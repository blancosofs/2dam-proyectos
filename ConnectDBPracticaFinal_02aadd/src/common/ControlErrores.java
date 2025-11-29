package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControlErrores {
	// true == vacio
	public static boolean comprobarJuguetesVacio(Connection conexion) {
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM juguete ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					return vacio = true;
				} else {
					System.out.println("[info] Total de filas en juguete: " + nFilas);
					return vacio = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	public static boolean comprobarEmpleadosVacio(Connection conexion) {
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM empleado ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					return vacio = true;
				} else {
					System.out.println("[info] Total de filas en empleado: " + nFilas);
					return vacio = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	public static void insertarJuguetesVacio(Connection conexion) {
		try {
			String insert = "INSERT INTO juguete (idJuguete,Nombre,Descripcion,Precio,Cantidad_stock) VALUES (1,'nombre1','descripcion1',1.5,12) ,\n"
					+ "(2,'nombre2','descripcion2',5.0,12) ,\n" + "(3,'nombre3','descripcion3',21.5,19) ,\n"
					+ "(4,'nombre4','descripcion4',17.4,11) ,\n" + "(5,'nombre5','descripcion5',10.2,11) ,\n"
					+ "(6,'nombre6','descripcion6',11.6,8) ,\n" + "(7,'nombre7','descripcion7',17.4,19) ,\n"
					+ "(8,'nombre8','descripcion8',6.8,4) ,\n" + "(9,'nombre9','descripcion9',7.1,6) ,\n"
					+ "(10,'nombre10','descripcion10',12.0,19) ,\n" + "(11,'nombre11','descripcion11',5.0,5) ,\n"
					+ "(12,'nombre12','descripcion12',2.3,7) ,\n" + "(13,'nombre13','descripcion13',18.2,19) ,\n"
					+ "(14,'nombre14','descripcion14',4.7,5) ,\n" + "(15,'nombre15','descripcion15',18.2,5) ,\n"
					+ "(16,'nombre16','descripcion16',21.5,15) ,\n" + "(17,'nombre17','descripcion17',6.8,10) ,\n"
					+ "(18,'nombre18','descripcion18',18.2,9) ,\n" + "(19,'nombre19','descripcion19',20.1,1) ,\n"
					+ "(20,'nombre20','descripcion20',14.8,12);";
			PreparedStatement sentencia = conexion.prepareStatement(insert);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					System.out.println("[info] Total de filas creadas en juguete: " + nFilas);
				} else {
					System.err.println("[error] No se puedo realizar el insert de juguete");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void insertarEmpleadosVacio(Connection conexion) {
		try {
			String insert = "INSERT INTO empleado (idEmpleado,Nombre,Cargo,Fecha_ingreso) VALUES ( DEFAULT,'nombre1','cajero',NULL) ,\n"
					+ "( DEFAULT,'nombre2','cajero',NULL) ,\n" + "( DEFAULT,'nombre3','jefe',NULL) ,\n"
					+ "( DEFAULT,'nombre4','cajero',NULL) ,\n" + "( DEFAULT,'nombre5','jefe',NULL) ,\n"
					+ "( DEFAULT,'nombre6','cajero',NULL) ,\n" + "( DEFAULT,'nombre7','cajero',NULL) ,\n"
					+ "( DEFAULT,'nombre8','cajero',NULL) ,\n" + "( DEFAULT,'nombre9','jefe',NULL) ,\n"
					+ "( DEFAULT,'nombre10','jefe',NULL) ,\n" + "( DEFAULT,'nombre11','jefe',NULL) ,\n"
					+ "( DEFAULT,'nombre12','jefe',NULL) ,\n" + "( DEFAULT,'nombre13','cajero',NULL) ,\n"
					+ "( DEFAULT,'nombre14','cajero',NULL) ,\n" + "( DEFAULT,'nombre15','cajero',NULL) ,\n"
					+ "( DEFAULT,'nombre16','cajero',NULL) ,\n" + "( DEFAULT,'nombre17','jefe',NULL) ,\n"
					+ "( DEFAULT,'nombre18','cajero',NULL) ,\n" + "( DEFAULT,'nombre19','cajero',NULL) ,\n"
					+ "( DEFAULT,'nombre20','jefe',NULL);";
			PreparedStatement sentencia = conexion.prepareStatement(insert);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					System.out.println("[info] Total de filas creadas en empleado: " + nFilas);
				} else {
					System.err.println("[error] No se puedo realizar el insert de empleado");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
