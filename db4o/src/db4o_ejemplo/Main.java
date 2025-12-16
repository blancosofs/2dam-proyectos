package db4o_ejemplo;

import java.io.File;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {

	public static void main(String[] args) {
		File f = new File("personas.db4o");
		// f.delete();

		Scanner sc = new Scanner(System.in);
		System.out.println("# Ejemplo de uso db4o #");
		int opc = 0;
		do {
			System.out.println("Seleccione la opcion a probar");
			System.out.println("1. Insercion (Create)");
			System.out.println("2. Consulta (Read)");
			System.out.println("3. Actualizacion (Update)");
			System.out.println("4. Borrado (Delete)");
			System.out.println("0. Salir");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				create(f);
				break;

			case 2:
				break;
			case 3:
				break;

			case 4:
				break;

			case 0:
				System.out.println("Saliendo del  programa....");
				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opc != 0);
		sc.close();
	}

	public static void create(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());

		try {

			Estudiantes est1 = new Estudiantes("Samuel", 1, 7);
			db.store(est1);
			System.out.println(est1);

			Estudiantes est2 = new Estudiantes("Ashley", 2, 7);
			db.store(est2);
			System.out.println(est2);

		} finally {
			db.close();
		}
	}

	public static void read(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());

		try {

			// Creamos un estudiante "plantilla" solo con el dato que buscamos
			Estudiantes plantilla = new Estudiantes("Samuel", 0, 0);

			// Pedimos a la base de datos que busque objetos que coincidan
			ObjectSet<Estudiantes> resultado = db.queryByExample(plantilla);

			while (resultado.hasNext()) {
				System.out.println(resultado.next().getNombre());
			}

		} finally {
			db.close();
		}
	}
}
