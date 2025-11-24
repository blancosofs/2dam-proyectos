package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.EmpleadoDAO;
import dao.PlantaDAO;
import domain.Empleado;
import domain.Planta;

public class ViveroBlanco {

	public static void main(String[] args) {
		// comprobar
		ControlErrores.comprobarArbolDirectorios();
		ControlErrores.comprobarPlantaXML();
		ControlErrores.comprobarPlantaDAT();
		ControlErrores.comprobarEmpleadoDATexiste();
		ControlErrores.comprobarPlantaBajaXML();
		ControlErrores.comprobarPlantaBajaDAT();

		// cargar
		File ficheroXML = new File("PLANTAS/plantas.xml");
		ArrayList<Planta> arrayXMLplanta = new ArrayList<>();
		arrayXMLplanta = PlantaDAO.leerXMLplanta(ficheroXML, arrayXMLplanta); // y acabas con una lista de plantitas sin
																				// precio ni stock
		File ficheroDAT = new File("PLANTAS/plantas.dat");
		ArrayList<Planta> arrayCatalogoPlantas = new ArrayList<>();
		arrayCatalogoPlantas = PlantaDAO.leerDATplanta(ficheroDAT, arrayXMLplanta); // ya tienes las plantitas y te las
																					// guardas directamente

		// lo q te salia de trza de error gigante nada mas salir. comprubas que teiens
		// algo dentro
		File ficheroDATescritura = new File("EMPLEADOS/empleado.dat");
		ArrayList<Empleado> arrayCatalogoEmpleado = new ArrayList<>();
		arrayCatalogoEmpleado = EmpleadoDAO.leerDATempleado();
		if (arrayCatalogoEmpleado == null || arrayCatalogoEmpleado.isEmpty()) {
			System.err.println("ERROR. empleados vacio, este es de prueba");
			System.out.println("Tienes dos empleados de demo, llos 3 buenos van en el creado por control de erroes");
			arrayCatalogoEmpleado = new ArrayList<>();
			Empleado empleadoDemoV = new Empleado(6666, "sofi", "aaaa1234", "vendedor");
			Empleado empleadoDemoG = new Empleado(4444, "sofs", "aaaa1234", "gestor");
			arrayCatalogoEmpleado.add(empleadoDemoV);
			arrayCatalogoEmpleado.add(empleadoDemoG);
		}

		// validar login
		Scanner sc = new Scanner(System.in);
		System.out.println("\n🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱");
		System.out.println("\t~~ BIENVENID@ AL VIVERO ~~");
		System.out.println("🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱\n");
		System.out.println("Le redirigiremos segun su cargo");
		System.out.println("Porfavor, introduzca sus credenciales: ");

		boolean empleadoLogeado = false;
		int intentos = 3;
		Empleado empleadoRegistrado = null;

		System.out.println("AVISO. Tienes 3 intentos para loggearte");
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
				bandera=false;
			}
			ControlErrores.validarCodigoEmpleado(id);
			ControlErrores.validarPwd(pwd);
			
			if (bandera) {
				for (Empleado empleadoIterator : arrayCatalogoEmpleado) { // buscar q coincide en el for
					if (empleadoIterator.getIdentificacion() == id && empleadoIterator.getPassword().equals(pwd)) {
						System.out.println("Empleado identificado");
						empleadoLogeado = true;

						empleadoRegistrado = empleadoIterator; // va pasandolos ordenaditos

						if (empleadoIterator.getCargo().equals("vendedor")) {
							MenuVendedor.mostrarMenuVendedor(empleadoRegistrado, arrayCatalogoPlantas);
						}
						if (empleadoIterator.getCargo().equals("gestor")) {
							MenuGestor.mostrarMenuGestor(empleadoRegistrado, arrayCatalogoPlantas, arrayCatalogoEmpleado);
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
