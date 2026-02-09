package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.EmpleadoDAO;
import dao.PlantaDAO;
import domain.Empleado;
import domain.Planta;
import service.GestorGestorService;
import service.GestorVendedorService;

public class MenuGestor {

	public static void mostrarMenuGestor(Empleado empleadoRegistrado, ArrayList<Planta> arrayCatalogoPlantas,
			ArrayList<Empleado> arrayCatalogoEmpleados, File ficheroXML, File ficheroDAT, File ficheroEmpleados) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		System.out.println("\n\n¡¡¡ BIENVENID@ GESTOR/GESTORA !!! ~~");
		System.out.println();
		do {
			System.out.println();
			System.out.println("## SELECCIONE LA TAREA A REALIZAR ##");
			System.out.println("1. Dar de alta plantas         ");
			System.out.println(" . Dar de baja plantas         ");
			System.out.println("3. Modificar campos de plantas ");
			System.out.println("4. Dar alta empleados          ");
			System.out.println(" . Dar baja empleados          ");
			System.out.println(" . Recuperar baja empleado     ");
			System.out.println("7. Estadisticas                ");
			System.out.println("0. Volver");
			opc = ControlErrores.controlErroresInt2(sc);

			switch (opc) {
			case 1:
				System.out.println("\n~~ ALTA PLANTAS ~~");

				System.out.println("Introduzca el nombre de la nueva planta:");
				String nombre = sc.next();

				if (!ControlErrores.validarTexto(nombre)) {
					System.out.println("Vuelva a intentar dar de alta a la planta deseada (error en el nombre)");
					break;
				}

				System.out.println("Introduzca una descripcion de la foto:");
				String foto = sc.next();

				System.out.println("Introduzca una descripcion de la planta:");
				String descripcion = sc.next();

				if (!ControlErrores.validarTexto(descripcion)) {
					System.out.println("Vuelva a intentar dar de alta a la planta deseada (error en la descripcion)");
					break;
				}

				System.out.println("Introduzca el precio unitario:");
				float precio = ControlErrores.controlErroresFloat(sc);
				if (precio < 1) {
					System.out.println("[error] Precio inferior al mínimo");
				}

				System.out.println("Introduzca el stock disponible:");
				int stock = ControlErrores.controlErroresInt(sc);
				if (stock < 1) {
					System.out.println("[error] Stock inferior al mínimo");
				}

				// en ejecucion
				Planta plantaG = new Planta(nombre, foto, descripcion, precio, stock);
				arrayCatalogoPlantas.add(plantaG);
				// a ficheros
				PlantaDAO.nuevaPlantaXML(ficheroXML, plantaG);
				PlantaDAO.nuevaPlantaDAT(ficheroDAT, plantaG);

				System.out.println("[info] Planta dada de alta con exito");

				// catalogo
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				break;
			case 2:
				System.out.println("[info] No funciona");
				System.out.println("\n~~ BAJA PLANTAS ~~");

				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				System.out.println("Introduzca el codigo de la planta a dar de baja:");
				int codigoBaja = ControlErrores.controlErroresInt(sc);

				if (!GestorVendedorService.validarCodigo(arrayCatalogoPlantas, codigoBaja)) {
					System.out.println("[error] planta no encontrada");
				} else {
					// la plantita a dar de baja
					Planta pb = GestorVendedorService.extraerObjetoPlanta(arrayCatalogoPlantas, codigoBaja);

					// lo ponemos todo a cero

				}
				break;
			case 3:
				System.out.println("[info] No funciona");
				System.out.println("\n~~ MODIFICAR PLANTAS ~~");
				GestorVendedorService.visualizarCatalogo(arrayCatalogoPlantas);

				System.out.println("Introduzca el codigo de la planta a modificar:");
				int codigoModificar = ControlErrores.controlErroresInt(sc);

				if (!GestorVendedorService.validarCodigo(arrayCatalogoPlantas, codigoModificar)) {
					System.out.println("[error] planta no encontrada");
				} else {
					// la plantita a modificar
					Planta pm = GestorVendedorService.extraerObjetoPlanta(arrayCatalogoPlantas, codigoModificar);

					System.out.println("Introduzca el nuevo nombre:");
					String nombreM = sc.next();

					System.out.println("Introduzca la nueva descripcion de la foto:");
					String fotoM = sc.next();

					System.out.println("Introduzca la nueva descripcion:");
					String descripcionM = sc.next();

					System.out.println("Introduzca el nuevo precio unitario:");
					float precioM = ControlErrores.controlErroresFloat(sc);
					if (precioM < 1) {
						System.out.println("[error] Precio inferior al mínimo");
					}

					System.out.println("Introduzca el nuevo stock:");
					int stockM = ControlErrores.controlErroresInt(sc);
					if (stockM < 1) {
						System.out.println("[error] Precio inferior al mínimo");
					}
					//

					// en ejecucion
					Planta plantaM = new Planta(nombreM, fotoM, descripcionM, precioM, stockM);
					arrayCatalogoPlantas.add(plantaM);
					// a ficheros
					PlantaDAO.nuevaPlantaXML(ficheroXML, plantaM);
					PlantaDAO.nuevaPlantaDAT(ficheroDAT, plantaM);

					System.out.println("[info] Planta modificada con exito");
				}

				// System.out.println("[info] Funcion no implementada");
				break;
			case 4:
				System.out.println("[info] No funciona");
				System.out.println("\n~~ ALTA EMPLEADOS ~~");

				System.out.println("Introduzca la identificacion del nuevo empleado (CUATRO DIGITOS INT):");
				int codigoEmpleado = ControlErrores.controlErroresInt(sc);

				if (!ControlErrores.validarCodigoEmpleado(codigoEmpleado)) {
					System.out.println("Vuelva a intentar dar de alta al empleado deseado (error en el codigo)");
					break;
				}

				System.out.println("Introduzca el nombre del nuevo empleado:");
				String nombreEmpleado = sc.next();

				/*if (!ControlErrores.validarTexto(nombreEmpleado)) {
					System.out.println("Vuelva a intentar dar de alta al empleado deseado (error en el nombre)");
					break;
				}*/

				System.out.println("Introduzca la contrasenya del nuevo empleado (Hola[cualquier numero] -> tiene que ser 1 min 1 mayus y entre 5-7 caracteres):");
				String pwdEmpleado = sc.next();

				if (!ControlErrores.validarPwd(pwdEmpleado)) {
					System.out.println("Vuelva a intentar dar de alta al empleado deseado (error en la contrasenya)");
					break;
				}

				// cargo por defecto
				String cargoEmpleado = "vendedor";

				// en ejecucion
				Empleado empleadoA = new Empleado(codigoEmpleado, nombreEmpleado, pwdEmpleado, cargoEmpleado);
				arrayCatalogoEmpleados.add(empleadoA);
				// a ficheros
				//EmpleadoDAO.nuevoEmpleado(empleadoA);

				System.out.println("[info] Empleado dado de alta con exito");

				// Catalogo
				//GestorGestorService.visualizarCatalogo(arrayCatalogoEmpleados);

				break;
			case 5:
				System.out.println("[info] No implementado");
				System.out.println("\n~~ BAJA EMPLEADOS ~~");
				break;
				
			case 6:
				System.out.println("[info] No implementado");
				System.out.println("\n~~ RECUPERAR EMPLEADOS ~~");
				break;

			case 7:
				System.out.println("[info] No implementado");
				System.out.println("\n~~ ESTADISTICAS TICKET ~~");

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
