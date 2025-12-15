package db4o;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class prueba {

	public static void main(String[] args) {
		String DBOO_EJEM = "databaseFile.db4o";
		ObjectContainer db = Db4oEmbedded.openFile(DBOO_EJEM);
		try {
			Estudiantes est1 = new Estudiantes("E1", 6);
			db.store(est1);
			System.out.println("Stored " + est1);
			
			Estudiantes est2 =new Estudiantes("E2",7);
			db.store(est2);
			System.out.println("Stored "+est2);
		} finally {
			db.close();
		}
	}
}

