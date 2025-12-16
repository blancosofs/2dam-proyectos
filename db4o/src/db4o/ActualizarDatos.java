package db4o;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ActualizarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				File f = new File ("personas.db4o");
				f.delete();
				ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
				try {
					est2 est1 = new est2("E1", 6);
					ObjectSet<est2> resultado = db.queryByExample(est1);
					while(resultado.hasNext()) {
					    System.out.println(resultado.next().getName());
					}

					est1.addPoints(8);
					System.out.println("Stored " + est1);
					
					est2 est2 =new est2("E2",7);
					db.store(est2);
					//System.out.println("Stored "+est2);
				} finally {
					db.close();


			}
	}
}
