package ui;

import java.sql.Connection;
import java.util.Scanner;

import common.ControlErrores;
import dao.JuguetesDAO;

public class MenuJuguetes {

	public static void main(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println();
			System.out.println("~~~ [JUGETES] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Registrar un nuevo juguete");
			System.out.println("2. Modificar los datos de los juguetes");
			System.out.println("3. Eliminar Juguetes");
			System.out.println("~~ 4. Mostrar");
			System.out.println("0. SALIR");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("1. Registrar un nuevo juguete");
				System.out.println("Introduzca los siguientes datos:");

				System.out.println("Id Juguete: ");
				int idJuguete = ControlErrores.controlErroresInt(sc);

				sc.nextLine(); // limpia que se queda pillado

				System.out.println("Nombre: ");
				String nombre = sc.nextLine();

				System.out.println("Descripcion: ");
				String descripcion = sc.nextLine();

				System.out.println("Precio: ");
				double precio = sc.nextDouble();

				System.out.println("Cantidad_stock: ");
				int cantidad_stock = ControlErrores.controlErroresInt(sc);

				JuguetesDAO.insertarJuguete(conexion, idJuguete, nombre, descripcion, precio, cantidad_stock);
				break;

			case 2:
				System.out.println("2. Modificar los datos de los juguetes");
				System.out.println("Introduzca el id del juguete a modificar:");

				System.out.println("Id Juguete: ");
				int idJugueteB = ControlErrores.controlErroresInt(sc);
				Boolean bandera = JuguetesDAO.buscarJuguete(conexion, idJugueteB);

				if (!bandera) {
					System.err.println("[error] Juguete no encontrado");
				}

				sc.nextLine();

				System.out.println("Nombre: ");
				String nombreB = sc.nextLine();

				System.out.println("Descripcion: ");
				String descripcionB = sc.nextLine();

				System.out.println("Precio: ");
				double precioB = ControlErrores.controlErroresDouble(sc);

				System.out.println("Cantidad_stock: ");
				int cantidad_stockB = ControlErrores.controlErroresInt(sc);

				JuguetesDAO.modificarJuguete(conexion, idJugueteB, nombreB, descripcionB, precioB, cantidad_stockB);

				break;
			case 3:
				System.out.println("3. Eliminar Juguetes");
				System.out.println("Introduzca el id del juguete que quieres borrar");
				int idBorrar = ControlErrores.controlErroresInt(sc);
				Boolean bandera2 = JuguetesDAO.buscarJugueteBorrar(conexion, idBorrar);

				if (!bandera2) {
					System.err.println("[error] Juguete no encontrado");
				}

				JuguetesDAO.borrarJuguete(conexion, idBorrar);

				break;
			case 4:
				System.out.println("~~ 4. Mostrar");
				JuguetesDAO.mostrar(conexion);
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.err.println("[ERROR] Opcion incorrecta");
				break;
			}
		} while (opc != 0);

		sc.close();
	}

}
