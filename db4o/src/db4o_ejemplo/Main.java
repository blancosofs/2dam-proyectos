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
			System.out.println("2. Mostrar (Read)");
			System.out.println("3. Actualizacion (Update)");
			System.out.println("4. Borrado (Delete)");
			System.out.println("0. Salir");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				create(f);
				break;
			case 2:
				read(f);
				break;
			case 3:
				update(f);
				read(f);
				break;
			case 4:
				delete(f);
				read(f);
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

			Estudiantes est1 = new Estudiantes(1, "Samuel", 21, 7);
			db.store(est1);
			Estudiantes est2 = new Estudiantes(2, "Ashley", 19, 7);
			db.store(est2);
			Estudiantes est3 = new Estudiantes(3, "Sofia", 19, 7);
			db.store(est3);

			System.out.println(est1);
			System.out.println(est2);
			System.out.println(est3);

		} finally {
			db.close();
		}
	}

	public static void read(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
		try {
			
			Estudiantes estRead = new Estudiantes();

			ObjectSet<Estudiantes> result = db.queryByExample(estRead);

			while (result.hasNext()) {
				System.out.println(result.next());
			}

		} finally {
			db.close();
		}
	}

	public static void update(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
		try {

			Estudiantes estUpdate= new Estudiantes(0,"Samuel",0,0);

			ObjectSet<Estudiantes> result = db.queryByExample(estUpdate);

			if (result.hasNext()) {
				Estudiantes estUpdate2 = result.next();

				estUpdate2.setNotaFinal(10);

				db.store(estUpdate2);
				System.out.println(estUpdate2);
			}

		} finally {
			db.close();
		}
	}

	public static void delete(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
		try {
			// 1. Buscamos el objeto
			Estudiantes estDelete = new Estudiantes(0, "Sofia", 0, 0);
			ObjectSet<Estudiantes> result = db.queryByExample(estDelete);

			// 2. Lo borramos
			if (result.hasNext()) {
				Estudiantes estudianteborrar = result.next();
				db.delete(estudianteborrar);
				
			}
		} finally {
			db.close();
		}
	}
}
