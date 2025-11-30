package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuguetesDAO {

	public static void mostrar(Connection conexion) {

		try {
			String consulta = "SELECT * FROM juguete";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int idJuguete = resultado.getInt("idJuguete");
				String Nombre = resultado.getString("Nombre");
				String Descripcion = resultado.getString("Descripcion");
				Double Precio = resultado.getDouble("Precio");
				int Cantidad_stock = resultado.getInt("cantidad_stock");
				System.out.println();
				System.out.println("idJuguete: " + idJuguete + ", Nombre: " + Nombre + ", Descripcion: " + Descripcion
						+ ", Precio: " + Precio + ", Cantidad_stock: " + Cantidad_stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertarJuguete(Connection conexion, int idJuguete, String nombre, String descripcion,
			double precio, int cantidad_stock) {
		try {
			String consulta = "INSERT INTO juguete VALUES (?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, idJuguete);
			sentencia.setString(2, nombre);
			sentencia.setString(3, descripcion);
			sentencia.setDouble(4, precio);
			sentencia.setInt(5, cantidad_stock);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("---\nId Juguete:" + idJuguete + " Nombre: " + nombre + " Descripcion: "
						+ descripcion + " Precio: " + precio + " Cantidad de stock: " + cantidad_stock + "\n-----");
			} else {

				System.out.println("No se pudo insertar el juguete");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void borrarJuguete(Connection conexion, int idBorrar) {
		int lineas = 0;
		try {
			String consultaBorrado = "DELETE FROM juguete WHERE idJuguete=?";
			PreparedStatement sentenciaBorrar = conexion.prepareStatement(consultaBorrado);
			sentenciaBorrar.setInt(1, idBorrar);

			lineas = sentenciaBorrar.executeUpdate();
			if (lineas > 0) {
				System.out.println("[info] Se ha borrado el juguete" + idBorrar);
			} else {
				System.err.println("[error] No se ha podido borrar el juguete" + idBorrar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean buscarJuguete(Connection conexion, int idJugueteB) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM juguete WHERE idJuguete = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idJugueteB);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Juguete encontrado");
					return true;
				} else {
					System.err.println("[error] Juguete con el id pedido no encontrado");
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean buscarJugueteBorrar(Connection conexion, int idJugueteBorrar) {
		try {
			String consultaBuscar = "SELECT COUNT(*) FROM juguete WHERE idJuguete = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaBuscar);
			sentencia.setInt(1, idJugueteBorrar);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int total = resultado.getInt(1);
				if (total > 0) {
					System.out.println("[info] Juguete encontrado");
					return true;
				} else {
					System.err.println("[error] Juguete con el id pedido no encontrado");
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void modificarJuguete(Connection conexion, int idJugueteB, String nombreB, String descripcionB,
			double precioB, int cantidad_stockB) {
		try {
			String consulta = "UPDATE juguete SET nombre=?, descripcion=?, precio=?, cantidad_stock=? WHERE idJuguete=?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setString(1, nombreB);
			sentencia.setString(2, descripcionB);
			sentencia.setDouble(3, precioB);
			sentencia.setInt(4, cantidad_stockB);
			sentencia.setInt(5, idJugueteB);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("[info] Juguete modificado");
				System.out.println("---\nId Juguete:" + idJugueteB + " Nombre: " + nombreB + " Descripcion: "
						+ descripcionB + " Precio: " + precioB + " Cantidad de stock: " + cantidad_stockB + "\n-----");
			} else {
				System.err.println("[error] No se puedo modificar juguete con id" + idJugueteB);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double precioJuguete(Connection conexion, int idJugueteB) {
		double precio = 0;
		try {
			String consultaStock = "SELECT precio FROM juguete WHERE idJuguete = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consultaStock);
			sentencia.setInt(1, idJugueteB);

			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				precio = resultado.getDouble(1); // pillas el primero
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return precio;
	}

	// sacas toda la cantidad del stock por el e/r. mismo juguete varios stands distintas cantidades
	public static int comprobarStock(Connection conexion, int idStandV, int idZonaV, int idJugueteB) {
	    int stock = 0;

	    try {
	        String consulta = "SELECT CANTIDAD FROM stock WHERE STAND_idStand = ? AND STAND_ZONA_idzona = ? AND JUGUETE_idJuguete = ?";
	        PreparedStatement sentencia = conexion.prepareStatement(consulta);
	        sentencia.setInt(1, idStandV);
	        sentencia.setInt(2, idZonaV);
	        sentencia.setInt(3, idJugueteB);

	        ResultSet resultado = sentencia.executeQuery();
	        if (resultado.next()) {
	            stock = resultado.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return stock;
	}
	
	public static int stock_idZonaBuscar(Connection conexion, int idStandV) {
	    int idZona = -1; //a cerp

	    try {
	        String consulta = "SELECT ZONA_idzona FROM stand WHERE idStand = ?";
	        PreparedStatement sentencia = conexion.prepareStatement(consulta);
	        sentencia.setInt(1, idStandV);

	        ResultSet resultado = sentencia.executeQuery();
	        if (resultado.next()) {
	            idZona = resultado.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return idZona;
	}




}
