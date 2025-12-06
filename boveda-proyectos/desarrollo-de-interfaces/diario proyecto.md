## 06/12/2025
Objetivo: unir todo
Te sale mejor borrar y volver. 
HOY: carga y login separado

usate esto 

```
textArea.setLineWrap(true);  // ajuste por linea 
textArea.setWrapStyleWord(true); // ajuste por palabras 
```


## 05/12/2025

Objetivo: lo de noticias per o por la parte de admin. Pilla lo que tienes y que lo muestras (la parte del test)

Estado: Ventana de config y lo de mandar email hecho. Junta todo antes de seguir. Siguiente paso es tener clases diididas (creo que por cada JPanel hay una y dos JFrames)

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

12:45
Se te va a index out of bounds pqeu no sabe que le estas pasando 
ten uno soo de titular al que le psas el string de web y segun sea te exponga en un solo lbl el titular


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

