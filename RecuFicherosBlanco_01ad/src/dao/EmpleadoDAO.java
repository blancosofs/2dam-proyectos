package dao;

import java.util.ArrayList;

import java.io.*;

import domain.Empleado;

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
	
	
	

}
