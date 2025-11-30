package ui;

import java.sql.Connection;
import java.util.Scanner;

import dao.DatosDAO;

public class MenuDatos {

	public static void main(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println();
			System.out.println("~~~ [DATOS] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Disponibilidad juguetes x stand");
			System.out.println("2. Datos de las ventas x mes");
			System.out.println("3. Datos de los cambios de los empleados y pque");
			System.out.println("4. Listar productos ordenados por precio");
			System.out.println("0. SALIR");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				System.out.println("1. Disponibilidad juguetes x stand");
				DatosDAO.mostrarStock(conexion);
				break;
			case 2:
				System.out.println("2. Datos de las ventas x mes");
				DatosDAO.datosMes(conexion);
				break;
			case 3:
				break;
			case 4:
				System.out.println("4. Listar productos ordenados por precio");
				DatosDAO.mostrarPorPrecio(conexion);
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.err.println("[ERROR] Opcion incorrecta");
				break;
			}
		} while (opc != 0);
		sc.close();
	}
}
