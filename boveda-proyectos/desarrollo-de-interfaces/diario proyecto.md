
## 11/12/25
1. Component parentComponent
Es el componente padre sobre el que se va a centrar el JOptionPane.
Normalmente es this si estás dentro de un JFrame o JPanel.
Si pones null, el cuadro se centra en la pantalla.
Ejemplos:
this → se centra en la ventana actual.
null → se centra en el monitor.
2. Object message
Es lo que quieres mostrar dentro del cuadro de diálogo.
Puede ser:
String (lo normal)
JLabel
JPanel
Cualquier componente Swing
3. String title
Es el título de la ventana del diálogo.
Ejemplos:
"Confirmación"
"Aviso"
"¿Seguro?"
4. int optionType
Define qué botones tendrá el cuadro de diálogo.
Valores posibles:
JOptionPane.OK_CANCEL_OPTION
JOptionPane.YES_NO_OPTION
JOptionPane.YES_NO_CANCEL_OPTION
JOptionPane.DEFAULT_OPTION
Esto controla los botones, no el icono.
5. int messageType
Define el icono por defecto y el estilo del mensaje:
Valores posibles:
messageType	Icono
JOptionPane.ERROR_MESSAGE	❌
JOptionPane.INFORMATION_MESSAGE	ℹ️
JOptionPane.WARNING_MESSAGE	⚠️
JOptionPane.QUESTION_MESSAGE	?
JOptionPane.PLAIN_MESSAGE	sin icono


sb.append("--\nDEPORTES\n--\n")

.append("Titular 1: ").append(textArea_D1.getText()).append("\n")

.append("Titular 2: ").append(textArea_D2.getText()).append("\n")

.append("Titular 3: ").append(textArea_D3.getText()).append("\n")

.append("--\nECONOMIA\n--\n")

.append("Titular 4: ").append(textArea_E1.getText()).append("\n")

.append("Titular 5: ").append(textArea_E2.getText()).append("\n")

.append("Titular 6: ").append(textArea_E3.getText()).append("\n")

.append("--\nNACIONAL\n--\n")

.append("Titular 7: ").append(textArea_N1.getText()).append("\n")

.append("Titular 8: ").append(textArea_N2.getText()).append("\n")

.append("Titular 9: ").append(textArea_N3.getText()).append("\n")

.append("--\nINTERNACIONAL\n--\n")

.append("Titular 10: ").append(textArea_I1.getText()).append("\n")

.append("Titular 11: ").append(textArea_I2.getText()).append("\n")

.append("Titular 12: ").append(textArea_I3.getText()).append("\n")

.append("--\nMUSICA\n--\n")

.append("Titular 13: ").append(textArea_M1.getText()).append("\n")

.append("Titular 14: ").append(textArea_M2.getText()).append("\n")

.append("Titular 15: ").append(textArea_M3.getText()).append("\n")

.append("--\nALEATORIO\n--\n")

.append("Titular 16: ").append(textArea_A1.getText()).append("\n")

.append("Titular 17: ").append(textArea_A2.getText()).append("\n")

.append("Titular 18: ").append(textArea_A3.getText());

## 09/12 /25
Haz las funcionalidades que pedas
lAS PERSONALIZACIONES MINIMO 1 FUENTE
Lo de ver los paneles lo mejor es cargar todo y luego controlas visibilidades


## 07/12/2025

Objetivo: iniciar y tener login y todos los paneles de admin


--> para sacar la contraseña
https://www.youtube.com/watch?v=bMBsqqFHvJo

--> LO DE JOSE
https://stackoverflow.com/questions/1938774/jlabel-get-parent-panel 

## 06/12/2025
Objetivo: unir todo
Te sale mejor borrar y volver. 
HOY: carga y login separado

usate esto 

```
textArea.setLineWrap(true);  // ajuste por linea 
textArea.setWrapStyleWord(true); // ajuste por palabras 
```

usr: //no se puede cambiar y tu defines como el principio y el final de cada 

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

