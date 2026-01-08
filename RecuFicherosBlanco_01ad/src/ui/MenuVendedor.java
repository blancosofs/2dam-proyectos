package ui;

import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import domain.Empleado;
import domain.Planta;
import service.GestorVendedorService;

public class MenuVendedor {
	
	public static void mostrarMenuVendedor(Empleado empleadoRegistrado, ArrayList<Planta> arrayCatalogoPlantas) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		System.out.println("\n\n¡¡¡ BIENVENID@ VENDEDOR/VENDEDORA !!! ~~");
		do {
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Visualizar catalogo");
			System.out.println("2. Generar Ventas");
			System.out.println("3. Generar Devolucion");
			System.out.println("4. Buscar por n ticket");
			System.out.println("0. Volver");
			// control scanner 1
			String opcTexto = sc.nextLine().trim();
			try {
				opc = Integer.parseInt(opcTexto);
			} catch (NumberFormatException e) {
				opc = -1;
			}

			switch (opc) {
			case 1:
				System.out.println("\n~~ CATALOGO DE PLANTAS DISPONIBLES ~~");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------\n");
				break;
			case 2:
				//este esta vacio lol. De alguna forma saca el cataogo plantas para validar las cosas y luego usas el temporal para anyadir. sos
				ArrayList<Planta> arrayCestaTemporal = new ArrayList<Planta>();

				System.out.println("~ VENTA DE PLANTAS: ~");
				System.out.println("Vamos a proceder a la venta de una planta por codigo");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				boolean seguirVentaBoolean = true; // 5.0, que te siga dejando comprar

				do {
					System.out.println("Introduzca e codigo de planta que desee comprar:");
					int codigoVenta = ControlErrores.controlErroresInt(sc);

					if (GestorVendedorService.validarCodigo(arrayCatalogoPlantas,codigoVenta)) {
						System.out.println("Introduzca la cantidad de plantas que desee comprar:");
						int cantidadVenta = ControlErrores.controlErroresInt(sc);

						if (GestorVendedorService.validarCandtidad(arrayCatalogoPlantas,codigoVenta,cantidadVenta)) {

							
						}else {
							System.out.println("[error] stock insuficiente");
						}

					} else {
						System.out.println("[error] planta no encontrada");
					}

				} while (seguirVentaBoolean);
				
				break;
			case 3:
				GestorVendedorService.generarDevolucion();
				break;
			case 4:
				System.out.println("Introduzca el num de ticket a buscar:");
				int numTicketBuscar = ControlErrores.controlErroresInt(sc);
				GestorVendedorService.buscarTicketMostrar(numTicketBuscar);
				break;
			case 0:
				System.err.println("Saliendo del menu de vendedores...");
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
