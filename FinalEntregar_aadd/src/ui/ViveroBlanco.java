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
		ControlErrores.comprobarEmpleadoDAT();
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
		File ficheroDATescritura = new File("EMPLEADOS/empleado.dat");
		ArrayList<Empleado> arrayCatalogoEmpleado = EmpleadoDAO.leerDATempleado();

		// validar login
		Scanner sc = new Scanner(System.in);
		System.out.println("~~ BIENVENID@ AL VIVERO ~~");
		System.out.println("Le redirigiremos segun su cargo");
		System.out.println("Porfavor, introduzca sus credenciales: ");

		boolean empleadoLogeado = false;
		int intentos = 3;
		Empleado empleadoRegistrado = null;

		while (intentos > 0 && !empleadoLogeado) {
			System.out.println("Introduzca su codigo de empleado (un numero del 1 al 9)");
			int id = sc.nextInt();
			System.out.println("Introduzca su contrasena");
			String pwd = sc.next();
			for (Empleado empleadoIterator : arrayCatalogoEmpleado) {
				if (empleadoIterator.getIdentificacion() == id && empleadoIterator.getPassword().equals(pwd)) {
					System.out.println("Empleado identificado");
					empleadoLogeado = true;
					empleadoRegistrado = empleadoIterator;
					if (empleadoIterator.getCargo().equals("vendedor")) {
						MenuVendedor.mostrarMenuVendedor(empleadoRegistrado, arrayCatalogoPlantas);
					} else if (empleadoIterator.getCargo().equals("gestor")) {
						MenuGestor.mostrarMenuGestor(empleadoRegistrado, arrayCatalogoPlantas, arrayCatalogoEmpleado);
					} else {
						System.err.println("ERROR.Cargo no valido");
						System.out.println("ERROR. Tienes " + intentos + " intentos \n CUIDADO, EL PROGRAMA SE CERRARA SI TE PASA");
						intentos--;
					}
				}
			}
			if (intentos == 0) {
				System.out.println("Se ha superado el numero de intentos");
			}
		}

		sc.close();
	}

}
