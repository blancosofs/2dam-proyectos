package ui;

public class Main {


	public static void main(String[] args) {
		/**
		 * --------------------------------------------------------------
		 * Nombre: Sofía Blanco Calsina
		 * Asignatura: Acceso a Datos Conexion a la BBDD
		 * Entrega: Práctica Final – Tema 2
		 * Profesora: Beatriz
		 *
		 * ESTRUCTURA DEL PROYECTO:
		 * /src
		 *  ├── common/           → ControlErrores (comprobaciones)
		 *  ├── dao/              → Acceso a bbddd (DatosDAO, JuguetesDAO, EmpleadoDAO, VentaDAO)
		 *  └── ui/               → Interfaz de consola (JugueteriaBlanco, Menús)
		 *
		 *--------------------------------------------------------------
		 * 30/11
		 * Conexion a bbdd en JugueteriaBlanco 
		 * 
		 * ESTADO:
		 * Al menos 2 metodos de cada menu, funcional.
		 * Control de errores para el scarnner
		 * Comprobacion de bbdd vacia en juguetes y empleados
		 * Sigue el diagrama e/r
		 * 
		 * Falta:	
		 * Empleado
		 * 	2. Modificar los datos de un nuevo empleado
		 * 
		 * Venta
		 * 2. Realizar una devolucion
		 * 3. Producto mas vendido
		 * 4. Empleados que mas venden
		 * 
		 * Datos
		 * 3. Datos de los cambios de los empleados y pque
		 * 
		 * EJECUCIÓN Y PRUEBA:
		 * Inserts implementados:
		 * 20 juguetes 
		 * 20 empleados 
		 * 5 stands (A,B,C,D,E)
		 * 4 Zonas (Luna, Elisa, Mario, Rafa)
		 * 
		 * 
		 */
		JugueteriaBlanco.main(args);
	}

}
