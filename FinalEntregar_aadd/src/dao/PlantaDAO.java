package dao;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

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

	public static int leerDATstockPorCodigo(int codigoVenta) {
		int stockActual = -1; // no esta ;p
		try {
			// es fija la ruta esta y ya hacces comprobacciones
			File ficheroDAT = new File("PLANTAS/plantas.dat");
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "r");
			raf.seek(0);

			while (raf.getFilePointer() < raf.length()) {// te lees todos aunque puedes saltar directamente de 8 a 8
				int codigoRAF = raf.readInt();
				float precioRAF = raf.readFloat();
				int stockRAF = raf.readInt();

				if (codigoRAF == codigoVenta) {
					stockActual = stockRAF;
				}

			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockActual;
	}

	public static void modificarStock(int codigoVenta, int stockActual) {
		try {
			// es fija la ruta esta y ya hacces comprobacciones
			File ficheroDAT = new File("PLANTAS/plantas.dat");
			// abro en lectura
			RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "w");
			raf.seek(0);

			while (raf.getFilePointer() < raf.length()) {// te lees todos aunque puedes saltar directamente de 8 a 8
				int codigoRAF = raf.readInt();
				float precioRAF = raf.readFloat();
				int stockRAF = raf.readInt();

				raf.write(stockActual);

			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
