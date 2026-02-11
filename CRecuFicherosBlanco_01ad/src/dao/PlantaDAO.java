package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Planta;

public class PlantaDAO {
	public static ArrayList<Planta> leerXMLplanta(File ficheroXML, ArrayList<Planta> arrayXMLplanta) {

		try {
			// contructor que te permite leer
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();

			// te lo pasa a memoria para que puedas trabajar en java
			Document documento = docB.parse(ficheroXML);
			documento.getDocumentElement().normalize();// quitarle espacios y eso

			// te va buscando los tags
			NodeList listaPlantas = documento.getElementsByTagName("planta");
			int longitud = listaPlantas.getLength(); // hasta donde va a leer --> usas el nodelist q te cuenta los tag

			for (int i = 0; i < longitud; i++) {
				Node nodo = listaPlantas.item(i); // pasas una por una

				if (nodo.getNodeType() == Node.ELEMENT_NODE) { // que pillas un nodo entero, esto es una comprobacion
					Element plantaElement = (Element) nodo; // de tag a elemento

					// creas el objeto buscando y obteniendo el texto de la etiqueta
					Planta plantaAlmacenarXML = new Planta(
							Integer.parseInt(plantaElement.getElementsByTagName("codigo").item(0).getTextContent()),
							plantaElement.getElementsByTagName("nombre").item(0).getTextContent(),
							plantaElement.getElementsByTagName("foto").item(0).getTextContent(),
							plantaElement.getElementsByTagName("descripcion").item(0).getTextContent());

					// le metes todo al array (es al del xml olvidate de vivero por ahora)
					arrayXMLplanta.add(plantaAlmacenarXML);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayXMLplanta;
	}

	// 12bytes (4(codigoInt)+4(precioFloat)+4(stockInt))
	public static ArrayList<Planta> leerDATplanta(File ficheroDAT, ArrayList<Planta> arrayXMLplanta) {
		ArrayList<Planta> arrayCompletoPlanta = new ArrayList<>();
		try {
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "r");
			raf.seek(0); // empiezas en el principio

			while (raf.getFilePointer() < raf.length()) { // en bytes: posicion del puntero, tamanyo
				// te lees todo
				int codigoRAF = raf.readInt();
				float precioRAF = raf.readFloat();
				int stockRAF = raf.readInt();

				// si ves q se te dublican --> boolean esDoble = false; y compruebas en el for
				// && !esDdoble
				for (int i = 0; i < arrayXMLplanta.size(); i++) {
					Planta plantaRegistro = arrayXMLplanta.get(i);
					if (plantaRegistro.getCodigo() == codigoRAF) {
						// System.out.println("Codigo planta: " + plantaRegistro.getCodigo() + "~~~~" +
						// "Codigo: " + codigoRAF);
						plantaRegistro.setPrecio(precioRAF);
						plantaRegistro.setStock(stockRAF);
						arrayCompletoPlanta.add(plantaRegistro);
					}
				}
				// *** System.out.println("Codigo: " + codigoRAF + " , precio: " + precioRAF +"
				// , stock: " + stockRAF);
			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * System.out.println("\nLista completa:"); for (Planta p : arrayCompletoPlanta)
		 * { System.out.println(p); }
		 */
		return arrayCompletoPlanta;
	}

	// como lo estas modificando en el fichero y no en tiempo de ejecucion cuando
	// haces una venta y visualizas el catalogo no se actualiza.
	// Tienes que cerrar el programa y volver a iniciar para que te lea el .dat y
	// puedas ver el stock modificado
	public static void modificarStock(int codigoVenta, int cantidadVenta) {
		try {
			// es fija la ruta esta y ya hacces comprobacciones
			File ficheroDAT = new File("PLANTAS/plantas.dat");
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "rw");
			raf.seek(0);

			while (raf.getFilePointer() + 12 <= raf.length()) {// te lees todos sin irte
				long volver = raf.getFilePointer(); // donde te quedas en el registro

				int codigoRAF = raf.readInt();
				float precioRAF = raf.readFloat();
				int stockRAF = raf.readInt();

				if (codigoRAF == codigoVenta) {
					// NO VA, NULLPOINTER :raf.seek(raf.getFilePointer()-4); //vuelvete a stock, si
					// pones de una raf.seek(4) no va
					int nuevoStock = stockRAF - cantidadVenta;

					// para irte al siguiente
					raf.seek(volver + 8);
					raf.writeInt(nuevoStock);
					System.out.println("Stock actualizado");
					break;
				}

			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modificarStockDevolver(int codigoVenta, int cantidadVenta) {
		try {
			// es fija la ruta esta y ya hacces comprobacciones
			File ficheroDAT = new File("PLANTAS/plantas.dat");
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "rw");
			raf.seek(0);

			while (raf.getFilePointer() + 12 <= raf.length()) {// te lees todos sin irte
				long volver = raf.getFilePointer(); // donde te quedas en el registro

				int codigoRAF = raf.readInt();
				float precioRAF = raf.readFloat();
				int stockRAF = raf.readInt();

				if (codigoRAF == codigoVenta) {
					// NO VA, NULLPOINTER :raf.seek(raf.getFilePointer()-4); //vuelvete a stock, si
					// pones de una raf.seek(4) no va
					int nuevoStock = stockRAF + cantidadVenta;

					// para irte al siguiente
					raf.seek(volver + 8);
					raf.writeInt(nuevoStock);
					System.out.println("Stock actualizado");
					break;
				}

			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pasarBajaPlanta(Planta p) {
		File datBaja = new File("PLANTAS/plantasBaja.dat");
		File xmlBaja = new File("PLANTAS/plantasBaja.xml");

		System.out.println("[info] planta movida a bajas ");
	}

	public static void nuevaPlantaDAT(File ficheroDAT, Planta plantaG) {
		try {
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "rw");
			raf.seek(raf.length()); // al final del fichero
			raf.writeInt(plantaG.getCodigo());
			raf.writeFloat(plantaG.getPrecio());
			raf.writeInt(plantaG.getStock());

			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// haciendo todo de nuevo pque muere si no, se te queda solo la nueva
	public static void nuevaPlantaXML2(File ficheroXML, Planta plantaG, ArrayList<Planta> arrayCatalogoPlantas) {
		try {

			ficheroXML.createNewFile();
			FileWriter escritura = new FileWriter(ficheroXML);
			// reescribir
			escritura.write("<plantas>\n");
			for (Planta p : arrayCatalogoPlantas) {
				// nueva
				escritura.write("<planta>\n");
				escritura.write("<codigo>" + plantaG.getCodigo() + "</codigo>\n");
				escritura.write("<nombre>" + plantaG.getNombre() + "</nombre>\n");
				escritura.write("<foto>" + plantaG.getFoto() + "</foto>\n");
				escritura.write("<descripcion>" + plantaG.getDescripcion() + "</descripcion>\n");
				escritura.write("</planta>\n");
				// para cerrar
			}
			escritura.write("</plantas>\n");

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// haciendo todo de nuevo pque muere si no, se te queda solo la nueva
	public static void nuevaPlantaXML(File ficheroXML, Planta plantaG) {
		try {

			ficheroXML.createNewFile();
			FileWriter escritura = new FileWriter(ficheroXML);
			// reescribir
			escritura.write("<plantas>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>1</codigo>\n");
			escritura.write("<nombre>Cactus</nombre>\n");
			escritura.write("<foto>cactus.jpg</foto>\n");
			escritura.write("<descripcion>Planta suculenta del desierto.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>2</codigo>\n");
			escritura.write("<nombre>Geranio</nombre>\n");
			escritura.write("<foto>geranio.jpg</foto>\n");
			escritura.write("<descripcion>Flor común de jardín con colores vivos.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>3</codigo>\n");
			escritura.write("<nombre>Helecho</nombre>\n");
			escritura.write("<foto>helecho.jpg</foto>\n");
			escritura.write("<descripcion>Planta de sombra con hojas verdes largas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>4</codigo>\n");
			escritura.write("<nombre>Rosa</nombre>\n");
			escritura.write("<foto>rosa.jpg</foto>\n");
			escritura.write("<descripcion>Flor ornamental con espinas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>5</codigo>\n");
			escritura.write("<nombre>Lavanda</nombre>\n");
			escritura.write("<foto>lavanda.jpg</foto>\n");
			escritura.write("<descripcion>Planta aromática de color violeta.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>6</codigo>\n");
			escritura.write("<nombre>Aloe Vera</nombre>\n");
			escritura.write("<foto>aloe_vera.jpg</foto>\n");
			escritura.write("<descripcion>Planta medicinal con hojas carnosas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>7</codigo>\n");
			escritura.write("<nombre>Menta</nombre>\n");
			escritura.write("<foto>menta.jpg</foto>\n");
			escritura.write("<descripcion>Planta aromática usada en infusiones.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>8</codigo>\n");
			escritura.write("<nombre>Bambú</nombre>\n");
			escritura.write("<foto>bambu.jpg</foto>\n");
			escritura.write("<descripcion>Planta de tallo alto y hueco, de rápido crecimiento.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>9</codigo>\n");
			escritura.write("<nombre>Orquídea</nombre>\n");
			escritura.write("<foto>orquidea.jpg</foto>\n");
			escritura.write("<descripcion>Flor exótica de gran valor ornamental.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>10</codigo>\n");
			escritura.write("<nombre>Hortensia</nombre>\n");
			escritura.write("<foto>hortensia.jpg</foto>\n");
			escritura.write("<descripcion>Planta de flores grandes y coloridas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>11</codigo>\n");
			escritura.write("<nombre>Palmera</nombre>\n");
			escritura.write("<foto>palmera.jpg</foto>\n");
			escritura.write("<descripcion>Árbol tropical con hojas largas en forma de abanico.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>12</codigo>\n");
			escritura.write("<nombre>Clavel</nombre>\n");
			escritura.write("<foto>clavel.jpg</foto>\n");
			escritura.write("<descripcion>Flor de colores vivos y aroma agradable.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>13</codigo>\n");
			escritura.write("<nombre>Jacinto</nombre>\n");
			escritura.write("<foto>jacinto.jpg</foto>\n");
			escritura.write("<descripcion>Planta bulbosa de flores perfumadas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>14</codigo>\n");
			escritura.write("<nombre>Petunia</nombre>\n");
			escritura.write("<foto>petunia.jpg</foto>\n");
			escritura.write("<descripcion>Flor de jardín muy colorida.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>15</codigo>\n");
			escritura.write("<nombre>Begonia</nombre>\n");
			escritura.write("<foto>begonia.jpg</foto>\n");
			escritura.write("<descripcion>Planta ornamental con hojas decorativas.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>16</codigo>\n");
			escritura.write("<nombre>Poto</nombre>\n");
			escritura.write("<foto>poto.jpg</foto>\n");
			escritura.write("<descripcion>Planta colgante de interior muy resistente.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>17</codigo>\n");
			escritura.write("<nombre>Crisantemo</nombre>\n");
			escritura.write("<foto>crisantemo.jpg</foto>\n");
			escritura.write("<descripcion>Flor típica de otoño en muchos colores.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>18</codigo>\n");
			escritura.write("<nombre>Romero</nombre>\n");
			escritura.write("<foto>romero.jpg</foto>\n");
			escritura.write("<descripcion>Planta aromática usada en la cocina mediterránea.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>19</codigo>\n");
			escritura.write("<nombre>Ficus</nombre>\n");
			escritura.write("<foto>ficus.jpg</foto>\n");
			escritura.write("<descripcion>Árbol o arbusto de interior muy popular.</descripcion>\n");
			escritura.write("</planta>\n");
			escritura.write("<planta>\n");
			escritura.write("<codigo>20</codigo>\n");
			escritura.write("<nombre>Jazmín</nombre>\n");
			escritura.write("<foto>jazmin.jpg</foto>\n");
			escritura.write("<descripcion>Planta trepadora de flores fragantes.</descripcion>\n");
			escritura.write("</planta>\n");
			// nueva
			escritura.write("<planta>\n");
			escritura.write("<codigo>" + plantaG.getCodigo() + "</codigo>\n");
			escritura.write("<nombre>" + plantaG.getNombre() + "</nombre>\n");
			escritura.write("<foto>" + plantaG.getFoto() + "</foto>\n");
			escritura.write("<descripcion>" + plantaG.getDescripcion() + ".</descripcion>\n");
			escritura.write("</planta>\n");
			// para cerrar
			escritura.write("</plantas>\n");
			escritura.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
