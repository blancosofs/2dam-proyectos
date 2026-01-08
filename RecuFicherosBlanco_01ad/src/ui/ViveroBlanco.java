package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.PlantaDAO;
import domain.Empleado;
import domain.Planta;

public class ViveroBlanco {

	public static void main(String[] args) {
		// comprobar
		ControlErrores.comprobarArbolDirectorios();
		ControlErrores.comprobarPlantaXML();
		ControlErrores.comprobarPlantaDAT();
		ControlErrores.comprobarPlantaBajaXML();
		ControlErrores.comprobarPlantaBajaDAT();
		ControlErrores.comprobarEmpleadoDAT();
		menuVivero();
	}

	public static void menuVivero() {
		// cargar
		File ficheroXML = new File("PLANTAS/plantas.xml");
		ArrayList<Planta> arrayXMLplanta = new ArrayList<>();
		arrayXMLplanta = PlantaDAO.leerXMLplanta(ficheroXML, arrayXMLplanta); // lista sin precio ni stock

		File ficheroDAT = new File("PLANTAS/plantas.dat");
		ArrayList<Planta> arrayCatalogoPlantas = new ArrayList<>();
		arrayCatalogoPlantas = PlantaDAO.leerDATplanta(ficheroDAT, arrayXMLplanta); // ya tienes las plantitas

		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n~~ BIENVENID@ AL VIVERO ~~");
		System.out.println("Le redirigiremos segun su cargo. Porfavor, introduzca sus credenciales: ");
		System.out.println();
		System.out.println(" * Credenciales de prueba Vendedor: \n" + "Cargo: vendedor\n" + "ID: 2712 \n"
				+ "Contraseña: Hola1 \n" + "* Credenciales de prueba Gestor: \n" + "Cargo: gestor\n" + "ID: 1310  \n"
				+ "Contraseña: Hola2");

		boolean empleadoLogeado = false;
		int intentos = 3;
		Empleado empleadoRegistrado = null;
		System.out.println();
		System.out.println("[aviso] Tienes 3 intentos para loggearte");
		int id = 0;
		String pwd = null;

		while (intentos > 0 && !empleadoLogeado) {
			boolean bandera = false;
			try {
				System.out.println("Introduzca su codigo de empleado (use numeros naturales)");
				id = ControlErrores.controlErroresInt(sc);
				System.out.println("Introduzca su contrasena");
				pwd = sc.next();
				bandera = true;
			} catch (Exception e) {
				System.err.println("ERROR. Numeros naturales porfi");
				sc.nextLine();
				bandera = false;
			}
			ControlErrores.validarCodigoEmpleado(id);
			ControlErrores.validarPwd(pwd);

			if (bandera) {
				ArrayList<Empleado> arrayCatalogoEmpleado = new ArrayList<>();
				Empleado empleado1 = new Empleado(2712, "Elisa", "Hola1", "vendedor");
				Empleado empleado2 = new Empleado(0234, "Miguel Angel", "123qwe", "vendedor");
				Empleado empleado3 = new Empleado(1310, "Rafael", "Hola2", "gestor");
				arrayCatalogoEmpleado.add(empleado1);
				arrayCatalogoEmpleado.add(empleado2);
				arrayCatalogoEmpleado.add(empleado3);

				for (Empleado empleadoIterator : arrayCatalogoEmpleado) { // buscar q coincide en el for
					if (empleadoIterator.getIdentificacion() == id && empleadoIterator.getPassword().equals(pwd)) {
						System.out.println("Empleado identificado");
						empleadoLogeado = true;
						empleadoRegistrado = empleadoIterator; // va pasandolos ordenaditos

						if (empleadoIterator.getCargo().equals("vendedor")) {
							MenuVendedor.mostrarMenuVendedor(empleadoRegistrado, arrayCatalogoPlantas);
						}
						if (empleadoIterator.getCargo().equals("gestor")) {
							MenuGestor.mostrarMenuGestor(empleadoRegistrado, arrayCatalogoPlantas,
									arrayCatalogoEmpleado);
						}
					}
				}
			}

			if (!empleadoLogeado) {
				intentos--;
				if (intentos > 0) {
					System.err.println(
							"ERROR. Tienes " + intentos + " intentos \n CUIDADO, EL PROGRAMA SE CERRARA SI TE PASA");
				} else {
					System.err.println("Se ha superado el numero de intentos");
				}
			}

		}

		sc.close();
	}

}
