package ui;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import common.ControlErrores;
import dao.EmpleadoDAO;
import dao.JuguetesDAO;
import dao.VentaDAO;
import domain.Cambio;
import domain.Empleado;
import domain.Juguete;
import domain.Venta;

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
			System.out.println("5. Mostrar");
			System.out.println("0. MENU PRINCIPAL");
			opc = ControlErrores.controlErroresInt(sc);

			switch (opc) {
			case 1:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1. Realizar una venta ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n");

				// mostrar
				ArrayList<Juguete> juguetesMostrar = JuguetesDAO.leerObjetoJuguete(conexion);
				for (Juguete j : juguetesMostrar) {
					System.out.println("Juguete [id=" + j.getId() + ", nombre=" + j.getNombre() + ", descripcion=" + j.getDescripcion() + ", precio=" + j.getPrecio()
							+ ", cantidad_stock=" + j.getCantidad_stock() + "]");
				}
				System.out.println("\nIntroduzca el juguete a comprar");
				int idJugueteB = ControlErrores.controlErroresInt(sc);

				boolean posibleVenta = JuguetesDAO.buscarJuguete(conexion, idJugueteB);

				/*COMPROBAR ID*/
				if (!posibleVenta) {
					System.err.println("[error] Venta no posible. No existe el juguete");
				} else {
					System.out.println("\nIntroduzca la fecha de venta");
					System.out.println("[IMPORTANTE] PORFAVOR INTRODUCIR ANYO(4 DIGITOS) GUION(-) MES(2 DIGITOS) GUION(-) DIA(2 DIGITOS)");
					System.out.println("Fecha de venta (yyyy-MM-dd): ");
					String fechaTexto = sc.nextLine();
					LocalDate fechaSQL = LocalDate.parse(fechaTexto);
					
					// mostrar
					ArrayList<Empleado> empleadosMostrar = EmpleadoDAO.leerObjetoEmpleado(conexion);

					for (Empleado e : empleadosMostrar) {
						System.out.println("Empleado [id=" + e.getId() + ", nombre=" + e.getNombre() + ", cargo="
								+ e.getCargo() + ", fechaIngreso=" + e.getFechaIngreso() + "]");
					}
					System.out.println("\nIntroduzca el id del empleado que realizara la venta");
					int idEmpleadoV = ControlErrores.controlErroresInt(sc);

					boolean empleadoExistente = EmpleadoDAO.buscarEmpleado(conexion, idEmpleadoV);
					/* COMPROBAR EMPLEADO */
					if (!empleadoExistente) {
						System.err.println("[error] Venta no posible. No existe el empleado");
					} else {
						// mostrar
						VentaDAO.mostrarStand(conexion);
						System.out.println("\nIntroduzca el stand desde donde va a comprar");
						int idStandV = ControlErrores.controlErroresInt(sc);
						int idZonaV = JuguetesDAO.stock_idZonaBuscar(conexion, idStandV);
						
						//mostrar
						VentaDAO.mostrarStock(conexion,idStandV,idJugueteB);
						System.out.println("\nIntroduzca la cantidad a comprar");
						int cantidad = ControlErrores.controlErroresInt(sc);

						int stockActual = JuguetesDAO.comprobarStock(conexion, idStandV, idZonaV, idJugueteB);

						/*COMPROBAR STOCK*/
						if (stockActual < cantidad) {
							System.err.println("[error] No hay suficiente stock " + stockActual);
						} else {
							double precio = JuguetesDAO.precioJuguete(conexion, idJugueteB);
							double monto = precio * cantidad;

							System.out.println("Introduzca el tipo de pago (efectivo / tarjeta / paypal)");
							String tipoPago = ControlErrores.controlErroresPago(sc);

							VentaDAO.insertarVenta(conexion, fechaSQL, monto, tipoPago, idEmpleadoV, idStandV, idZonaV,
									idJugueteB, cantidad);
							
							ArrayList<Venta> ventaMostrar = VentaDAO.mostrar(conexion);

							for (Venta v : ventaMostrar) {
								System.out.println("Venta [id=" + v.getId() + ", fecha=" + v.getFecha() + ", monto=" + v.getMonto() + ", tipoPago=" + v.getTipoPago() + ", id_empleado="
										+ v.getId_empleado() + ", id_stand=" + v.getId_stand() + ", id_zona=" + v.getId_zona() + ", id_juguete=" + v.getId_juguete() + "]");
							}
						}
					}
				}

				break;
			case 2:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("2. Realizar una devolucion/cambio ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				//mostrar
				ArrayList<Venta> ventaMostrar2 = VentaDAO.mostrar(conexion);

				for (Venta v : ventaMostrar2) {
					System.out.println("Venta [id=" + v.getId() + ", fecha=" + v.getFecha() + ", monto=" + v.getMonto() + ", tipoPago=" + v.getTipoPago() + ", id_empleado="
							+ v.getId_empleado() + ", id_stand=" + v.getId_stand() + ", id_zona=" + v.getId_zona() + ", id_juguete=" + v.getId_juguete() + "]");
				}
				
				System.out.println("\nIntroduzca el id de la venta a cambiar");
				int idVentaC = ControlErrores.controlErroresInt(sc);

				boolean existeVenta = VentaDAO.buscarVenta(conexion, idVentaC);
			
				/*COMPROBAR ID*/
				if (!existeVenta) {
					System.err.println("[error] Cambio no posible. No existe el id de venta seleccionado");
				} else {
					/*COMPROBAR MOTIVO*/
					System.out.println("Introduzca el motivo de la devolucion");
					String motivo = sc.nextLine();
					
					/*COMPROBAR FECHA*/
					System.out.println("Introduzca la fecha de cambio");
					System.out.println("[IMPORTANTE] PORFAVOR INTRODUCIR ANYO(4 DIGITOS) GUION(-) MES(2 DIGITOS) GUION(-) DIA(2 DIGITOS)");
					System.out.println("Fecha de venta (yyyy-MM-dd): ");
					String fechaTexto2 = sc.nextLine();
					LocalDate fechaSQL2 = LocalDate.parse(fechaTexto2);
					
					/*COMPROBAR EMPLEADO*/
					System.out.println("\nIntroduzca el id del empleado que realizo la venta\n");
					int idEmpleadoC = ControlErrores.controlErroresInt(sc);
					Boolean bandera = VentaDAO.buscarEmpleado(conexion, idEmpleadoC);
					if (!bandera) {
						System.err.println("[error] Empleado no encontrado");
					}else {
						
						VentaDAO.insertarCambio(conexion, motivo, fechaSQL2, idEmpleadoC);

						//mostrar
						ArrayList<Cambio> cambiosMostrar = VentaDAO.mostrarCambio(conexion);

						for (Cambio c : cambiosMostrar) {
							System.out.println("Cambio [idCambio=" + c.getIdCambio() + ", motivo=" + c.getMotivo() + ", fecha=" + c.getFecha()
									+ ", STOCK_STAND_idStand_Original=" + c.getSTOCK_STAND_idStand_Original()
									+ ", STOCK_STAND_ZONA_idzona_Original=" + c.getSTOCK_STAND_ZONA_idzona_Original()
									+ ", STOCK_JUGUETE_idJuguete_Original=" + c.getSTOCK_JUGUETE_idJuguete_Original()
									+ ", STOCK_STAND_idStand_Nuevo=" + c.getSTOCK_STAND_idStand_Nuevo() + ", STOCK_STAND_ZONA_idzona_Nuevo="
									+ c.getSTOCK_STAND_ZONA_idzona_Nuevo() + ", STOCK_JUGUETE_idJuguete_Nuevo=" + c.getSTOCK_JUGUETE_idJuguete_Nuevo()
									+ ", EMPLEADO_idEMPLEADO=" + c.getEMPLEADO_idEMPLEADO() + "]");
						}
						
					}
					
				}
	
				break;
				
			case 3:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("3. Producto mas vendido ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
				VentaDAO.productoMasVendido(conexion);
				
				break;
				
			case 4:
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("4. Empleados que mas venden ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
				VentaDAO.empleadosMasVenden(conexion);
				
				break;
			case 5:
				System.out.println("5.Mostrar");
				// mostrar
				ArrayList<Venta> ventaMostrar = VentaDAO.mostrar(conexion);
				for (Venta v : ventaMostrar) {
					System.out.println("Venta [id=" + v.getId() + ", fecha=" + v.getFecha() + ", monto=" + v.getMonto()
							+ ", tipoPago=" + v.getTipoPago() + ", id_empleado=" + v.getId_empleado() + ", id_stand="
							+ v.getId_stand() + ", id_zona=" + v.getId_zona() + ", id_juguete=" + v.getId_juguete()
							+ "]");
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
