package ui;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import common.ControlErrores;
import dao.EmpleadoDAO;
import domain.Fecha;

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
			System.out.println("~~ 4. Mostrar");
			System.out.println("0. SALIR");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("1. Registrar un nuevo empleado");
				System.out.println("Introduzca los siguientes datos:");

				System.out.println("Id Empleado: ");
				int idEmpleado = ControlErrores.controlErroresInt(sc);

				sc.nextLine(); // limpia que se queda pillado

				System.out.println("Nombre: ");
				String nombre = sc.nextLine();

				System.out.println("Cargo: (jefe o cajero)");
				String cargo = sc.nextLine();

				System.out.println("Fecha_Ingreso (dia,mes,anyo)");
				int dia = ControlErrores.controlErroresInt(sc);
				int mes = ControlErrores.controlErroresInt(sc);
				int anyo = ControlErrores.controlErroresInt(sc);
				Fecha fecha_ingreso = new Fecha(dia, mes, anyo);

				Date fechaSQL = pasarFechaSQL(fecha_ingreso);

				EmpleadoDAO.insertarEmpleado(conexion, idEmpleado, nombre, cargo, fechaSQL);
				break;

			case 2:
				System.out.println("2. Modificar los datos de un nuevo empleado");

				break;
			case 3:
				System.out.println("3. Eliminar el empleado");
				System.out.println("Introduzca el id del empleado que quieres borrar");
				int idEmpleadoBorrar = ControlErrores.controlErroresInt(sc);
				Boolean bandera = EmpleadoDAO.buscarEmpleado(conexion, idEmpleadoBorrar);
				if (!bandera) {
					System.err.println("[error] Empleado no encontrado");
				}
				EmpleadoDAO.borrarEmpleado(conexion, idEmpleadoBorrar);
				break;

			case 4:
				System.out.println("~~ 4. Mostrar");
				EmpleadoDAO.mostrar(conexion);
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

	public static Date pasarFechaSQL(Fecha f) {
		LocalDate fechaLocal = LocalDate.of(f.getAnyo(), f.getMes(), f.getDia()); // Convertir dia, mes, año lo del sc a
																					// LocalDate
		return Date.valueOf(fechaLocal); // lo de antes a sql (revisa apuntes)
	}

}
