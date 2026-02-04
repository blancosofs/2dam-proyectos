package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.PlantaDAO;
import domain.Empleado;
import domain.Planta;
import service.GestorVendedorService;

public class MenuGestor {

	public static void mostrarMenuGestor(Empleado empleadoRegistrado, ArrayList<Planta> arrayCatalogoPlantas,
			ArrayList<Empleado> arrayCatalogoEmpleados, File ficheroXML, File ficheroDAT) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		System.out.println("\n\n¡¡¡ BIENVENID@ GESTOR/GESTORA !!! ~~");
		System.out.println();
		do {
			System.out.println();
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Dar de alta plantas         ");
			System.out.println(" . Dar de baja plantas         ");
			System.out.println(" . Modificar campos de plantas ");
			System.out.println(" . Dar alta empleados          ");
			System.out.println(" . Dar baja empleados          ");
			System.out.println(" . Recuperar baja empleado     ");
			System.out.println(" . Estadisticas                ");
			System.out.println("0. Volver");
			opc = ControlErrores.controlErroresInt2(sc);

			switch (opc) {
			case 1:
				System.out.println("\n~~ ALTA PLANTAS ~~");

				System.out.println("Introduzca el nombre de la nueva planta:");
				String nombre = sc.next();

				System.out.println("Introduzca una descripcion de la foto:");
				String foto = sc.next();

				System.out.println("Introduzca una descripcion de la planta:");
				String descripcion = sc.next();

				System.out.println("Introduzca el precio unitario:");
				float precio = ControlErrores.controlErroresFloat(sc);
				if (precio < 1) {
					System.out.println("[error] Precio inferior al mínimo");
				}

				System.out.println("Introduzca el stock disponible:");
				int stock = ControlErrores.controlErroresInt(sc);
				if (stock < 1) {
					System.out.println("[error] Precio inferior al mínimo");
				}

				Planta plantaG = new Planta(nombre, foto, descripcion, precio, stock);

				// en ejecucion
				arrayCatalogoPlantas.add(plantaG);
				// a ficheros
				PlantaDAO.nuevaPlantaXML(ficheroXML, plantaG);
				PlantaDAO.nuevaPlantaDAT(ficheroDAT, plantaG);

				System.out.println("[info] Planta dada de alta con exito");

				break;
			case 2:
				System.out.println("\n~~ BAJA PLANTAS ~~");

				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				System.out.println("Introduzca el codigo de la planta a dar de baja:");
				int codigoBaja = ControlErrores.controlErroresInt(sc);

				if (!GestorVendedorService.validarCodigo(arrayCatalogoPlantas, codigoBaja)) {
					System.out.println("[error] planta no encontrada");
				} else {
					Planta pb = GestorVendedorService.extraerObjetoPlanta(arrayCatalogoPlantas, codigoBaja);
					PlantaDAO.pasarBajaPlanta(pb);
					arrayCatalogoPlantas.remove(pb);
				}

				// System.out.println("[info] Funcion no implementada");
				break;
			case 3:
				System.out.println("\n~~ MODIFICAR PLANTAS ~~");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				System.out.println("Introduzca el codigo de la planta a modificar:");
				int codigoModificar = ControlErrores.controlErroresInt(sc);
				
				if (!GestorVendedorService.validarCodigo(arrayCatalogoPlantas, codigoModificar)) {
					System.out.println("[error] planta no encontrada");
				} else {
					System.out.println("Introduzca el nombre de la nueva planta:");
					String nombreM = sc.next();

					System.out.println("Introduzca una descripcion de la foto:");
					String fotoM = sc.next();

					System.out.println("Introduzca una descripcion de la planta:");
					String descripcionM = sc.next();

					System.out.println("Introduzca el precio unitario:");
					float precioM = ControlErrores.controlErroresFloat(sc);
					if (precioM < 1) {
						System.out.println("[error] Precio inferior al mínimo");
					}

					System.out.println("Introduzca el stock disponible:");
					int stockM = ControlErrores.controlErroresInt(sc);
					if (stockM < 1) {
						System.out.println("[error] Precio inferior al mínimo");
					}

					Planta plantaM = new Planta(nombreM, fotoM, descripcionM, precioM, stockM);
					// en ejecucion
					arrayCatalogoPlantas.add(plantaM);
					// a ficheros
					PlantaDAO.nuevaPlantaXML(ficheroXML, plantaM);
					PlantaDAO.nuevaPlantaDAT(ficheroDAT, plantaM);

					System.out.println("[info] Planta dada de modificada con exito");
				}
				
				//System.out.println("[info] Funcion no implementada");
				break;
			case 4:
				System.out.println("\n~~ ALTA EMPLEADOS ~~");
				System.out.println("[info] Funcion no implementada");
				break;
			case 5:
				System.out.println("\n~~ BAJA EMPLEADOS ~~");
				System.out.println("[info] Funcion no implementada");

				break;
			case 6:
				System.out.println("\n~~ MODIFICAR EMPLEADOS ~~");
				System.out.println("[info] Funcion no implementada");
				break;
			case 7:
				System.out.println("\n~~ ESTADISTICAS TICKET"
						+ " ~~");
				System.out.println("[info] Funcion no implementada");
				break;
			case 0:
				System.err.println("Saliendo del menu de gestores...");
				ViveroBlanco.menuVivero();
				break;

			default:
				System.err.println("Opcion incorrecta! Pruebe de nuevo");
				break;
			}

		} while (opc != 0);

		sc.close();

	}

}
