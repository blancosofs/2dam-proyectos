package common;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PF.MainBea;

public class ControlErrores {
	
	public static String controlErroresRespuesta(Scanner sc) {
		boolean error = true;
		String dato = "";
		do {
			dato = sc.nextLine().trim().toLowerCase();
			if (dato.equals("s") || dato.equals("n")) {
				error = false;
			} else {
				System.err.println("[error] Respuesta inválida (s / n)");
			}
		} while (error);
		return dato;
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
	
	
	public static int controlErroresInt2(Scanner sc) {
	    boolean error = true;
	    int dato = 0;

	    do {
	        if (sc.hasNextInt()) {
	            dato = sc.nextInt();
	            error = false;
	        } else {
	            System.err.println("ERROR. Tiene que ser un numero(int)");
	        }
	    } while (error);

	    return dato;
	}

	public static int controlErroresInt(Scanner sc) {
		boolean error = true;
		int dato = 0;
		do {
			if (sc.hasNextInt()) {
				dato = sc.nextInt();
				if (dato >= 0) {
					error = false;
				} else {
					System.err.println("ERROR. Tiene que ser un numero mayor a 0");
				}
			} else {
				System.err.println("ERROR. Tiene que ser un numero (int)");
			}
			sc.nextLine();
		} while (error);
		return dato;
	}
	
	public static float controlErroresFloat(Scanner sc) {
		boolean error = true;
		float dato = 0;
		do {
			if (sc.hasNextFloat()) {
				dato = sc.nextFloat();
				if (dato >= 0) {
					error = false;
				} else {
					System.err.println("ERROR. Tiene que ser un numero mayor a 0");
				}
			} else {
				System.err.println("ERROR. Tiene que ser un numero (float)");
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
	
	public static boolean validarTexto(String texto) {
		Pattern pattern = Pattern.compile("^[a-zA-z]+$");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) { 
			System.out.println("Texto valido :) ");
			return true;
		} else {
			System.err.println("ERROR. CARACTERES MAYUSCULAS Y MINUSCULAS DEL ABACEDARIO. Texto invalido :( ");
			return false;
		}
	}

	/* ANTES DE CARGAR EL VIVERO */

	public static void comprobarArbolDirectorios() {
		// carpeta plantas
		File directorioPLANTAS = new File("PLANTAS");
		if (!directorioPLANTAS.exists()) {
			System.out.println("[info] Falta el directorio plantas, va a ser creado antes de lanzar el vivero");
			directorioPLANTAS.mkdir();
		}
		// carpeta empleados
		File directorioEMPLEADOS = new File("EMPLEADOS");
		File directorioBAJAS = new File("EMPLEADOS/BAJAS");

		if (!directorioEMPLEADOS.exists()) {
			System.out.println("[info] Falta el directorio Empleados, va a ser creado antes de lanzar el vivero");
			directorioEMPLEADOS.mkdir();
			if (!directorioBAJAS.exists()) {
				System.out.println(
						"[info] Falta el directorio Bajas dentro de empleados, va a ser creado antes de lanzar el vivero");
				directorioBAJAS.mkdir();
			}
		}
		
		//carpeta tickets
		File directorioTICKETS = new File("TICKETS");
		if (!directorioTICKETS.exists()) {
			System.out.println("[info] Falta el directorio Tickets, va a ser creado antes de lanzar el vivero");
			directorioTICKETS.mkdir();
		}
		
		//carpeta devoluciones
		File directorioDEVOLUCIONES = new File("DEVOLUCIONES");
		if (!directorioDEVOLUCIONES.exists()) {
			System.out.println("[info] Falta el directorio Devoluciones, va a ser creado antes de lanzar el vivero");
			directorioDEVOLUCIONES.mkdir();
		}

	}

	public static void comprobarEmpleadoDAT() {
		File ficheroDATescritura = new File("EMPLEADOS/empleado.dat");
		if (!ficheroDATescritura.exists()) {
			System.err.println("[error] El fichero que estas intentando leer no existe (empleado.dat)");
			System.out.println("[info] Se procede a la creacion de empleado.dat ");
			MainBea.EscribirEmpleado();
		}
	}

	public static void comprobarPlantaDAT() {
		File ficheroDAT = new File("PLANTAS/plantas.dat");
		if (!ficheroDAT.exists()) {
			System.err.println("[error]  El fichero que estas intentando leer no existe(plantas.dat)");
			System.out.println("[info] Se procede a la creacion de plantas.dat");
			MainBea.EscribirFichero();
		}
	}

	public static void comprobarPlantaBajaDAT() {
		File ficheroDATbaja = new File("PLANTAS/plantasBaja.dat");
		if (!ficheroDATbaja.exists()) {
			System.err.println("[error]  El fichero que estas intentando leer no existe(plantasBaja.dat)");
			System.out.println("[info]  Se procede a la creacion de plantasBaja.dat (***ESTA VACIO!!***)");
			try {
				ficheroDATbaja.createNewFile();
			} catch (IOException e) {
				System.err.println("[error]  No se ha podido crear el fichero (plantasBaja.dat)");
			}
		}
	}

	public static void comprobarPlantaBajaXML() {
		File ficheroXMLbaja = new File("PLANTAS/plantasBaja.xml");
		if (!ficheroXMLbaja.exists()) {
			System.err.println("[error] El fichero que estas intentando leer no existe(plantasBaja.xml)");
			System.out.println("[info]  Se procede a la creacion de plantasBaja.xml (***ESTA VACIO!!***)");
			try {
				ficheroXMLbaja.createNewFile();
				FileWriter escritura = new FileWriter(ficheroXMLbaja);
				escritura.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void comprobarPlantaXML() {
		File ficheroXML = new File("PLANTAS/plantas.xml");
		if (!ficheroXML.exists()) {
			System.err.println("[error] El fichero que estas intentando leer no existe(plantas.xml)");
			System.out.println("[info] Se procede a la creacion de plantas.xml)");
			try {
				ficheroXML.createNewFile();
				FileWriter escritura = new FileWriter(ficheroXML);
				escritura.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				escritura.write("<plantas>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>1</codigo>\n");
				escritura.write("<nombre>Cactus</nombre>\n");
				escritura.write("<foto>cactus.jpg</foto>\n");
				escritura.write("<descripcion>Planta suculenta del desierto.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>2</codigo>\n");
				escritura.write("<nombre>Geranio</nombre>\n");
				escritura.write("<foto>geranio.jpg</foto>\n");
				escritura.write("<descripcion>Flor común de jardín con colores vivos.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>3</codigo>\n");
				escritura.write("<nombre>Helecho</nombre>\n");
				escritura.write("<foto>helecho.jpg</foto>\n");
				escritura.write("<descripcion>Planta de sombra con hojas verdes largas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>4</codigo>\n");
				escritura.write("<nombre>Rosa</nombre>\n");
				escritura.write("<foto>rosa.jpg</foto>\n");
				escritura.write("<descripcion>Flor ornamental con espinas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>5</codigo>\n");
				escritura.write("<nombre>Lavanda</nombre>\n");
				escritura.write("<foto>lavanda.jpg</foto>\n");
				escritura.write("<descripcion>Planta aromática de color violeta.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>6</codigo>\n");
				escritura.write("<nombre>Aloe Vera</nombre>\n");
				escritura.write("<foto>aloe_vera.jpg</foto>\n");
				escritura.write("<descripcion>Planta medicinal con hojas carnosas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>7</codigo>\n");
				escritura.write("<nombre>Menta</nombre>\n");
				escritura.write("<foto>menta.jpg</foto>\n");
				escritura.write("<descripcion>Planta aromática usada en infusiones.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>8</codigo>\n");
				escritura.write("<nombre>Bambú</nombre>\n");
				escritura.write("<foto>bambu.jpg</foto>\n");
				escritura.write("<descripcion>Planta de tallo alto y hueco, de rápido crecimiento.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>9</codigo>\n");
				escritura.write("<nombre>Orquídea</nombre>\n");
				escritura.write("<foto>orquidea.jpg</foto>\n");
				escritura.write("<descripcion>Flor exótica de gran valor ornamental.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>10</codigo>\n");
				escritura.write("<nombre>Hortensia</nombre>\n");
				escritura.write("<foto>hortensia.jpg</foto>\n");
				escritura.write("<descripcion>Planta de flores grandes y coloridas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>11</codigo>\n");
				escritura.write("<nombre>Palmera</nombre>\n");
				escritura.write("<foto>palmera.jpg</foto>\n");
				escritura.write("<descripcion>Árbol tropical con hojas largas en forma de abanico.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>12</codigo>\n");
				escritura.write("<nombre>Clavel</nombre>\n");
				escritura.write("<foto>clavel.jpg</foto>\n");
				escritura.write("<descripcion>Flor de colores vivos y aroma agradable.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>13</codigo>\n");
				escritura.write("<nombre>Jacinto</nombre>\n");
				escritura.write("<foto>jacinto.jpg</foto>\n");
				escritura.write("<descripcion>Planta bulbosa de flores perfumadas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>14</codigo>\n");
				escritura.write("<nombre>Petunia</nombre>\n");
				escritura.write("<foto>petunia.jpg</foto>\n");
				escritura.write("<descripcion>Flor de jardín muy colorida.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>15</codigo>\n");
				escritura.write("<nombre>Begonia</nombre>\n");
				escritura.write("<foto>begonia.jpg</foto>\n");
				escritura.write("<descripcion>Planta ornamental con hojas decorativas.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>16</codigo>\n");
				escritura.write("<nombre>Poto</nombre>\n");
				escritura.write("<foto>poto.jpg</foto>\n");
				escritura.write("<descripcion>Planta colgante de interior muy resistente.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>17</codigo>\n");
				escritura.write("<nombre>Crisantemo</nombre>\n");
				escritura.write("<foto>crisantemo.jpg</foto>\n");
				escritura.write("<descripcion>Flor típica de otoño en muchos colores.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>18</codigo>\n");
				escritura.write("<nombre>Romero</nombre>\n");
				escritura.write("<foto>romero.jpg</foto>\n");
				escritura.write("<descripcion>Planta aromática usada en la cocina mediterránea.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>19</codigo>\n");
				escritura.write("<nombre>Ficus</nombre>\n");
				escritura.write("<foto>ficus.jpg</foto>\n");
				escritura.write("<descripcion>Árbol o arbusto de interior muy popular.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("<planta>\n");
				escritura.write("<codigo>20</codigo>\n");
				escritura.write("<nombre>Jazmín</nombre>\n");
				escritura.write("<foto>jazmin.jpg</foto>\n");
				escritura.write("<descripcion>Planta trepadora de flores fragantes.</descripcion>\n");
				escritura.write("</planta>\n");
				escritura.write("</plantas>\n");
				escritura.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

}
