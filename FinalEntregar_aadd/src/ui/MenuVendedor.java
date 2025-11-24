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
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Visualizar catalogo");
			System.out.println("2. Generar Ventas");
			System.out.println("3. Generar Devolucion");
			System.out.println("4. Buscar por n ticket");
			System.out.println("0. Salir");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				System.out.println("~ CATALOGO DE PLANTAS:~");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);
				break;
			case 2:
				ArrayList<Planta> arrayCestaTemporal = new ArrayList<Planta>();

				System.out.println("~ VENTA DE PLANTAS: ~");
				System.out.println("Vamos a proceder a la venta de una planta por codigo");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				boolean seguirVentaBoolean = true; // 5.0, que te siga dejando comprar

				while (seguirVentaBoolean) {

					System.out.println("Introduzca e codigo de planta que desee comprar:");
					int codigoVenta = sc.nextInt();
					System.out.println("Introduzca la cantidad de plantas que desee comprar:");
					int cantidadVenta = sc.nextInt();

					boolean ventaPosibleBoolean = false;
					int intentos = 3;

					while (intentos > 0 && !ventaPosibleBoolean) {
						if (ControlErrores.validarCodigo(codigoVenta)) {

							if (ControlErrores.validarCantidad(cantidadVenta)) {
								GestorVendedorService.generarVentas(arrayCatalogoPlantas, arrayCestaTemporal,
										codigoVenta, cantidadVenta, empleadoRegistrado);
								ventaPosibleBoolean = true;
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
						System.out.println("Se ha superado el numero de intentos");
					}

				}

				break;
			case 3:

				break;
			case 4:

				break;
			case 0:
				System.err.println("Saliendo del menu de gestores...");
				break;

			default:
				System.err.println("Opcion incorrecta! Pruebe de nuevo");
				break;
			}

		} while (opc != 0);

		sc.close();
	}

}
