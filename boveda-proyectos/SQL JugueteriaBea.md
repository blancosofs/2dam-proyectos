```
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema jugueteria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jugueteria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jugueteria` DEFAULT CHARACTER SET utf8mb3 ;
USE `jugueteria` ;

-- -----------------------------------------------------
-- Table `jugueteria`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`empleado` (
  `idEMPLEADO` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Cargo` ENUM('jefe', 'cajero') NULL DEFAULT NULL,
  `Fecha_ingreso` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idEMPLEADO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`juguete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`juguete` (
  `idJuguete` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,
  `Precio` DOUBLE NULL DEFAULT NULL,
  `Cantidad_stock` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idJuguete`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`zona` (
  `idzona` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`idzona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`stand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`stand` (
  `idStand` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,
  `ZONA_idzona` INT NOT NULL,
  PRIMARY KEY (`idStand`, `ZONA_idzona`),
  INDEX `fk_STAND_ZONA_idx` (`ZONA_idzona` ASC) VISIBLE,
  CONSTRAINT `fk_STAND_ZONA`
    FOREIGN KEY (`ZONA_idzona`)
    REFERENCES `jugueteria`.`zona` (`idzona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`stock` (
  `STAND_idStand` INT NOT NULL,
  `STAND_ZONA_idzona` INT NOT NULL,
  `JUGUETE_idJuguete` INT NOT NULL,
  `CANTIDAD` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`STAND_idStand`, `STAND_ZONA_idzona`, `JUGUETE_idJuguete`),
  INDEX `fk_STAND_has_JUGUETE_JUGUETE1_idx` (`JUGUETE_idJuguete` ASC) VISIBLE,
  INDEX `fk_STAND_has_JUGUETE_STAND1_idx` (`STAND_idStand` ASC, `STAND_ZONA_idzona` ASC) VISIBLE,
  CONSTRAINT `fk_STAND_has_JUGUETE_JUGUETE1`
    FOREIGN KEY (`JUGUETE_idJuguete`)
    REFERENCES `jugueteria`.`juguete` (`idJuguete`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_STAND_has_JUGUETE_STAND1`
    FOREIGN KEY (`STAND_idStand` , `STAND_ZONA_idzona`)
    REFERENCES `jugueteria`.`stand` (`idStand` , `ZONA_idzona`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`cambio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`cambio` (
  `idCAMBIO` INT NOT NULL,
  `MOTIVO` VARCHAR(150) NULL DEFAULT NULL,
  `Fecha` DATE NULL DEFAULT NULL,
  `STOCK_STAND_idStand_Original` INT NOT NULL,
  `STOCK_STAND_ZONA_idzona_Original` INT NOT NULL,
  `STOCK_JUGUETE_idJuguete_Original` INT NOT NULL,
  `STOCK_STAND_idStand_Nuevo` INT NOT NULL,
  `STOCK_STAND_ZONA_idzona_Nuevo` INT NOT NULL,
  `STOCK_JUGUETE_idJuguete_Nuevo` INT NOT NULL,
  `EMPLEADO_idEMPLEADO` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idCAMBIO`),
  INDEX `fk_CAMBIO_STOCK1_idx` (`STOCK_STAND_idStand_Original` ASC, `STOCK_STAND_ZONA_idzona_Original` ASC, `STOCK_JUGUETE_idJuguete_Original` ASC) VISIBLE,
  INDEX `fk_CAMBIO_STOCK2_idx` (`STOCK_STAND_idStand_Nuevo` ASC, `STOCK_STAND_ZONA_idzona_Nuevo` ASC, `STOCK_JUGUETE_idJuguete_Nuevo` ASC) VISIBLE,
  INDEX `fk_CAMBIO_EMPLEADO1_idx` (`EMPLEADO_idEMPLEADO` ASC) VISIBLE,
  CONSTRAINT `fk_CAMBIO_EMPLEADO1`
    FOREIGN KEY (`EMPLEADO_idEMPLEADO`)
    REFERENCES `jugueteria`.`empleado` (`idEMPLEADO`),
  CONSTRAINT `fk_CAMBIO_STOCK1`
    FOREIGN KEY (`STOCK_STAND_idStand_Original` , `STOCK_STAND_ZONA_idzona_Original` , `STOCK_JUGUETE_idJuguete_Original`)
    REFERENCES `jugueteria`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`),
  CONSTRAINT `fk_CAMBIO_STOCK2`
    FOREIGN KEY (`STOCK_STAND_idStand_Nuevo` , `STOCK_STAND_ZONA_idzona_Nuevo` , `STOCK_JUGUETE_idJuguete_Nuevo`)
    REFERENCES `jugueteria`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `jugueteria`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`venta` (
  `idventa` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL DEFAULT NULL,
  `Monto` DOUBLE NULL DEFAULT NULL,
  `tipo_pago` ENUM('efectivo', 'tarjeta', 'paypal') NULL DEFAULT NULL,
  `EMPLEADO_idEMPLEADO` INT UNSIGNED NOT NULL,
  `stock_STAND_idStand` INT NOT NULL,
  `stock_STAND_ZONA_idzona` INT NOT NULL,
  `stock_JUGUETE_idJuguete` INT NOT NULL,
  PRIMARY KEY (`idventa`),
  INDEX `fk_VENTA_EMPLEADO1_idx` (`EMPLEADO_idEMPLEADO` ASC) VISIBLE,
  INDEX `fk_venta_stock1_idx` (`stock_STAND_idStand` ASC, `stock_STAND_ZONA_idzona` ASC, `stock_JUGUETE_idJuguete` ASC) VISIBLE,
  CONSTRAINT `fk_VENTA_EMPLEADO1`
    FOREIGN KEY (`EMPLEADO_idEMPLEADO`)
    REFERENCES `jugueteria`.`empleado` (`idEMPLEADO`),
  CONSTRAINT `fk_venta_stock1`
    FOREIGN KEY (`stock_STAND_idStand` , `stock_STAND_ZONA_idzona` , `stock_JUGUETE_idJuguete`)
    REFERENCES `jugueteria`.`stock` (`STAND_idStand` , `STAND_ZONA_idzona` , `JUGUETE_idJuguete`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

```