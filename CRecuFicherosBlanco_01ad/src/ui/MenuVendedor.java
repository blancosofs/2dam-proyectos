package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.PlantaDAO;
import dao.TicketDAO;
import domain.Empleado;
import domain.Planta;
import domain.Ticket;
import domain.VentaPlanta;
import service.GestorVendedorService;

public class MenuVendedor {

	public static void mostrarMenuVendedor(Empleado empleadoRegistrado, ArrayList<Planta> arrayCatalogoPlantas) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		System.out.println("\n\n¡¡¡ BIENVENID@ VENDEDOR/VENDEDORA !!! ~~");
		do {
			System.out.println();
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Visualizar catalogo");
			System.out.println("2. Generar Ventas");
			System.out.println("3. Generar Devolucion");
			System.out.println("4. Buscar por n ticket");
			System.out.println("0. Volver");
			opc = ControlErrores.controlErroresInt2(sc);

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
				System.out.println("~ VENTA DE PLANTAS: ~");

				ArrayList<VentaPlanta> arrayVentas = new ArrayList<VentaPlanta>();

				System.out.println("Vamos a proceder a la venta de una planta por codigo");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				boolean seguirVentaBoolean = true;

				do {
					System.out.println("Introduzca el codigo de planta que desee comprar:");
					int codigoVenta = ControlErrores.controlErroresInt(sc);

					if (!GestorVendedorService.validarCodigo(arrayCatalogoPlantas, codigoVenta)) {
						System.out.println("[error] planta no encontrada");
					} else {
						Planta p = GestorVendedorService.extraerObjetoPlanta(arrayCatalogoPlantas, codigoVenta);

						System.out.println("Introduzca la cantidad de plantas que desee comprar:");
						int cantidadVenta = ControlErrores.controlErroresInt(sc);

						if (cantidadVenta > p.getStock()) {
							System.out.println("[error] stock insuficiente");
						} else {

							VentaPlanta vp = new VentaPlanta(codigoVenta, p.getPrecio(), cantidadVenta);
							arrayVentas.add(vp);

							PlantaDAO.modificarStock(codigoVenta, cantidadVenta);
							p.setStock(p.getStock() - cantidadVenta);

							System.out.println("Resumen de compra:");

							float precioTotal = (p.getPrecio() * cantidadVenta);
							System.out.println("Planta COMPRAR [codigo=" + p.getCodigo() + ", cantidad=" + cantidadVenta
									+ ", precio total=" + precioTotal + "]");

							System.out.println("Seguir comprando? (s/n)");
							String respuesta = ControlErrores.controlErroresRespuesta(sc);

							if (respuesta.equalsIgnoreCase("n")) {
								/* TICKET */
								Empleado e = empleadoRegistrado;

								int codEmpleado = e.getIdentificacion();
								String nomEmpleado = e.getNombre();
								LocalDate fechaActual = LocalDate.now();

								// numTicket con contador para que sea autoincrement

								Ticket t = new Ticket(codEmpleado, nomEmpleado, fechaActual, arrayVentas, precioTotal,
										false);

								TicketDAO.escribirPorFicheroTicket(t);

								System.out.println("[info] Venta terminada");
								seguirVentaBoolean = false;
							}
						}
					}

				} while (seguirVentaBoolean);

				break;
			case 3:
				System.out.println("\n~~ DEVOLUCION PLANTAS ~~");
				
				//buscar por numero de ticket
				GestorVendedorService.listarTickets();
				System.out.println("Introduzca el num de ticket a devolver:");
				int numTicketDevolver = ControlErrores.controlErroresInt(sc);
				
				//ticket para poder trabajarlo
				Ticket td = TicketDAO.extrarObjetoTicket(numTicketDevolver);
				System.out.println("[llegas? EXTRAER TICKET]");
				System.out.println(td);
				
				if (td != null) {//q no reviente
					
				//sumar el stock, tienes por ahi el modificar stock
				
				
				//marcar el ticket en negativo y con la linea devuelto al final
				TicketDAO.escribirDevuelto(td);
				
				//llevar a devoluciones
				GestorVendedorService.moverTickets(numTicketDevolver);
				
				//automaticamente una planta se da de baja si el stock es cero y no se puede realizar ninguna compra sobre ella 
	
				System.out.println("[info] Devolucion terminada");
	
				}else {
					System.out.println("[error] Ticket vacio");
				}
				
				break;
			case 4:
				System.out.println("\n~~ BUSCAR POR N TICKET ~~");
				
				GestorVendedorService.listarTickets();
				System.out.println("Introduzca el num de ticket a buscar:");
				int numTicketBuscar = ControlErrores.controlErroresInt(sc);
				GestorVendedorService.mostrarTicket(numTicketBuscar);
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
