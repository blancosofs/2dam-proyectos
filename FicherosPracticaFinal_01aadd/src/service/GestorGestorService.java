package service;

import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.PlantaDAO;
import domain.Planta;

public class GestorGestorService {

	public static void altaPlanta(ArrayList<Planta> arrayCatalogo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("codigo new:");
		int codigo = ControlErrores.controlErroresInt(sc);

		System.out.println("nombre:");
		String nombre = sc.nextLine();

		System.out.println("foto:");
		String foto = sc.nextLine();

		System.out.println("desc:");
		String descripcion = sc.nextLine();

		System.out.println("precio:");
		float precio = sc.nextFloat();

		System.out.println("stock:");
		int stock = ControlErrores.controlErroresInt(sc);

		// 8.1.1.1 añadir
		Planta p = new Planta(codigo, nombre, foto, descripcion, precio, stock);
		arrayCatalogo.add(p);

		// 8.1.1.2 escribir
		PlantaDAO.escribirPlantaDAT(p);

		System.out.println("Planta alta");
	}

	public static void bajaPlanta(ArrayList<Planta> arrayPlantasBaja) {
		Scanner sc = new Scanner(System.in);

		System.out.println("codigo new:");
		int codigo = ControlErrores.controlErroresInt(sc);

		for (Planta p : arrayPlantasBaja) {
			if (p.getCodigo() == codigo) {
				
				 int stockOriginal = p.getStock();

				PlantaDAO.modificarStock(codigo, p.getStock()); // te metes a cambiar
				p.setStock(0); // cero

				// Guardar en fichero de bajas
				PlantaDAO.escribirPlantaBajaDAT(codigo,stockOriginal);

				System.out.println("Planta baja");
			}
		}

	}

}
