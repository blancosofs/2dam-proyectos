package ui;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Scanner;

import common.ControlErrores;

public class JugueteriaBlanco {

	public static void main(String[] args) {
		/* verificacion y carga de datos */
		//String url = "jdbc:mysql://localhost:3306/jugueteria";
		String url = "jdbc:mysql://localhost:3306/jugueteriaBlancoC";
		String usuario = "root";
		String password = "sopita666"; 
		//String password = "cfgs";

		try {
			/* Cargar el drive de la BD y crear conexion */
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(url, usuario, password);

			/* verificar conexion bbdd */
			if (conexion != null) { // ~~ se ha cargado?
				System.out.println("[info] Se ha conectado a la base de datos");
			} else {
				System.err.println("Conexion invalida");
			}

			/* verificar bbdd != null (tienes que cargar juguetes, empleados, zona y stand)*/
			boolean banderaJ = ControlErrores.comprobarJuguetesVacio(conexion);
			boolean banderaE = ControlErrores.comprobarEmpleadosVacio(conexion);
			boolean banderaZ = ControlErrores.comprobarZonaVacio(conexion);
			boolean banderaSd = ControlErrores.comprobarStandVacio(conexion);
			boolean banderaSk = ControlErrores.comprobarStockVacio(conexion);

			if (banderaJ) {
				System.out.println("[info] Tabla juguete vacia. Se procede a la creacion de inserts");
				ControlErrores.insertarJuguetesVacio(conexion);
			}
			if (banderaE) {
				System.out.println("[info] Tabla empleados vacia. Se procede a la creacion de inserts");
				ControlErrores.insertarEmpleadosVacio(conexion);
			}
			if (banderaZ) {
				System.out.println("[info] Tabla zona vacia. Se procede a la creacion de inserts");
				ControlErrores.insertarZonaVacio(conexion);
			} 
			if (banderaSd) {
				System.out.println("[info] Tabla stand vacia. Se procede a la creacion de inserts");
				ControlErrores.insertarStandVacio(conexion);
			}
			if (banderaSk) {
				System.out.println("[info] Tabla stock vacia. Se procede a la creacion de inserts");
				ControlErrores.insertarStockVacio(conexion);
			} 
			//si pasa por todo lanzas el menu principal	
			menuPrincipal(args,conexion);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void menuPrincipal(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("~~~ BIENVENIDOS A LA GESTION DE LA JUGUETERIA ~~~");
		System.out.println("# Porfavor seleccione sobre que va a operar: #");
		System.out.println("1. JUGUETES");
		System.out.println("2. EMPLEADO");
		System.out.println("3. VENTAS");
		System.out.println("4. OBTENER DATOS TIENDA");
		System.out.println("0. SALIR");
		int opc = ControlErrores.controlErroresInt(sc);

		switch (opc) {
		case 1:
			MenuJuguetes.main(args, conexion);
			break;

		case 2:
			MenuEmpleado.main(args,conexion);

			break;
		case 3:
			MenuVentas.main(args, conexion);
			break;
		case 4:
			MenuDatos.main(args, conexion);
			break;
		case 0:
			System.out.println("Saliendo del programa...");
			break;
		default:
			System.err.println("[ERROR] Opcion incorrecta");
			break;
		}
		sc.close();
	}

}
