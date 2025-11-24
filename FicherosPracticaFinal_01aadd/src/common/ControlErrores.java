package common;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PF.MainBea;

public class ControlErrores {

	public static void comprobarArbolDirectorios() {
		File directorioPLANTAS = new File("PLANTAS");

		if (!directorioPLANTAS.exists()) {
			System.out.println("INFO. Falta el directorio plantas, va a ser creado antes de lanzar el vivero");
			directorioPLANTAS.mkdir();
		}
		File directorioEMPLEADOS = new File("EMPLEADOS");
		File directorioBAJAS = new File("EMPLEADOS/BAJAS");

		if (!directorioEMPLEADOS.exists()) {
			System.out.println("INFO. Falta el directorio Empleados, va a ser creado antes de lanzar el vivero");
			directorioEMPLEADOS.mkdir();
			if (!directorioBAJAS.exists()) {
				System.out.println(
						"INFO. Falta el directorio Bajas dentro de empleados, va a ser creado antes de lanzar el vivero");
				directorioBAJAS.mkdir();
			}
		}

		File directorioDEVOLUCIONES = new File("DEVOLUCIONES");

		if (!directorioDEVOLUCIONES.exists()) {
			System.out.println("INFO. Falta el directorio plantas, va a ser creado antes de lanzar el vivero");
			directorioDEVOLUCIONES.mkdir();
		}

		File directorioTICKETS = new File("TICKETS");

		if (!directorioTICKETS.exists()) {
			System.out.println("INFO. Falta el directorio Empleados, va a ser creado antes de lanzar el vivero");
			directorioTICKETS.mkdir();
		}

	}

	public static void comprobarPlantaXML() {
		File ficheroXML = new File("PLANTAS/plantas.xml");
		if (!ficheroXML.exists()) {
			System.err.println("ERROR. El fichero que estas intentando leer no existe(plantas.xml)");
			System.out.println("INFO. Se procede a la creacion de plantas.xml)");
			System.out.println(" ~~~~~ Tienes dos plantitas de demo, las 20 estan en el fichero bueno");
			try {
				ficheroXML.createNewFile();
				FileWriter escritura = new FileWriter(ficheroXML);
				escritura.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
				escritura.write("<plantas> \n");
				escritura.write("<planta> \n");
				escritura.write("<codigo>1</codigo> \n");
				escritura.write("<nombre>captus</nombre> \n");
				escritura.write("<foto>X</foto> \n");
				escritura.write("<descripcion>Ninguna</descripcion> \n");
				escritura.write("</planta> \n");
				escritura.write("<planta> \n");
				escritura.write("<codigo>2</codigo> \n");
				escritura.write("<nombre>Geranio</nombre> \n");
				escritura.write("<foto>X</foto> \n");
				escritura.write("<descripcion>Ninguna</descripcion> \n");
				escritura.write("</planta> \n");
				escritura.write("</plantas> \n");
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void comprobarPlantaDAT() {
		File ficheroDAT = new File("PLANTAS/plantas.dat");
		if (!ficheroDAT.exists()) {
			System.err.println("ERROR. El fichero que estas intentando leer no existe(plantas.dat)");
			System.out.println("INFO. Se procede a la creacion de plantas.dat (***ESTA VACIO!!***)");
			MainBea.EscribirFichero();
		}
	}

	public static void comprobarPlantaBajaXML() {
		File ficheroXML = new File("PLANTAS/plantasBaja.xml");
		if (!ficheroXML.exists()) {
			System.err.println("ERROR.El fichero que estas intentando leer no existe(plantasBaja.xml)");
			System.out.println("INFO. Se procede a la creacion de plantasBaja.xml (***ESTA VACIO!!***)");
			try {
				ficheroXML.createNewFile();
				FileWriter escritura = new FileWriter(ficheroXML);
				escritura.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void comprobarPlantaBajaDAT() {
		File ficheroDAT = new File("PLANTAS/plantasBaja.dat");
		if (!ficheroDAT.exists()) {
			System.err.println("ERROR. El fichero que estas intentando leer no existe(plantasBaja.dat)");
			System.out.println("INFO. Se procede a la creacion de plantasBaja.dat (***ESTA VACIO!!***)");
			MainBea.EscribirFichero();
		}
	}

	public static void comprobarEmpleadoDATexiste() {
		File ficheroDATescritura = new File("EMPLEADOS/empleado.dat");
		if (!ficheroDATescritura.exists()) {
			System.err.println("ERROR. El fichero que estas intentando leer no existe(empleado.dat)");
			System.out.println("INFO. Se procede a la creacion de empleado.dat ");
			MainBea.EscribirEmpleado();
		}
	}

	public static boolean validarCantidad(int cantidadVenta) {
		Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
		Matcher matcher = pattern.matcher(Integer.toString(cantidadVenta));
		if (matcher.find()) {
			System.out.println("Cantidad valida :) ");
			return true;
		} else {
			System.err.println("Cantidad invalida :( ");
			return false;
		}
	}

	public static boolean validarCodigo(int codigoVenta) {
		Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
		Matcher matcher = pattern.matcher(Integer.toString(codigoVenta));
		if (matcher.find() && codigoVenta > 0) {
			System.out.println("Codigo valido :) ");
			return true;
		} else {
			System.err.println("Codigo invalido :( ");
			return false;
		}
	}

	public static boolean validarCodigoEmpleado(int id) {
		Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
		Matcher matcher = pattern.matcher(Integer.toString(id));
		if (matcher.find() && id > 0) { // el id>0 para que sean numeros naturales
			System.out.println("CodigoEmpleado valido :) ");
			return true;
		} else {
			System.err.println("CodigoEmpleado invalido :( ");
			return false;
		}
	}

	public static boolean validarPwd(String pwd) {
		if (pwd == null) {
			System.err.println("ERROR. Contraseña nula");
			return false;
		}
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{5,7}$");
		Matcher matcher = pattern.matcher(pwd);

		if (matcher.find()) {
			System.out.println("ContraseñaPwd valida :) ");
			return true;
		} else {
			System.err.println("ContraseñaPwd invalida :( ");
			return false;
		}
	}

	public static int controlErroresInt(Scanner sc) {
		boolean error = true;
		int dato = 0;
		do {
			if (sc.hasNextInt()) {
				dato = sc.nextInt();
				error = false;
			} else {
				System.err.println("ERROR. Tiene que ser int");
			}
			sc.nextLine();
		} while (error);
		return dato;
	}
	
	
	public static boolean validarNumTicket(int numTicketDevolver) {
		Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
		Matcher matcher = pattern.matcher(Integer.toString(numTicketDevolver));
		if (matcher.find() && numTicketDevolver > 0) { // el id>0 para que sean numeros naturales
			System.out.println("numTicket a Devolver valido :) ");
			return true;
		} else {
			System.err.println("ERROR. NUM NATURAL 0-9 ENTRE 1Y4 DIGITOS. numTicket a Devolver invalido :( ");
			return false;
		}
	}

}
