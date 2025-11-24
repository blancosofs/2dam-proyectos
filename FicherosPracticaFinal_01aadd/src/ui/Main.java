package ui;

public class Main {

	public static void main(String[] args) {
		/**
		 * --------------------------------------------------------------
		 * Nombre: Sofía Blanco Calsina
		 * Asignatura: Acceso a Datos Ficheros (Java I/O)
		 * Entrega: Práctica Final – Tema 1
		 * Profesora: Beatriz
		 *
		 * ESTRUCTURA DEL PROYECTO:
		 * /src
		 *  ├── PF/               → MainBea (creación de ficheros iniciales)
		 *  ├── common/           → ControlErrores (comprobaciones y validaciones)
		 *  ├── dao/              → Acceso a ficheros (PlantaDAO, EmpleadoDAO, TicketDAO)
		 *  ├── domain/           → Clases de dominio (Planta, Empleado, Ticket)
		 *  ├── service/          → Lógica de negocio (GestorVendedorService, GestorGestorService)
		 *  └── ui/               → Interfaz de consola (ViveroBlanco, Menús)
		 *
		 *--------------------------------------------------------------
		 * 17/11
		 * ESTADO:
		 * Implementado hasta parte del punto 8.1 de la rúbrica
		 * 
		 * Falta:	
		 * 3. Modificar campos de plantas
		 * 4. Dar alta empleados
		 * 5. Dar baja empleados"
		 * 6. Recuperar baja empleado
		 * 7. Estadisticas
		 * 
		 * 
		 * EJECUCIÓN Y PRUEBA:
		 * Ejecutar la clase: ui.ViveroBlanco
		 * Credenciales de prueba 1:
		 *   ID: 1452
		 *   Contraseña: asb123
		 *   Cargo: vendedor  
		 *   
		 * Credenciales de prueba 2:
		 *   ID: 7532
		 *   Contraseña: xs21qw4
		 *   Cargo: gestor  
		 *
		 *-----------------------------------------------------------------
		 * 12/11
		 * ESTADO:
		 * Implementado hasta el punto 5.5 de la rúbrica.
		 * 
		 *
		 * EJECUCIÓN Y PRUEBA:
		 * Ejecutar la clase: ui.ViveroBlanco
		 * Credenciales de prueba:
		 *   ID: 1452
		 *   Contraseña: asb123
		 *   Cargo: vendedor  
		 *   
		 *  Nota: Si los ficheros no existen, el programa genera datos de demostración automáticamente aunque tienes solo 2 plantas y 2 empleados  
		 *  Nota: Sale contrasena invalida pque no cumple la expresion regular pero como si existe para empleado te deja seguir  
		 * 
		 * --------------------------------------------------------------
		 */

		ViveroBlanco.main(args);
	}

}
