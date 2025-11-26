package ui;

import java.util.Scanner;

public class MenuDatos {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("~~~ [DATOS] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Disponibilidad juguetes x stand");
			System.out.println("2. Datos de las ventas x mes");
			System.out.println("3. Datos de los cambios de los empleados y pque");
			System.out.println("4. Listar productos ordenados por precio");
			System.out.println("0. SALIR");
			int opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				
				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
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
