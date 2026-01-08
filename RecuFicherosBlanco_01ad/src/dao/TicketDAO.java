package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domain.Ticket;
import domain.VentaPlanta;

public class TicketDAO {

	// ~~~~ 5.5.1 tomar nombre
	public static int tomarNombre() {
		int numTicket = 0;

		File ticketsCarpetaTXT = new File("TICKETS");
		File[] listaTickets = ticketsCarpetaTXT.listFiles();

		if (listaTickets == null || listaTickets.length == 0) {
			return 1;
		} // lo de tirarte uno si no encuentra nada

		for (File f : listaTickets) {
			if (f.isFile()) {
				String nombre = f.getName(); // pillas nombre archivo

				// control de errores! que te lee tambien la extension y revienta
				int extension = nombre.lastIndexOf(".");
				String numeroSinTXT = nombre.substring(0, extension);

				int numero = Integer.parseInt(numeroSinTXT);

				if (numero > numTicket) {
					numTicket = numero;
				}
			}
		}
		return numTicket + 1;
	}

	// ~~~~ 5.5.2 escribir en fichero. lo metes al dao pque escribes en el txt. no
	// en consola como v1
	public static void escribirPorFicheroTicket(Ticket ticketVariableCreada) {
		// System.out.println("llegas a entrar a escribir");
		try {

			File ticketsCarpetaTXT = new File("TICKETS");
			// System.out.println("existe carpeta? " + ticketsCarpetaTXT.exists());
			// System.out.println("existe ruta?" + ticketsCarpetaTXT.getAbsolutePath());
			if (!ticketsCarpetaTXT.exists()) {
				ticketsCarpetaTXT.mkdirs();
			}

			File ficheroTXT = new File(ticketsCarpetaTXT, ticketVariableCreada.getNumTicket() + ".txt");
			// System.out.println("esiste fichero?" + ficheroTXT.getAbsolutePath());
			// System.out.println("ruta fichero? " + ficheroTXT.exists());

			FileWriter fw = new FileWriter(ficheroTXT);

			fw.write("Número Ticket:" + ticketVariableCreada.getNumTicket() + "\n");
			fw.write("—————————————————————————//———————————————————————————————\n");
			fw.write("Empleado que ha atendido:" + ticketVariableCreada.getCodigoEmpleado() + "\n");
			fw.write("Nombre del empleado:" + ticketVariableCreada.getNombreEmpleado() + "\n\n");
			// es lit como en el sysout el ir pasando pero con una clase
			fw.write("CodigoProducto   Cantidad   PrecioUnitario \n");
			for (VentaPlanta v : ticketVariableCreada.getVentaPlanta()) {
				fw.write(v.getCodigoProducto() + "  " + v.getCantidad() + "  " + v.getPrecioUnidad() + "\n");
			}
			//
			fw.write("———————————————————————————//—————————————————————————————\n");
			fw.write("Total:  €" + ticketVariableCreada.getTotalVenta() + "\n");

			fw.close();
			// System.out.println("llegas despues de escribir?");
		} catch (IOException i) { // revienta precio unitario
			i.printStackTrace();
		}
	}

	// ~~~~ 6.1
	public static boolean buscarTicket(Ticket ticket, int numTicketDevolucion) {
		File carpetaBuscar = new File("TICKETS");
		File ficheroTXTbuscar = new File(carpetaBuscar, numTicketDevolucion + ".txt");

		if (!ficheroTXTbuscar.exists()) {
			return false;
		}
		return true;
	}

	// ~~~~ 6.2
	public static void escribirDevolucion(int numTicketDevolucion) {
		try {
			File carpetaBuscar = new File("TICKETS");
			File ficheroTXTplus = new File(carpetaBuscar, numTicketDevolucion + ".txt");

			FileWriter fw = new FileWriter(ficheroTXTplus, true); // lo de no sobreescribir (revisa apuntes)
			fw.write("\n-- DEVOLUCIÓN --\n");
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ~~~6.5
	public static void moverTicketDevolucion(int numTicketDevolver) {
		try {
			File carpetaBuscar = new File("TICKETS");
			File ficheroTXTplus = new File(carpetaBuscar, numTicketDevolver + ".txt");

			File carpetaDestino = new File("TICKETS/DEVOLUCIONES");
			if (!carpetaDestino.exists()) {
				carpetaDestino.mkdirs();
			}
			 File destino = new File(carpetaDestino, numTicketDevolver + ".txt");
			 boolean banderaMover = ficheroTXTplus.renameTo(destino);

		        if (!banderaMover) {
		            System.out.println("ERROR. No se ha podido mover a devoluciones");
		        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
