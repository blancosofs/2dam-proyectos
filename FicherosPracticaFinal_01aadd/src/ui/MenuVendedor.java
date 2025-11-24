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
		System.out.println("¡¡¡ BIENVENID@ VENDEDOR/VENDEDORA !!! ~~");
		do {
			System.out.println("####################################");
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("####################################");
			System.out.println("1. Visualizar catalogo");
			System.out.println("2. Generar Ventas");
			System.out.println("3. Generar Devolucion");
			System.out.println("4. Buscar por n ticket");
			System.out.println("0. Salir");
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
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);
				System.out.println("---------------------------------------------------------------------------------------------------------------------------\n");
				break;
			case 2:
				ArrayList<Planta> arrayCestaTemporal = new ArrayList<Planta>();

				System.out.println("~ VENTA DE PLANTAS: ~");
				System.out.println("Vamos a proceder a la venta de una planta por codigo");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				boolean seguirVentaBoolean = true; // 5.0, que te siga dejando comprar

				while (seguirVentaBoolean) {

					System.out.println("Introduzca e codigo de planta que desee comprar:");
					int codigoVenta = ControlErrores.controlErroresInt(sc);
					System.out.println("Introduzca la cantidad de plantas que desee comprar:");
					int cantidadVenta = ControlErrores.controlErroresInt(sc);

					boolean ventaPosibleBoolean = false;
					int intentos = 3;

					while (intentos > 0 && !ventaPosibleBoolean) {
						if (ControlErrores.validarCodigo(codigoVenta)) {

							if (ControlErrores.validarCantidad(cantidadVenta)) {
								boolean ventaDone = GestorVendedorService.generarVentas(arrayCatalogoPlantas, arrayCestaTemporal,
										codigoVenta, cantidadVenta, empleadoRegistrado, sc);
								if (ventaDone) {
								    seguirVentaBoolean = false; 
								    ventaPosibleBoolean = true;
								}
							} else {
								System.out.println("Error, tienes " + intentos
										+ " intentos \n CUIDADO, EL PROGRAMA SE CERRARA SI TE PASA");
								intentos--;
								System.err.println("ERROR. Cantidad invalida");
							}

						} else {
							System.out.println("Error, tienes " + intentos
									+ " intentos \n CUIDADO, EL PROGRAMA SE CERRARA SI TE PASA");
							intentos--;
							System.err.println("ERROR. Codigo invalido");
						}

						if (!ventaPosibleBoolean && intentos > 0) {
							System.out.println("Desea seguir comprando? (s/n)");
							String respuesta = sc.next();
							if (respuesta.equalsIgnoreCase("n")) {
								seguirVentaBoolean = false;
							}
						}

					}

					if (intentos == 0) {
						System.err.println("Se ha superado el numero de intentos");
					}

				}
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
				System.err.println("🌱 Saliendo del menu de vendedores...");
				break;

			default:
				System.err.println("Opcion incorrecta! Pruebe de nuevo");
				break;
			}

		} while (opc != 0);

		sc.close();
	}

}
