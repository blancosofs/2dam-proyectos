package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
				fw.write(v.getCodigoProducto() + "                      " + v.getCantidad() + "                    " + v.getPrecioUnidad() + "\n");
			}
			//
			fw.write("———————————————————————————//—————————————————————————————\n");
			fw.write("\tTotal:  €" + t.getTotalVenta() + "\n");

			fw.close();

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
