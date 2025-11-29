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