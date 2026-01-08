package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ControlErrores {

	// control E/S
	public static String controlErroresCargo(Scanner sc) {
		boolean error = true;
	    String dato = "";
	    do {
	        dato = sc.nextLine().trim().toLowerCase();
	        if (dato.equals("jefe") || dato.equals("cajero")) {
	            error = false;
	        } else {
	            System.err.println("[error] Cargo inválido (cajero / jefe)");
	        }
	    } while (error);
	    return dato;
	}

	public static int controlErroresInt(Scanner sc) {
		boolean error = true;
		int dato = 0;
		do {
			if (sc.hasNextInt()) {
				dato = sc.nextInt();
				if (dato >= 0) {
					error = false;
				}else {
					System.err.println("ERROR. Tiene que ser un numero mayor a 0");
				}
			} else {
				System.err.println("ERROR. Tiene que ser un numero (int)");
			}
			sc.nextLine();
		} while (error);
		return dato;
	}

	public static double controlErroresDouble(Scanner sc) {
		boolean error = true;
		double datoD = 0;
		do {
			if (sc.hasNextDouble()) {
				datoD = sc.nextDouble();
				error = false;
			} else {
				System.err.println("ERROR. Tiene que ser double");
			}
			sc.nextLine();
		} while (error);
		return datoD;
	}

	public static String controlErroresPago(Scanner sc) {
		boolean error = true;
	    String dato = "";
	    do {
	        dato = sc.nextLine().trim().toLowerCase();
	        if (dato.equals("efectivo") || dato.equals("tarjeta")|| dato.equals("paypal")) {
	            error = false;
	        } else {
	            System.err.println("[error] Pago inválido (efectivo / tarjeta / paypal)");
	        }
	    } while (error);
	    return dato;
	}

	/* COMPROBAR: */
	// true == vacio
	public static boolean comprobarJuguetesVacio(Connection conexion) {
		// System.out.println("[llegas?]");
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM juguete ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					// System.out.println("2[llegas?]");
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

	public static boolean comprobarZonaVacio(Connection conexion) {
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM zona ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					return vacio = true;
				} else {
					System.out.println("[info] Total de filas en zona: " + nFilas);
					return vacio = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	public static boolean comprobarStandVacio(Connection conexion) {
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM stand ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					//System.out.println("STAND[llegas]");
					return vacio = true;
				} else {
					System.out.println("[info] Total de filas en stand: " + nFilas);
					return vacio = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	public static boolean comprobarStockVacio(Connection conexion) {
		//System.out.println("2[llegas]");
		boolean vacio = true; // vacio
		try {
			String consulta = "SELECT COUNT(*) FROM stock ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int nFilas = resultado.getInt(1); // primera columna
				if (nFilas <= 0) { // condicion para que vaya vacio!
					//System.out.println("3[llegas]");
					return vacio = true;
				} else {
					System.out.println("[info] Total de filas en stock: " + nFilas);
					return vacio = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacio;
	}

	/* INSERTS: */
	public static void insertarJuguetesVacio(Connection conexion) {
		// System.out.println("[llegas?]");
		try {
			String insert = "INSERT INTO juguete (idJuguete,Nombre,Descripcion,Precio,Cantidad_stock) VALUES (DEFAULT,'nombre1','descripcion1',1.5,12) ,\n"
					+ "(DEFAULT,'nombre2','descripcion2',5.0,12) ,\n" + "(DEFAULT,'nombre3','descripcion3',21.5,19) ,\n"
					+ "(DEFAULT,'nombre4','descripcion4',17.4,11) ,\n"
					+ "(DEFAULT,'nombre5','descripcion5',10.2,11) ,\n" + "(DEFAULT,'nombre6','descripcion6',11.6,8) ,\n"
					+ "(DEFAULT,'nombre7','descripcion7',17.4,19) ,\n" + "(DEFAULT,'nombre8','descripcion8',6.8,4) ,\n"
					+ "(DEFAULT,'nombre9','descripcion9',7.1,6) ,\n"
					+ "(DEFAULT,'nombre10','descripcion10',12.0,19) ,\n"
					+ "(DEFAULT,'nombre11','descripcion11',5.0,5) ,\n"
					+ "(DEFAULT,'nombre12','descripcion12',2.3,7) ,\n"
					+ "(DEFAULT,'nombre13','descripcion13',18.2,19) ,\n"
					+ "(DEFAULT,'nombre14','descripcion14',4.7,5) ,\n"
					+ "(DEFAULT,'nombre15','descripcion15',18.2,5) ,\n"
					+ "(DEFAULT,'nombre16','descripcion16',21.5,15) ,\n"
					+ "(DEFAULT,'nombre17','descripcion17',6.8,10) ,\n"
					+ "(DEFAULT,'nombre18','descripcion18',18.2,9) ,\n"
					+ "(DEFAULT,'nombre19','descripcion19',20.1,1) ,\n"
					+ "(DEFAULT,'nombre20','descripcion20',14.8,12);";
			PreparedStatement sentencia = conexion.prepareStatement(insert);

			int lineas = sentencia.executeUpdate();
			System.out.println("[info] Filas insertadas en juguete: " + lineas);

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

			int lineas = sentencia.executeUpdate();
			System.out.println("[info] Filas insertadas en empleado: " + lineas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertarZonaVacio(Connection conexion) {
		try {
			String insert = "INSERT INTO zona (idZona, Nombre, Descripcion) VALUES\n" + "(1, 'Luna', 'd1'),\n"
					+ "(2, 'Elisa', 'd2'),\n" + "(3, 'Mario', 'd3'),\n" + "(4, 'Rafa',  'd4');";
			PreparedStatement sentencia = conexion.prepareStatement(insert);

			int lineas = sentencia.executeUpdate();
			System.out.println("[info] Filas insertadas en zona: " + lineas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertarStandVacio(Connection conexion) {
		try {
			String insert = "INSERT INTO stand (idStand, Nombre, Descripcion, ZONA_idZona) VALUES\n"
					+ "(1, 'A', 'da', 1),   \n" + "(2, 'B', 'db', 1),    \n" + "(3, 'C', 'dc', 2),          \n"
					+ "(4, 'D', 'dd', 3),     \n" + "(5, 'E', 'de', 4);";
			PreparedStatement sentencia = conexion.prepareStatement(insert);

			int lineas = sentencia.executeUpdate();
			System.out.println("[info] Filas insertadas en stand: " + lineas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//esto va segun los id de stand (1-1, 2-1, 3-2, 4-3, 5-4)
	public static void insertarStockVacio(Connection conexion) {
		try {
			String insert = "INSERT INTO stock (STAND_idStand, STAND_ZONA_idzona, JUGUETE_idJuguete, CANTIDAD) VALUES \n"
					+ "(1, 1, 1, '5'),\n"
					+ "(1, 1, 2, '3'),\n"
					+ "(1, 1, 3, '3'),\n"
					+ "(1, 1, 4, '10'),\n"
					+ "(2, 1, 5, '2'),\n"
					+ "(2, 1, 6, '8'),\n"
					+ "(2, 1, 7, '15'),\n"
					+ "(2, 1, 8, '4'),\n"
					+ "(3, 2, 9, '6'),\n"
					+ "(3, 2, 10, '12'),\n"
					+ "(3, 2, 11, '5'),\n"
					+ "(3, 2, 12, '7'),\n"
					+ "(4, 3, 13, '19'),\n"
					+ "(4, 3, 14, '5'),\n"
					+ "(4, 3, 15, '5'),\n"
					+ "(4, 3, 16, '15'),\n"
					+ "(5, 4, 17, '10'),\n"
					+ "(5, 4, 18, '9'),\n"
					+ "(5, 4, 19, '1'),\n"
					+ "(5, 4, 20, '10');";
			PreparedStatement sentencia = conexion.prepareStatement(insert);

			int lineas = sentencia.executeUpdate();
			System.out.println("[info] Filas insertadas en stock: " + lineas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
