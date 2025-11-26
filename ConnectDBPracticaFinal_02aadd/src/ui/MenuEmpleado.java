package ui;

import java.util.Scanner;

public class MenuEmpleado {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("~~~ [EMPLEADO] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Registrar un nuevo empleado");
			System.out.println("2. Modificar los datos de un nuevo empleado");
			System.out.println("3. Eliminar el empleado");
			System.out.println("0. SALIR");
			int opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				
				break;

			case 2:
				break;
			case 3:
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
