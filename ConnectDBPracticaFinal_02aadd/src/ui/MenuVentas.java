package ui;

import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

import common.ControlErrores;
import dao.DatosDAO;
import dao.EmpleadoDAO;
import dao.JuguetesDAO;
import dao.VentaDAO;

public class MenuVentas {

	public static void main(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;

		do {
			System.out.println();
			System.out.println("~~~ [VENTAS] OPERACIONES BASICAS  ~~~");
			System.out.println("# Seleccione la tarea a realizar: #");
			System.out.println("1. Realizar una venta ");
			System.out.println("2. Realizar una devolucion");
			System.out.println("3. Producto mas vendido");
			System.out.println("4. Empleados que mas venden");
			System.out.println("~~5. Mostrar");
			System.out.println("0. SALIR");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("1. Realizar una venta ");
				JuguetesDAO.mostrar(conexion);
				System.out.println("Introduzca el juguete a comprar");
				int idJugueteB = ControlErrores.controlErroresInt(sc);
				boolean posibleVenta = JuguetesDAO.buscarJuguete(conexion, idJugueteB);

				if (!posibleVenta) {
					System.err.println("[error] Venta no posible. No existe el juguete");
				} else {
					System.out.println("Introduzca el id del empleado que realizara la venta");
					int idEmpleadoV = ControlErrores.controlErroresInt(sc);

					boolean empleadoExistente = EmpleadoDAO.buscarEmpleado(conexion, idEmpleadoV);
					if (!empleadoExistente) {
						System.err.println("[error] Venta no posible. No existe el empleado");
					} else {
						DatosDAO.mostrarStock(conexion);
						System.out.println("Introduzca el stand desde donde va a comprar");
						int idStandV = ControlErrores.controlErroresInt(sc);
						int idZonaV = JuguetesDAO.stock_idZonaBuscar(conexion, idStandV);

						System.out.println("Introduzca la cantidad a comprar");
						int cantidad = ControlErrores.controlErroresInt(sc);

						int stockActual = JuguetesDAO.comprobarStock(conexion, idStandV, idZonaV, idJugueteB);
						if (stockActual < cantidad) {
							System.err.println("[error] No hay suficiente stock " + stockActual);
						} else {
							Date fechaSQL = new Date(System.currentTimeMillis()); // fecha actual

							double precio = JuguetesDAO.precioJuguete(conexion, idJugueteB);
							double monto = precio * cantidad;

							System.out.println("Introduzca el tipo de pago");
							sc.nextLine();
							String tipoPago = ControlErrores.controlErroresPago(sc);

							VentaDAO.insertarVenta(conexion, fechaSQL, monto, tipoPago, idEmpleadoV, idStandV, idZonaV,
									idJugueteB, cantidad);
						}
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				VentaDAO.mostrar(conexion);
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
