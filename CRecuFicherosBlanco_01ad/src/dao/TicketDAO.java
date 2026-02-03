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
				fw.write(v.getCodigoProducto() + "                      " + v.getCantidad() + "                    "
						+ v.getPrecioUnidad() + "\n");
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
			String[] partes = linea.split(":");
			
			while ((linea = bufferedReader.readLine()) != null) {
				if (linea.equals("Empleado que ha atendido")) {
					
				}
			}

			ticket = new Ticket(codigoEmpleado, nombreEmpleado, fechaVenta, vp, totalVenta, false);

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
			fw.write("\tTotal:  €" + t.getTotalVenta() + "\n");
			fw.write("\t\n\nDEVUELTO\n");

			fw.close();

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
