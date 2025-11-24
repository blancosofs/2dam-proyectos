package common;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PF.MainBea;

public class ControlErrores {

	public static void comprobarArbolDirectorios() {
		File directorioPLANTAS = new File("PLANTAS");

		if (!directorioPLANTAS.exists()) {
			System.err.println("Falta el directorio plantas, va a ser creado antes de lanzar el vivero");
			directorioPLANTAS.mkdir();
		}
		File directorioEMPLEADOS = new File("EMPLEADOS");
		File directorioBAJAS = new File("EMPLEADOS/BAJAS");

		if (!directorioEMPLEADOS.exists()) {
			System.err.println("Falta el directorio Empleados, va a ser creado antes de lanzar el vivero");
			directorioEMPLEADOS.mkdir();
			if (!directorioBAJAS.exists()) {
				System.err.println(
						"Falta el directorio Bajas dentro de empleados, va a ser creado antes de lanzar el vivero");
				directorioBAJAS.mkdir();
			}
		}

		File directorioDEVOLUCIONES = new File("DEVOLUCIONES");

		if (!directorioDEVOLUCIONES.exists()) {
			System.err.println("Falta el directorio plantas, va a ser creado antes de lanzar el vivero");
			directorioDEVOLUCIONES.mkdir();
		}

		File directorioTICKETS = new File("TICKETS");

		if (!directorioTICKETS.exists()) {
			System.err.println("Falta el directorio Empleados, va a ser creado antes de lanzar el vivero");
			directorioTICKETS.mkdir();
		}

	}

	public static void comprobarPlantaXML() {
		File ficheroXML = new File("PLANTAS/plantas.xml");
		if (!ficheroXML.exists()) {
			System.err.println("El fichero que estas intentando leer no existe(plantas.xml)");
			System.err.println("Se procede a la creacion de plantas.xml (***ESTA VACIO!!***)");
			try {
				ficheroXML.createNewFile();
				// FileWriter escritura = new FileWriter(ficheroXML);
				// escritura.("");
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void comprobarPlantaDAT() {
		File ficheroDAT = new File("PLANTAS/plantas.dat");
		if (!ficheroDAT.exists()) {
			System.err.println("El fichero que estas intentando leer no existe(plantas.dat)");
			System.err.println("Se procede a la creacion de plantas.dat ");
			MainBea.EscribirFichero();
		}
	}

	public static void comprobarPlantaBajaXML() {
		File ficheroXML = new File("PLANTAS/plantasBaja.xml");
		if (!ficheroXML.exists()) {
			System.err.println("El fichero que estas intentando leer no existe(plantasBaja.xml)");
			System.err.println("Se procede a la creacion de plantasBaja.xml (***ESTA VACIO!!***)");
			try {
				ficheroXML.createNewFile();
				// FileWriter escritura = new FileWriter(ficheroXML);
				// escritura.("");
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void comprobarPlantaBajaDAT() {
		File ficheroDAT = new File("PLANTAS/plantasBaja.dat");
		if (!ficheroDAT.exists()) {
			System.err.println("El fichero que estas intentando leer no existe(plantasBaja.dat)");
			System.err.println("Se procede a la creacion de plantasBaja.dat ");
			MainBea.EscribirFichero();
		}
	}

	public static void comprobarEmpleadoDAT() {
		File ficheroDATescritura = new File("EMPLEADOS/empleado.dat");
		if (!ficheroDATescritura.exists()) {
			System.err.println("El fichero que estas intentando leer no existe(empleado.dat)");
			System.err.println("Se procede a la creacion de empleado.dat ");
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
			System.out.println("Cantidad invalida :( ");
			return false;
		}
	}
	
	public static boolean validarCodigo(int codigoVenta) {
		Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
		Matcher matcher = pattern.matcher(Integer.toString(codigoVenta));
		if (matcher.find()) {
			System.out.println("Codigo valida :) ");
			return true;
		} else {
			System.out.println("Codigo invalido :( ");
			return false;
		}
	}
}
