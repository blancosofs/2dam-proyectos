package db4o;


import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import db4o_ejemplo.Estudiantes;

public class prueba {

	public static void main(String[] args) {
		File f = new File ("personas.db4o");
		f.delete();
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
		try {
			est2 est1 = new est2("E1", 6);
			db.store(est1);
			//System.out.println("Stored " + est1);
			
			est2 est2 =new est2("E2",7);
			db.store(est2);
			//System.out.println("Stored "+est2);
		} finally {
			db.close();
		}
	}
	

	public static void update(File f) {
		ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
		try {
			
			Estudiantes estUpdate = new Estudiantes(0,"Samuel", 0, 0);

			ObjectSet<Estudiantes> result =  db.queryByExample(estUpdate);

			if(result.hasNext()) {
				Estudiantes estUpdate2 = result.next();

				estUpdate2.setNotaFinal(10);

				db.store(estUpdate2);
			}
			
		} finally {
			db.close();
		}
	}
}

