package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.ControlErrores;

public class JugueteriaBlanco {

	public static void main(String[] args) {
		/* verificacion y carga de datos */
		String url = "jdbc:mysql://localhost:3306/jugueteriaBlancoC";
		String usuario = "root";
		String password = "sopita666";
		//String password = "cfgs";

		try {
			/*
			 * Cargar el drive de la BD y crear conexion, todo va bien y pasas a los menus
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			jugueteria(args, conexion);

		} catch (Exception e) {
			System.err.println("[info] No se encuentra la base de datos, se procede a su creacion " + e.getMessage());
			crearJugueteriaBlancoC();
			System.out.println("[info] Base de datos creada correctamente");
			System.out.println();

			// lo vuelves a tirar
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection(url, usuario, password);
				jugueteria(args, conexion);
			} catch (Exception e2) {
				System.err.println("[error] Conexion invalida bbdd " + e2.getMessage());
			}
		}

	}

	public static void jugueteria(String[] args, Connection conexion) {
		/* verificar conexion bbdd */
		if (conexion != null) { // ~~ se ha cargado?
			System.out.println("[info] Se ha conectado a la base de datos");
		} else {
			System.err.println("[info] Conexion invalida");
		}

		/*
		 * verificar bbdd != null (tienes que cargar juguetes, empleados, zona y stand)
		 */
		boolean banderaJ = ControlErrores.comprobarJuguetesVacio(conexion);
		boolean banderaE = ControlErrores.comprobarEmpleadosVacio(conexion);
		boolean banderaZ = ControlErrores.comprobarZonaVacio(conexion);
		boolean banderaSd = ControlErrores.comprobarStandVacio(conexion);
		boolean banderaSk = ControlErrores.comprobarStockVacio(conexion);
		boolean banderaV = ControlErrores.comprobarVentaVacio(conexion);

		if (banderaJ) {
			System.out.println("[info] Tabla juguete vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarJuguetesVacio(conexion);
		}
		if (banderaE) {
			System.out.println("[info] Tabla empleados vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarEmpleadosVacio(conexion);
		}
		if (banderaZ) {
			System.out.println("[info] Tabla zona vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarZonaVacio(conexion);
		}
		if (banderaSd) {
			System.out.println("[info] Tabla stand vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarStandVacio(conexion);
		}
		if (banderaSk) {
			System.out.println("[info] Tabla stock vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarStockVacio(conexion);
		}
		if (banderaV) {
			System.out.println("[info] Tabla venta vacia. Se procede a la creacion de inserts");
			ControlErrores.insertarVentaVacio(conexion);
		}
		// si pasa por todo lanzas el menu principal
		menuPrincipal(args, conexion);
	}

	public static void menuPrincipal(String[] args, Connection conexion) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("~~~ BIENVENIDOS A LA GESTION DE LA JUGUETERIA ~~~");
		System.out.println("# Porfavor seleccione sobre que va a operar: #");
		System.out.println("1. JUGUETES");
		System.out.println("2. EMPLEADO");
		System.out.println("3. VENTAS");
		System.out.println("4. OBTENER DATOS TIENDA");
		System.out.println("0. SALIR");
		int opc = ControlErrores.controlErroresInt(sc);

		switch (opc) {
		case 1:
			MenuJuguetes.main(args, conexion);
			break;

		case 2:
			MenuEmpleado.main(args, conexion);

			break;
		case 3:
			MenuVentas.main(args, conexion);
			break;
		case 4:
			MenuDatos.main(args, conexion);
			break;
		case 0:
			System.out.println("Saliendo del programa...");
			break;
		default:
			System.err.println("[ERROR] Opcion incorrecta");
			break;
		}
		sc.close();
	}

	public static void crearJugueteriaBlancoC() {
		String url = "jdbc:mysql://localhost:3306/";
		String usuario = "root";
		//String password = "sopita666";
		String password = "cfgs";
		try (Connection conexion = DriverManager.getConnection(url, usuario, password);
				Statement sentencia = conexion.createStatement()) {

			// ???????????????????????????/
			sentencia.execute("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0");
			sentencia.execute("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0");
			sentencia.execute(
					"SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'");

			/* crear bd */
			sentencia.executeUpdate("CREATE SCHEMA IF NOT EXISTS `jugueteriaBlancoC` DEFAULT CHARACTER SET utf8mb3");
			sentencia.execute("USE `jugueteriaBlancoC`");

			//sentencia.executeUpdate("");
			
			//empleado
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`empleado` (\n"
					+ "  `idEMPLEADO` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n"
					+ "  `Nombre` VARCHAR(45) NULL DEFAULT NULL,\n"
					+ "  `Cargo` ENUM('jefe', 'cajero') NULL DEFAULT NULL,\n"
					+ "  `Fecha_ingreso` DATE NULL DEFAULT NULL,\n"
					+ "  PRIMARY KEY (`idEMPLEADO`))\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//juguete
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`juguete` (\n"
					+ "  `idJuguete` INT NOT NULL AUTO_INCREMENT,\n"
					+ "  `Nombre` VARCHAR(45) NULL DEFAULT NULL,\n"
					+ "  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,\n"
					+ "  `Precio` DOUBLE NULL DEFAULT NULL,\n"
					+ "  `Cantidad_stock` INT UNSIGNED NOT NULL,\n"
					+ "  PRIMARY KEY (`idJuguete`))\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//zona
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`zona` (\n"
					+ "  `idzona` INT NOT NULL,\n"
					+ "  `Nombre` VARCHAR(45) NULL DEFAULT NULL,\n"
					+ "  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,\n"
					+ "  PRIMARY KEY (`idzona`))\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//stand
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`stand` (\n"
					+ "  `idStand` INT NOT NULL,\n"
					+ "  `Nombre` VARCHAR(45) NULL DEFAULT NULL,\n"
					+ "  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,\n"
					+ "  `ZONA_idzona` INT NOT NULL,\n"
					+ "  PRIMARY KEY (`idStand`, `ZONA_idzona`),\n"
					+ "  INDEX `fk_STAND_ZONA_idx` (`ZONA_idzona` ASC) VISIBLE,\n"
					+ "  CONSTRAINT `fk_STAND_ZONA`\n"
					+ "    FOREIGN KEY (`ZONA_idzona`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`zona` (`idzona`))\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//stock
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`stock` (\n"
					+ "  `STAND_idStand` INT NOT NULL,\n"
					+ "  `STAND_ZONA_idzona` INT NOT NULL,\n"
					+ "  `JUGUETE_idJuguete` INT NOT NULL,\n"
					+ "  `CANTIDAD` VARCHAR(45) NULL DEFAULT NULL,\n"
					+ "  PRIMARY KEY (`STAND_idStand`, `STAND_ZONA_idzona`, `JUGUETE_idJuguete`),\n"
					+ "  INDEX `fk_STAND_has_JUGUETE_JUGUETE1_idx` (`JUGUETE_idJuguete` ASC) VISIBLE,\n"
					+ "  INDEX `fk_STAND_has_JUGUETE_STAND1_idx` (`STAND_idStand` ASC, `STAND_ZONA_idzona` ASC) VISIBLE,\n"
					+ "  CONSTRAINT `fk_STAND_has_JUGUETE_JUGUETE1`\n"
					+ "    FOREIGN KEY (`JUGUETE_idJuguete`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`juguete` (`idJuguete`)\n"
					+ "     ON UPDATE CASCADE ON DELETE CASCADE,\n"
					+ "  CONSTRAINT `fk_STAND_has_JUGUETE_STAND1`\n"
					+ "    FOREIGN KEY (`STAND_idStand` , `STAND_ZONA_idzona`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`stand` (`idStand` , `ZONA_idzona`)\n"
					+ "     ON UPDATE CASCADE ON DELETE CASCADE)\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//cambio
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`cambio` (\n"
					+ "  `idCAMBIO` INT NOT NULL AUTO_INCREMENT,\n"
					+ "  `MOTIVO` VARCHAR(150) NULL DEFAULT NULL,\n"
					+ "  `Fecha` DATE NULL DEFAULT NULL,\n"
					+ "  `STOCK_STAND_idStand_Original` INT NOT NULL,\n"
					+ "  `STOCK_STAND_ZONA_idzona_Original` INT NOT NULL,\n"
					+ "  `STOCK_JUGUETE_idJuguete_Original` INT NOT NULL,\n"
					+ "  `STOCK_STAND_idStand_Nuevo` INT NOT NULL,\n"
					+ "  `STOCK_STAND_ZONA_idzona_Nuevo` INT NOT NULL,\n"
					+ "  `STOCK_JUGUETE_idJuguete_Nuevo` INT NOT NULL,\n"
					+ "  `EMPLEADO_idEMPLEADO` INT UNSIGNED NOT NULL,\n"
					+ "  PRIMARY KEY (`idCAMBIO`),\n"
					+ "  INDEX `fk_CAMBIO_STOCK1_idx` (`STOCK_STAND_idStand_Original` ASC, `STOCK_STAND_ZONA_idzona_Original` ASC, `STOCK_JUGUETE_idJuguete_Original` ASC) VISIBLE,\n"
					+ "  INDEX `fk_CAMBIO_STOCK2_idx` (`STOCK_STAND_idStand_Nuevo` ASC, `STOCK_STAND_ZONA_idzona_Nuevo` ASC, `STOCK_JUGUETE_idJuguete_Nuevo` ASC) VISIBLE,\n"
					+ "  INDEX `fk_CAMBIO_EMPLEADO1_idx` (`EMPLEADO_idEMPLEADO` ASC) VISIBLE,\n"
					+ "  CONSTRAINT `fk_CAMBIO_EMPLEADO1`\n"
					+ "    FOREIGN KEY (`EMPLEADO_idEMPLEADO`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`empleado` (`idEMPLEADO`),\n"
					+ "  CONSTRAINT `fk_CAMBIO_STOCK1`\n"
					+ "    FOREIGN KEY (`STOCK_STAND_idStand_Original` , `STOCK_STAND_ZONA_idzona_Original` , `STOCK_JUGUETE_idJuguete_Original`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`),\n"
					+ "  CONSTRAINT `fk_CAMBIO_STOCK2`\n"
					+ "    FOREIGN KEY (`STOCK_STAND_idStand_Nuevo` , `STOCK_STAND_ZONA_idzona_Nuevo` , `STOCK_JUGUETE_idJuguete_Nuevo`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`))\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			//venta
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS `jugueteriaBlancoC`.`venta` (\n"
					+ "  `idventa` INT NOT NULL AUTO_INCREMENT,\n"
					+ "  `Fecha` DATE NULL DEFAULT NULL,\n"
					+ "  `Monto` DOUBLE NULL DEFAULT NULL,\n"
					+ "  `tipo_pago` ENUM('efectivo', 'tarjeta', 'paypal') NULL DEFAULT NULL,\n"
					+ "  `EMPLEADO_idEMPLEADO` INT UNSIGNED NOT NULL,\n"
					+ "  `stock_STAND_idStand` INT NOT NULL,\n"
					+ "  `stock_STAND_ZONA_idzona` INT NOT NULL,\n"
					+ "  `stock_JUGUETE_idJuguete` INT NOT NULL,\n"
					+ "  PRIMARY KEY (`idventa`),\n"
					+ "  INDEX `fk_VENTA_EMPLEADO1_idx` (`EMPLEADO_idEMPLEADO` ASC) VISIBLE,\n"
					+ "  INDEX `fk_venta_stock1_idx` (`stock_STAND_idStand` ASC, `stock_STAND_ZONA_idzona` ASC, `stock_JUGUETE_idJuguete` ASC) VISIBLE,\n"
					+ "  CONSTRAINT `fk_VENTA_EMPLEADO1`\n"
					+ "    FOREIGN KEY (`EMPLEADO_idEMPLEADO`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`empleado` (`idEMPLEADO`),\n"
					+ "  CONSTRAINT `fk_venta_stock1`\n"
					+ "    FOREIGN KEY (`stock_STAND_idStand` , `stock_STAND_ZONA_idzona` , `stock_JUGUETE_idJuguete`)\n"
					+ "    REFERENCES `jugueteriaBlancoC`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`)\n"
					+ "    ON DELETE NO ACTION\n"
					+ "    ON UPDATE NO ACTION)\n"
					+ "ENGINE = InnoDB\n"
					+ "DEFAULT CHARACTER SET = utf8mb3;");
			
			// Volver a activar checks
			sentencia.execute("SET FOREIGN_KEY_CHECKS = 1");
			sentencia.execute("SET UNIQUE_CHECKS = 1");
			sentencia.execute("SET SQL_MODE=@OLD_SQL_MODE");

			System.out.println("Funnciona!!!!!");

		} catch (SQLException e) {
			System.err.println("[error] " + e.getMessage());
		}

	}

}
