package ui;

import java.util.ArrayList;
import java.util.Scanner;

import domain.Empleado;
import domain.Planta;
import service.GestorGestorService;
import service.GestorVendedorService;

public class MenuGestor {

	public static void mostrarMenuGestor(Empleado empleadoRegistrado, ArrayList<Planta> arrayCatalogoPlantas,
			ArrayList<Empleado> arrayCatalogoEmpleados) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		System.out.println("¡¡¡ BIENVENID@ GESTOR/GESTORA !!! ~~");
		System.out.println();
		do {
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Dar de alta plantas");
			System.out.println("2. Dar de baja plantas");
			System.out.println("3. Modificar campos de plantas");
			System.out.println("4. Dar alta empleados");
			System.out.println("5. Dar baja empleados");
			System.out.println("6. Recuperar baja empleado");
			System.out.println("7. Estadisticas");
			System.out.println("0. Salir");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				GestorGestorService.altaPlanta(arrayCatalogoPlantas);
				System.out.println("Nuevo catalogo Alta:");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);
				break;
			case 2:
				GestorGestorService.bajaPlanta(arrayCatalogoPlantas);
				System.out.println("Nuevo catalogo Baja:");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 0:
				System.err.println("🌱 Saliendo del menu de gestores...");
				break;

			default:
				System.err.println("Opcion incorrecta! Pruebe de nuevo");
				break;
			}

		} while (opc != 0);

		sc.close();

	}

}
