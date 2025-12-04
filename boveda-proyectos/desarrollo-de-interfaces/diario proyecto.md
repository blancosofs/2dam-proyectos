
## 04/12/2025

~~Objetivo: Ventana en la que se vean las noticias. Que salgan las seis categorías y según las fuentes un texto área de noticias~~

VENTANA --> 2 vez que loggea. 
Info que debes tener: las fuentes 
Las fuentes las guardas en el  txt
Según la categoría que vaya a visualizar le salen las noticias de esa fuente

¿hora es solo para mandar el email?

Estado:

10:03!!!!!!!!
Un txt editable por el usuario solo en la primera pantalla. puede elegir 1,2,3 y se meterán a ConfiguracionDAO según elija se mete al txt que tiene las claves y urls y el GestorNoticias pilla las cosas de ConfiguracionDAO.

10:54
https://www.geeksforgeeks.org/java/jradiobutton-java-swing/ 
Tienes si has seleccionado según que fuente ahora que devuelves. String abc y que escribirFuentes lo recoja y segun con un switch case que escriba. Ahora para sacarFuentes lo vas a leer te metes en el personalizar y donde tengas .dep@@ (string para usar equals) le devuelves el numero  y directo al switch case?


No necesitas el contador, solo pide 1 

```
public static String exNot_dMarca() {

StringBuilder sb = new StringBuilder("Noticias Deportes-Marca: \n");

try {

int contador = 0;

  

String web = "https://www.marca.com/ultimas-noticias.html?intcmp=MENUDEST&s_kw=ultimas-noticias";

Document doc = Jsoup.connect(web).get();

  

while (contador < 3) {

Element palabra = doc.select("h2.mod-title a").get(contador);

String resultado = palabra.html().toUpperCase();

sb.append(resultado).append(" \n");

contador++;

}

} catch (IOException io) {

io.printStackTrace();

}

return sb.toString();

}

```
``
## 03/12/2025

Objetivo: Tener varios métodos para extraer noticias de cada fuente y guardarlos en un array llamado mostrar

Métodos:
``
```
exNot_dMarcas():String
exNot_dAs():String

```

Estado: Tienes métodos: exNot_dMarcas():String, exNot_dAs():String. Al final son de String y los imprimir normal
Intentar hacer un switch case para elegir categorias y fuentes.

--> Cuidado con el java SE 24. lo tienen en la librerías pque te revienta en cas

