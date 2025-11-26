package ui;

import java.util.Scanner;

public class MenuVentas {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("~~~ [VENTAS] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Realizar una venta ");
			System.out.println("2. Realizar una devolucion");
			System.out.println("3. Producto mas vendido");
			System.out.println("4. Empleados que mas venden");
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
