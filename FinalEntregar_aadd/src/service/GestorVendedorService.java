package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.PlantaDAO;
import domain.Empleado;
import domain.Planta;

public class GestorVendedorService {

	public static void visualizarCatalogo(ArrayList<Planta> arrayCatalogoPlantas) {
		System.out.println("\nLista completa:"); 
		for (Planta p : arrayCatalogoPlantas)
		 { System.out.println(p); }
			
	}

	public static void generarVentas(ArrayList<Planta> arrayCatalogoPlantas, ArrayList<Planta> arrayCestaTemporal,
			int codigoVenta, int cantidadVenta, Empleado empleadoRegistrado) {

		for (Planta p : arrayCatalogoPlantas) {
			if (p.getCodigo() == codigoVenta && p.getStock() > cantidadVenta) {
				System.out.println("Venta posible");
				// 5.2.1
				PlantaDAO.leerDATstockPorCodigo(codigoVenta);
				// 5.3
				Scanner sc = new Scanner(System.in);
				System.out.println("Resumen de compra:");
				System.out.println("Planta COMPRAR [codigo=" + p.getCodigo() + ", cantidad=" + cantidadVenta
						+ ", precio total=" + (p.getPrecio() * cantidadVenta) + "]");
				boolean confirmarVentaBolean = true;
				
				if (confirmarVentaBolean) {
					System.out.println("Desea seguir comprando? (s/n)");
					String respuesta = sc.next();
					if (respuesta.equalsIgnoreCase("n")) {
						System.out.println("Venta canelada");
						confirmarVentaBolean = false;
					} else {
						PlantaDAO.modificarStock(codigoVenta, cantidadVenta);
						generarTicket(empleadoRegistrado, arrayCestaTemporal);
					}
				}
				sc.close();
			}
			if (p.getCodigo() == 0) {
				System.err.println("ERROR. No existe ninguna planta con ese codigo");
			}
		}

	}

	public static void generarTicket(Empleado empleado, ArrayList<Planta> arrayCatalogoCestaTemporal) {

	}

	public static void generarDevolucion() {
	}

	public static void actualizarYdarBaja(ArrayList<Planta> arrayCatalogo, int codigo, int cantidad) {
	}

}
