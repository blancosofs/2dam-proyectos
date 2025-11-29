package ui;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Scanner;

import common.ControlErrores;

public class JugueteriaBlanco {

	public static void main(String[] args) {
		/* verificacion y carga de datos */
		String url = "jdbc:mysql://localhost:3306/jugueteria";
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

			/* verificar bbdd != null */
			boolean banderaJ = ControlErrores.comprobarJuguetesVacio(conexion);
			boolean banderaE = ControlErrores.comprobarEmpleadosVacio(conexion);

			if (banderaJ && banderaE) {
				System.out.println("[info] Filas vacias. Se procede a la creacion de inserts");
				ControlErrores.insertarJuguetesVacio(conexion);
				ControlErrores.insertarEmpleadosVacio(conexion);
			} else {

				Scanner sc = new Scanner(System.in);
				System.out.println();
				System.out.println("~~~ BIENVENIDOS A LA GESTION DE LA JUGUETERIA ~~~");
				System.out.println("# Porfavor seleccione sobre que va a operar: #");
				System.out.println("1. JUGUETES");
				System.out.println("2. EMPLEADO");
				System.out.println("3. VENTAS");
				System.out.println("4. OBTENER DATOS TIENDA");
				System.out.println("0. SALIR");
				int opc = sc.nextInt();

				switch (opc) {
				case 1:
					MenuJuguetes.main(args);
					break;

				case 2:
					MenuEmpleado.main(args);

					break;
				case 3:
					MenuVentas.main(args);
					break;
				case 4:
					MenuDatos.main(args);
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
