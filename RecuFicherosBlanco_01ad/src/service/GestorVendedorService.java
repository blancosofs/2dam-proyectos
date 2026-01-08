package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.PlantaDAO;
import dao.TicketDAO;
import domain.Empleado;
import domain.Planta;
import domain.Ticket;
import domain.VentaPlanta;

public class GestorVendedorService {

	public static void visualizarCatalogo(ArrayList<Planta> arrayCatalogoPlantas) {
		for (Planta planta : arrayCatalogoPlantas) {
			System.out.println(planta);
		}
	}

	public static boolean validarCodigo(ArrayList<Planta> arrayCestaTemporal, int codigoVenta) {
		for (Planta planta : arrayCestaTemporal) {
			if (codigoVenta == planta.getCodigo()) {
				return true;
			}
		}
		return false;
	}

	public static boolean validarCandtidad(ArrayList<Planta> arrayCestaTemporal, int codigoVenta, int cantidadVenta) {
		for (Planta planta : arrayCestaTemporal) {
			if (codigoVenta == planta.getCodigo()) {
				if (cantidadVenta <= planta.getStock()) {
					return true;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}

	public static boolean generarVentas(ArrayList<Planta> arrayCatalogoPlantas, ArrayList<Planta> arrayCestaTemporal,
			int codigoVenta, int cantidadVenta, Empleado empleadoRegistrado, Scanner sc) {
		boolean bandera = false;
		for (Planta p : arrayCatalogoPlantas) {
			if (p.getCodigo() == codigoVenta && p.getStock() >= cantidadVenta) {
				System.out.println("Venta posible");
				// ~~~~~~~~~~~~ 5.2.1
				PlantaDAO.leerDATstockPorCodigo(codigoVenta);
				// ~~~~~~~~~~~~ 5.3
				System.out.println("Resumen de compra:");
				// 5.4.2 precio total
				float precioTotal = (p.getPrecio() * cantidadVenta);
				System.out.println("Planta COMPRAR [codigo=" + p.getCodigo() + ", cantidad=" + cantidadVenta
						+ ", precio total=" + precioTotal + "]");

				System.out.println("Confirmar venta? (s/n)");
				String respuesta = sc.nextLine().trim();

				if (respuesta.equalsIgnoreCase("s")) {
					// si no la venta no genera nada
					arrayCestaTemporal.add(p);

					// ~~~~~~~~~~~~ 5.4
					PlantaDAO.modificarStock(codigoVenta, cantidadVenta); // este es en el fichero
					// modificar el stock
					p.setStock(p.getStock() - cantidadVenta); // este es en el array

					// ~~~~~~~~~~~~ 5.5
					Ticket ticketVariableCreada = new Ticket();

					// ~~~ 5.5.1
					ticketVariableCreada.setNumTicket(TicketDAO.tomarNombre());// para esto haces el 5.5.1
					// antes llamar a escribir le metes datos (con el get claro)
					ticketVariableCreada.setCodigoEmpleado(empleadoRegistrado.getIdentificacion());
					ticketVariableCreada.setNombreEmpleado(empleadoRegistrado.getNombre());
					ticketVariableCreada.setFechaVenta("01/01/01"); // FECHA SIN IMPLEMENTAR
					// reutilizas el del sysyout pero lo metes en ventaplanta
					for (Planta planta : arrayCestaTemporal) {
						VentaPlanta vp = new VentaPlanta();
						vp.setCodigoProducto(planta.getCodigo());
						vp.setCantidad(cantidadVenta); // no el stock, arriba si pque es igual pero aqui no
						vp.setPrecioUnidad(planta.getPrecio());
						// metelo al ticket! si no va vacio
						ticketVariableCreada.getVentaPlanta().add(vp);
					}
					ticketVariableCreada.setTotalVenta(precioTotal); // para esto haces 5.4.2
					// ~~~ 5.5.2
					// System.out.println("llegas antes del dao?");
					TicketDAO.escribirPorFicheroTicket(ticketVariableCreada);
					arrayCestaTemporal.clear();// limpiar, como buffer

					// esto es para salir que se te quedaba ahi si no
					bandera = true;
					return true;
				} else {
					System.out.println("Venta cancelada");
					return true;
				}

			}

		}

		return false;
	}

	public static void generarDevolucion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el num de ticket a devolver:");
		int numTicketDevolver = ControlErrores.controlErroresInt(sc);
		boolean DevolucionPosibleBoolean = false;
		int intentos = 3;
		Ticket ticketVariableCreadaDevolver = new Ticket();

		while (intentos > 0 && !DevolucionPosibleBoolean) {
			// ~~~~6.1
			if (TicketDAO.buscarTicket(ticketVariableCreadaDevolver, numTicketDevolver)) {
				DevolucionPosibleBoolean = true;
			} else {
				System.out.println("ERROR. numTicket a Devolver no encontrado. TIENES TRES INTENTOS");
				numTicketDevolver = ControlErrores.controlErroresInt(sc);
				intentos--;
			}
			// ~~~~6.2
			TicketDAO.escribirDevolucion(numTicketDevolver);
			// ~~~~~~6.5
			TicketDAO.moverTicketDevolucion(numTicketDevolver);

			/*
			 * // ~~~~~~6.3 TicketDAO.TotalNegativo(numTicketDevolver);
			 * 
			 * // ~~~~~~6.4 PlantaDAO.StockNegativo(numTicketDevolver);
			 */
		}
	}

	// ~~~~~~~~~7.1
	public static void buscarTicketMostrar(int numTicketBuscar) {
		File carpetaBuscar = new File("TICKETS");
		File ficheroTXTbuscar = new File(carpetaBuscar, numTicketBuscar + ".txt");

		if (!ficheroTXTbuscar.exists()) {
			System.out.println("ERROR. ticketo no encontrado");
		}
		try {
			FileReader lector = new FileReader(ficheroTXTbuscar);
			BufferedReader buffer = new BufferedReader(lector);
			String linea;
			while ((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void actualizarYdarBaja(ArrayList<Planta> arrayCatalogo, int codigo, int cantidad) {
	}

}
