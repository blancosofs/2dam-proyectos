package dao;

import java.util.ArrayList;

import java.io.*;

import domain.Empleado;
import domain.Planta;

public class EmpleadoDAO {

	public static ArrayList<Empleado> leerDATempleado() {
		ArrayList<Empleado> listaEmpleados = null;

		try (FileInputStream ficherolectura = new FileInputStream("EMPLEADOS/empleado.dat");
				ObjectInputStream lectura = new ObjectInputStream(ficherolectura)) {

			// Leer el ArrayList de Empleado desde el archivo
			listaEmpleados = (ArrayList<Empleado>) lectura.readObject();
			System.out.println("Objetos leídos correctamente desde empleado.dat");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listaEmpleados;
	}

	public static void nuevoEmpleado(Empleado empleadoA) {

		try {

			RandomAccessFile raf = new RandomAccessFile("EMPLEADOS/empleado.dat", "rw");
			raf.seek(raf.length()); // al final del fichero
			raf.writeInt(empleadoA.getIdentificacion());
			// el raf escribe en bytes, por eso no hay string
			raf.writeUTF(empleadoA.getNombre());
			raf.writeUTF(empleadoA.getPassword());
			raf.writeUTF(empleadoA.getCargo());

			raf.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
