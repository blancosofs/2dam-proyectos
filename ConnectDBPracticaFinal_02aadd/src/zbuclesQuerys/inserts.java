package zbuclesQuerys;

import java.util.Random;

public class inserts {

	public static void main(String[] args) {
		juguetes();
		empleados();
	}

	public static void juguetes() {
		Random rand = new Random();

		int idJuguete = 0;
		int numNombre = 0;
		int numDescripcion = 0;

		System.out.print("INSERT INTO juguete (idJuguete,Nombre,Descripcion,Precio,Cantidad_stock) VALUES");
		for (int i = 0; i < 20; i++) {
			StringBuilder Nombre = new StringBuilder("nombre");
			StringBuilder Descripcion = new StringBuilder("descripcion");
			idJuguete++;
			numNombre++;
			numDescripcion++;

			double[] precio = { 1.5, 2.3, 4.7, 5.0, 6.8, 7.1, 8.9, 9.4, 10.2, 11.6, 12.0, 13.3, 14.8, 15.5, 16.9, 17.4,
					18.2, 19.7, 20.1, 21.5 };
			int aleatorioPrecio = rand.nextInt(precio.length);

			int[] cant_stock = { 5, 12, 3, 20, 15, 7, 9, 4, 18, 6, 10, 2, 25, 8, 14, 11, 1, 16, 13, 19 };
			int aleatorioStock = rand.nextInt(cant_stock.length);

			System.out.println(
					" (" + idJuguete + ",'" + Nombre.append(numNombre) + "','" + Descripcion.append(numDescripcion)
							+ "'," + precio[aleatorioPrecio] + "," + cant_stock[aleatorioStock] + ") ,");
			Nombre.setLength(0);
			Descripcion.setLength(0);
		}
	}
	
	public static void empleados() {
		Random rand = new Random();

		int numNombre = 0;

		System.out.print("INSERT INTO empleado (idEmpleado,Nombre,Cargo,Fecha_ingreso) VALUES");
		for (int i = 0; i < 20; i++) {
			StringBuilder Nombre = new StringBuilder("nombre");
			numNombre++;

			String[] cargo = { "jefe","cajero" };
			int aleatorioCargo = rand.nextInt(cargo.length);

			System.out.println(
					" ( DEFAULT,'" + Nombre.append(numNombre) + "','" + cargo[aleatorioCargo]
							+ "',NULL) ,");
			Nombre.setLength(0);
		}
	}

}
