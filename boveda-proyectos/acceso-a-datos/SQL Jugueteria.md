##### inserts para juguete
```
INSERT INTO juguete (idJuguete,Nombre,Descripcion,Precio,Cantidad_stock ) VALUES (,,,)
```

```
INSERT INTO juguete (idJuguete,Nombre,Descripcion,Precio,Cantidad_stock) VALUES (1,'nombre1','descripcion1',1.5,12) ,
(2,'nombre2','descripcion2',5.0,12) ,
(3,'nombre3','descripcion3',21.5,19) ,
(4,'nombre4','descripcion4',17.4,11) ,
(5,'nombre5','descripcion5',10.2,11) ,
(6,'nombre6','descripcion6',11.6,8) ,
(7,'nombre7','descripcion7',17.4,19) ,
(8,'nombre8','descripcion8',6.8,4) ,
(9,'nombre9','descripcion9',7.1,6) ,
(10,'nombre10','descripcion10',12.0,19) ,
(11,'nombre11','descripcion11',5.0,5) ,
(12,'nombre12','descripcion12',2.3,7) ,
(13,'nombre13','descripcion13',18.2,19) ,
(14,'nombre14','descripcion14',4.7,5) ,
(15,'nombre15','descripcion15',18.2,5) ,
(16,'nombre16','descripcion16',21.5,15) ,
(17,'nombre17','descripcion17',6.8,10) ,
(18,'nombre18','descripcion18',18.2,9) ,
(19,'nombre19','descripcion19',20.1,1) ,
(20,'nombre20','descripcion20',14.8,12);

```

```
DELETE FROM juguete WHERE idJuguete=1;
```
##### inserts para empleado
```
INSERT INTO empleado (idEmpleado,Nombre,Cargo,Fecha_ingreso) VALUES (,,,)
```

```
INSERT INTO empleado (idEmpleado,Nombre,Cargo,Fecha_ingreso) VALUES ( DEFAULT,'nombre1','cajero',NULL) ,
( DEFAULT,'nombre2','cajero',NULL) ,
( DEFAULT,'nombre3','jefe',NULL) ,
( DEFAULT,'nombre4','cajero',NULL) ,
( DEFAULT,'nombre5','jefe',NULL) ,
( DEFAULT,'nombre6','cajero',NULL) ,
( DEFAULT,'nombre7','cajero',NULL) ,
( DEFAULT,'nombre8','cajero',NULL) ,
( DEFAULT,'nombre9','jefe',NULL) ,
( DEFAULT,'nombre10','jefe',NULL) ,
( DEFAULT,'nombre11','jefe',NULL) ,
( DEFAULT,'nombre12','jefe',NULL) ,
( DEFAULT,'nombre13','cajero',NULL) ,
( DEFAULT,'nombre14','cajero',NULL) ,
( DEFAULT,'nombre15','cajero',NULL) ,
( DEFAULT,'nombre16','cajero',NULL) ,
( DEFAULT,'nombre17','jefe',NULL) ,
( DEFAULT,'nombre18','cajero',NULL) ,
( DEFAULT,'nombre19','cajero',NULL) ,
( DEFAULT,'nombre20','jefe',NULL);
```

```
DELETE FROM empleado WHERE idEmpleado=1;
```

```
update empleado set Fecha_ingreso = DATE_ADD('2025-05-04', INTERVAL FLOOR(RAND()*21) DAY) where idEmpleado>0;
```
#### realizar venta
```
idventa --> auto increment 
Fecha --> localDate
Monto --> precio del juguete (xstock)
tipo_pago --> teclado 
EMPLEADO_idEMPLEADO --> teclado 
stock_STAND_idStand --> teclado
stock_STAND_ZONA_idzona --> consulta
stock_JUGUETE_idJuguete --> teclado


```

## inserts zona
```
INSERT INTO zona (idZona, Nombre, Descripcion) VALUES
(1, 'Luna', 'd1'),
(2, 'Elisa', 'd2'),
(3, 'Mario', 'd3'),
(4, 'Rafa',  'd4');

```

## inserts stand
```
INSERT INTO stand (idStand, Nombre, Descripcion, ZONA_idZona) VALUES
(1, 'A', 'da', 1),   
(2, 'B', 'db', 1),    
(3, 'C', 'dc', 2),          
(4, 'D', 'dd', 3),     
(5, 'E', 'de', 4);

```

## insert stock
```
INSERT INTO stock (STAND_idStand, STAND_ZONA_idzona, JUGUETE_idJuguete, CANTIDAD)
VALUES (1, 1, 20, 10),(2, 1, 19, 1),(3, 2, 3, 3);

INSERT INTO stock VALUES (2, 1, 19, 1),(3, 2, 3, 3);

INSERT INTO stock (STAND_idStand, STAND_ZONA_idzona, JUGUETE_idJuguete, CANTIDAD) VALUES 
(1, 1, 1, '5'),
(1, 1, 2, '3'),
(1, 1, 3, '3'),
(1, 1, 4, '10'),
(2, 1, 5, '2'),
(2, 1, 6, '8'),
(2, 1, 7, '15'),
(2, 1, 8, '4'),
(3, 2, 9, '6'),
(3, 2, 10, '12'),
(3, 2, 11, '5'),
(3, 2, 12, '7'),
(4, 3, 13, '19'),
(4, 3, 14, '5'),
(4, 3, 15, '5'),
(4, 3, 16, '15'),
(5, 4, 17, '10'),
(5, 4, 18, '9'),
(5, 4, 19, '1'),
(5, 4, 20, '10');


```

## join para comprobar esto de arriba
```
SELECT s.STAND_idStand AS idStand,sd.ZONA_idZona AS idZona, j.idJuguete AS idJuguete, s.CANTIDAD AS Cantidad FROM stock s
JOIN stand sd ON s.STAND_idStand = sd.idStand AND s.STAND_ZONA_idZona = sd.ZONA_idZona JOIN juguete j ON s.JUGUETE_idJuguete = j.idJuguete
ORDER BY idStand, idJuguete;

```

pillas los id del stock y los juntas si te counciden con el la tabla de sd en id de stand y zona tmb unes juguete se coincide ordenalo por stand y asi lo reutilizas en realizar venta y mostrarJuguetesStand

## join ver por mes
```
SELECT MONTH(Fecha) AS Mes, COUNT(*) AS NumeroVentas, SUM(Monto) AS TotalIngresos FROM venta GROUP BY MONTH(Fecha) ORDER BY Mes;
```


## join mas vendido 

```
select j.Nombre as NombreJuguete, COUNT(v.idventa) AS TotalVentas FROM venta v JOIN juguete j ON v.stock_JUGUETE_idJuguete = j.idJuguete GROUP BY v.stock_JUGUETE_idJuguete ORDER BY TotalVentas limit 1;
```

los calculos y lo juntas por id juguete 

## join empleados mas venden

```
select e.nombre as NombreEmpleado, COUNT(v.idventa) as TotalVentas from venta v join empleado e on v.EMPLEADO_idEMPLEADO = e.idEmpleado group by v.EMPLEADO_idEMPLEADO order by TotalVentas limit 1;
```