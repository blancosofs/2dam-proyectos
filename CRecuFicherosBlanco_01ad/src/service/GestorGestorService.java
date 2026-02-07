package service;

import java.util.ArrayList;

import domain.Empleado;

public class GestorGestorService {

	public static void visualizarCatalogo(ArrayList<Empleado> arrayCatalogoEmpleados) {
		for (Empleado empleado : arrayCatalogoEmpleados) {
			System.out.println(empleado);
		}
	}

}
