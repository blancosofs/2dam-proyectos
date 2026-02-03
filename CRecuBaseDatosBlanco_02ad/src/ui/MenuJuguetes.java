package ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.JuguetesDAO;
import domain.Juguete;

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
			System.out.println("4. Mostrar");
			System.out.println("0. MENU PRINCIPAL");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1. Registrar un nuevo juguete");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println("Introduzca los siguientes datos:\n");
				System.out.println("Nombre: ");
				String nombre = sc.nextLine();

				System.out.println("Descripcion: ");
				String descripcion = sc.nextLine();

				System.out.println("Precio: ");
				double precio = ControlErrores.controlErroresDouble(sc);

				System.out.println("Cantidad_stock: ");
				int cantidad_stock = ControlErrores.controlErroresInt(sc);

				JuguetesDAO.insertarJuguete(conexion, nombre, descripcion, precio, cantidad_stock);
				int idParaStock = JuguetesDAO.sacarId(conexion);
				JuguetesDAO.updateTablaStock(conexion, idParaStock, cantidad_stock);
				
				// mostrar
				ArrayList<Juguete> juguetes = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetes) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}
				break;
	
				case 2:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("2. Modificar los datos de los juguetes");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				// mostrar
				ArrayList<Juguete> juguetes2 = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetes2) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}

				System.out.println("Introduzca el id del juguete a modificar:");
				System.out.println("Id Juguete: ");
				int idJugueteB = ControlErrores.controlErroresInt(sc);
				Boolean bandera = JuguetesDAO.buscarJuguete(conexion, idJugueteB);

				if (!bandera) {
					System.err.println("[error] Juguete no encontrado");
				}

				System.out.println("Nombre: ");
				String nombreB = sc.nextLine();

				System.out.println("Descripcion: ");
				String descripcionB = sc.nextLine();

				System.out.println("Precio: ");
				double precioB = ControlErrores.controlErroresDouble(sc);

				System.out.println("Cantidad_stock: ");
				int cantidad_stockB = ControlErrores.controlErroresInt(sc);

				JuguetesDAO.modificarJuguete(conexion, idJugueteB, nombreB, descripcionB, precioB, cantidad_stockB);

				// mostrar
				ArrayList<Juguete> juguetes2B = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetes2B) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}

				break;
			case 3:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("3. Eliminar Juguetes");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				// mostrar
				JuguetesDAO.mostrar(conexion);
				System.out.println();

				System.out.println("Introduzca el id del juguete que quieres borrar");
				int idBorrar = ControlErrores.controlErroresInt(sc);
				Boolean bandera2 = JuguetesDAO.buscarJugueteBorrar(conexion, idBorrar);

				if (!bandera2) {
					System.err.println("[error] Juguete no encontrado");
				}

				JuguetesDAO.borrarJuguete(conexion, idBorrar);

				// mostrar
				ArrayList<Juguete> juguetes3 = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetes3) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}

				break;
			case 4:
				System.out.println("4. Mostrar");
				// mostrar
				ArrayList<Juguete> juguetesMostrar = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetesMostrar) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}
				break;
			case 0:
				System.out.println("Volviendo al menu de inicio...");
				JugueteriaBlanco.menuPrincipal(args, conexion);
				break;
			default:
				System.err.println("[ERROR] Opcion incorrecta");
				break;
			}
		} while (opc != 0);

		sc.close();
	}

}
