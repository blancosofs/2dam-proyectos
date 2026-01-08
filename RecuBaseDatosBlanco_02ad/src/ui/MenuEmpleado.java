package ui;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.EmpleadoDAO;

import domain.Empleado;

public class MenuEmpleado {

	public static void main(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println();
			System.out.println("~~~ [EMPLEADO] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Registrar un nuevo empleado");
			System.out.println("2. Modificar los datos de un nuevo empleado");
			System.out.println("3. Eliminar el empleado");
			System.out.println("4. Mostrar");
			System.out.println("0. MENU PRINCIPAL");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1. Registrar un nuevo empleado");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

				System.out.println("Introduzca los siguientes datos:\n");

				System.out.println("Nombre: ");
				String nombre = sc.nextLine();

				System.out.println("Cargo: (jefe o cajero)");
				String cargo = ControlErrores.controlErroresCargo(sc);

				// control de errores pqeu solo te aceota este formato
				System.out.println("[IMPORTANTE] PORFAVOR INTRODUCIR ANYO(4 DIGITOS) GUION(-) MES(2 DIGITOS) GUION(-) DIA(2 DIGITOS)");
				System.out.println("Fecha_Ingreso (yyyy-MM-dd);");
				String fechaTexto = sc.nextLine();

				LocalDate fechaSQL = LocalDate.parse(fechaTexto);

				// SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
				// java.util.Date fechaFormateada = formato.parse(fechaTexto);
				// java.sql.Date fechaSQL = new java.sql.Date(fechaFormateada);

				EmpleadoDAO.insertarEmpleado(conexion, nombre, cargo, fechaSQL);

				// mostrar
				ArrayList<Empleado> empleados = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleados) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
				}

				break;

			case 2:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("2. Modificar los datos de un empleado");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				// mostrar
				ArrayList<Empleado> empleados2 = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleados2) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
				}

				System.out.println("\nIntroduzca el id del empleado que quieres modificar\n");
				int idEmpleadoB = ControlErrores.controlErroresInt(sc);
				Boolean bandera = EmpleadoDAO.buscarEmpleadoModificar(conexion, idEmpleadoB);
				if (!bandera) {
					System.err.println("[error] Empleado no encontrado");
				}

				System.out.println("Nombre: ");
				String nombreB = sc.nextLine();

				System.out.println("Cargo: ");
				String cargoB = ControlErrores.controlErroresCargo(sc);

				System.out.println("[IMPORTANTE] PORFAVOR INTRODUCIR ANYO(4 DIGITOS) GUION(-) MES(2 DIGITOS) GUION(-) DIA(2 DIGITOS)");
				System.out.println("FechaIngreso (yyyy-MM-dd): ");
				String fechaTexto2 = sc.nextLine();
				LocalDate fechaSQL2 = LocalDate.parse(fechaTexto2);
				
				EmpleadoDAO.modificarEmpleado(conexion, nombreB, cargoB, fechaSQL2, idEmpleadoB);

				// mostrar
				ArrayList<Empleado> empleados2B = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleados2B) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
				}
				
				break;
			case 3:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("3. Eliminar el empleado");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n");
				// mostrar
				ArrayList<Empleado> empleados3A = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleados3A) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
				}

				System.out.println("\nIntroduzca el id del empleado que quieres borrar\n");
				int idEmpleadoBorrar = ControlErrores.controlErroresInt(sc);
				Boolean bandera3 = EmpleadoDAO.buscarEmpleado(conexion, idEmpleadoBorrar);
				if (!bandera3) {
					System.err.println("[error] Empleado no encontrado");
				}

				EmpleadoDAO.borrarEmpleado(conexion, idEmpleadoBorrar);

				// mostrar
				ArrayList<Empleado> empleados3 = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleados3) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
				}

				break;

			case 4:
				System.out.println("4. Mostrar");
				ArrayList<Empleado> empleadosMostrar = EmpleadoDAO.leerObjetoEmpleado(conexion);

				for (Empleado e : empleadosMostrar) {
					System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
							+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
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
