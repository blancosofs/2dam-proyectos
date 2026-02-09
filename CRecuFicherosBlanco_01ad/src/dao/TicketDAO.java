package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import domain.Ticket;
import domain.VentaPlanta;

public class TicketDAO {

	public static void escribirPorFicheroTicket(Ticket t) {
		File carpeta = new File("TICKETS");
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		try {
			File ficheroTXT = new File(carpeta, t.getNumTicket() + ".txt");
			FileWriter fw = new FileWriter(ficheroTXT);

			fw.write("Número Ticket:" + t.getNumTicket() + "\n");
			fw.write("—————————————————————————//———————————————————————————————\n");
			fw.write("Empleado que ha atendido:" + t.getCodigoEmpleado() + "\n");
			fw.write("Nombre del empleado:" + t.getNombreEmpleado() + "\n\n");
			fw.write("CodigoProducto         Cantidad           PrecioUnitario \n");
			for (VentaPlanta v : t.getVentaPlanta()) {
				fw.write(":" + v.getCodigoProducto() + "                      " + ":" + v.getCantidad()
						+ "                    " + ":" + v.getPrecioUnidad() + "\n");
			}
			//
			fw.write("———————————————————————————//—————————————————————————————\n");
			fw.write("\tTotal:  €" + t.getTotalVenta() + "\n");

			fw.close();

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static Ticket extrarObjetoTicket(int numTicketDevolver) {
		Ticket ticket = null;

		File carpeta = new File("TICKETS");
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		try {
			Ticket t;

			// sacar datos con buffer reader de ticket
			// saca tambien lo de venta aqui pque en el dao es un lio

			File file = new File("TICKETS", numTicketDevolver + ".txt");
			FileReader fileReader = new FileReader(file); // tuberia
			BufferedReader bufferedReader = new BufferedReader(fileReader); // FileReader al BufferedReader

			ArrayList<VentaPlanta> vp = new ArrayList<>();

			int codigoEmpleado = 0;
			String nombreEmpleado = "";
			float totalVenta = 0;
			LocalDate fechaVenta = LocalDate.now();

			String linea = null;

			// String cadena[] = null; // esto es lo que te da error y se va a nullpointer
			StringBuilder sb = new StringBuilder();

			while ((linea = bufferedReader.readLine()) != null) {

				if (linea.startsWith("Empleado que ha atendido:")) {
					sb.append(linea.substring(25)).append("==");

				} else if (linea.startsWith("Nombre del empleado:")) {

					sb.append(linea.substring(20)).append("==");

				} else if (linea.startsWith(":")) {
					String linea2 = linea.trim();

					String[] cadena2 = linea2.split(":");

					int codigoProducto = Integer.parseInt(cadena2[1].trim());
					int cantidad = Integer.parseInt(cadena2[2].trim());
					float precioUnitario = Float.parseFloat(cadena2[3].trim());
					// String[] cadena2 = linea.substring(0, 6).split(":");
					// String codigoProductoS = cadena2[0];
					// codigoProducto = Integer.parseInt(codigoProductoS);

					VentaPlanta vpExtraer = new VentaPlanta(codigoProducto, precioUnitario, cantidad);

					// String cantidadS = cadena2[1];
					// cantidad = Integer.parseInt(cantidadS);

					// String precioUnitarioS = cadena2[2];
					// precioUnitario = Integer.parseInt(precioUnitarioS);

					vp.add(vpExtraer);

				} else if (linea.startsWith("\tTotal:  €")) {
					sb.append(linea.substring(10)).append("==");
					// String total = cadena[5];
					// totalVenta = Float.parseFloat(total);
				}
			}
			String cadena[] = sb.toString().split("==");

			String ce = cadena[0];
			codigoEmpleado = Integer.parseInt(ce);

			nombreEmpleado = cadena[1];

			String tot = cadena[2];
			totalVenta = Float.parseFloat(tot);

			ticket = new Ticket(codigoEmpleado, nombreEmpleado, fechaVenta, vp, totalVenta, true);
			bufferedReader.close();

		} catch (Exception i) {
			i.printStackTrace();
		}
		return ticket;
	}

	public static void escribirDevuelto(Ticket t) {
		File carpeta = new File("TICKETS");
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		try {
			File ficheroTXT = new File(carpeta, t.getNumTicket() + ".txt");
			FileWriter fw = new FileWriter(ficheroTXT);

			fw.write("Número Ticket:" + t.getNumTicket() + "\n");
			fw.write("—————————————————————————//———————————————————————————————\n");
			fw.write("Empleado que ha atendido:" + t.getCodigoEmpleado() + "\n");
			fw.write("Nombre del empleado:" + t.getNombreEmpleado() + "\n\n");
			fw.write("CodigoProducto         Cantidad           PrecioUnitario \n");
			for (VentaPlanta v : t.getVentaPlanta()) {
				fw.write("-" + v.getCodigoProducto() + "                      " + "-" + v.getCantidad()
						+ "                    " + "-" + v.getPrecioUnidad() + "\n");
			}
			//
			fw.write("———————————————————————————//—————————————————————————————\n");
			fw.write("\tTotal:  -€" + t.getTotalVenta() + "\n");
			fw.write("\t\n\nDEVUELTO\n");

			fw.close();

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void escribirDevuelto2(Ticket t, int numTicketBuscar) {
		File carpeta = new File("DEVOLUCIONES");
		File ficheroTXTbuscar = new File("TICKETS", numTicketBuscar + ".txt");

		try {

			if (!ficheroTXTbuscar.exists() || !ficheroTXTbuscar.isFile()) {
				System.out.println("[error] Ticket " + numTicketBuscar + " no encontrado");
			} else {
				File destino = new File(carpeta, ficheroTXTbuscar.getName());
				if (ficheroTXTbuscar.renameTo(destino)) {
					System.out.println("[info] funciona cambiar a devoluciones");
					
					FileWriter fw = new FileWriter(destino);
					fw.write("Número Ticket:" + t.getNumTicket() + "\n");
					fw.write("—————————————————————————//———————————————————————————————\n");
					fw.write("Empleado que ha atendido:" + t.getCodigoEmpleado() + "\n");
					fw.write("Nombre del empleado:" + t.getNombreEmpleado() + "\n\n");
					fw.write("CodigoProducto         Cantidad           PrecioUnitario \n");
					for (VentaPlanta v : t.getVentaPlanta()) {
						fw.write("-" + v.getCodigoProducto() + "                      " + "-" + v.getCantidad()
								+ "                    " + "-" + v.getPrecioUnidad() + "\n");
					}
					//
					fw.write("———————————————————————————//—————————————————————————————\n");
					fw.write("\tTotal:  -€" + t.getTotalVenta() + "\n");
					fw.write("\t\n\nDEVUELTO\n");

					fw.close();
				} else {
					System.out.println("[error] mover");
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
