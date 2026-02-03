package service;

import domain.Planta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class GestorVendedorService {

	public static void visualizarCatalogo(ArrayList<Planta> arrayCatalogoPlantas) {
		for (Planta planta : arrayCatalogoPlantas) {
			System.out.println(planta);
		}
	}

	public static boolean validarCodigo(ArrayList<Planta> arrayCatalogoPlantas, int codigoVenta) {
		for (Planta planta : arrayCatalogoPlantas) {
			if (codigoVenta == planta.getCodigo()) {
				return true;
			}
		}
		return false;
	}

	public static boolean validarCandtidad(ArrayList<Planta> arrayCatalogoPlantas, int codigoVenta, int cantidadVenta) {
		for (Planta planta : arrayCatalogoPlantas) {
			if (codigoVenta == planta.getCodigo()) {
				if (cantidadVenta <= planta.getStock()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static Planta extraerObjetoPlanta(ArrayList<Planta> arrayCatalogoPlantas, int codigoVenta) {
		Planta p = null;
		for (Planta planta : arrayCatalogoPlantas) {
			if (codigoVenta == planta.getCodigo()) {
				p = new Planta(planta.getCodigo(), planta.getNombre(), planta.getFoto(), planta.getDescripcion(),
						planta.getPrecio(), planta.getStock());
			}
		}
		return p;
	}

	public static void mostrarTicket(int numTicketBuscar) {
		File ficheroTXTbuscar = new File("TICKETS", numTicketBuscar + ".txt");

		if (!ficheroTXTbuscar.exists() || !ficheroTXTbuscar.isFile()) {
			System.out.println("[error] Ticket " + numTicketBuscar + " no encontrado");
		} else {
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
	}

	public static void listarTickets() {
		File carpeta = new File("TICKETS");

		if (!carpeta.exists() || !carpeta.isDirectory() || carpeta.listFiles() == null) {
			System.out.println("[info] No hay tickets ");
		} else {
			File[] tickets = carpeta.listFiles();
			for (File f : tickets) {
				System.out.println("Ticket: numTicket= " + f.getName());
			}
		}

	}

	public static void moverTickets(int numTicketBuscar) {
		File carpeta = new File("DEVOLUCIONES");
		File ficheroTXTbuscar = new File("TICKETS", numTicketBuscar + ".txt");

		if (!ficheroTXTbuscar.exists() || !ficheroTXTbuscar.isFile()) {
			System.out.println("[error] Ticket " + numTicketBuscar + " no encontrado");
		} else {
			File destino = new File(carpeta, ficheroTXTbuscar.getName());
			if (ficheroTXTbuscar.renameTo(destino)) {
				System.out.println("[info] funciona");
			} else {
				System.out.println("[error] mover");
			}
		}

	}
	

}
