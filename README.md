# NoHibernar
 Programa para evitar que la pc entre en hibernacion mediante el movimiento del mouse de modo random 
 
<img src="https://github.com/ringostarr-jaime/NoHibernar/blob/main/1.JPG" width="650" >
</br>
<p>Al dar click en iniciar dependiendo del tiempo elegido el mouse se movera</p>
<img src="https://github.com/ringostarr-jaime/NoHibernar/blob/main/2.JPG" width="650" >
<br/>

El jar ya generado esta en la carpeta Copilado-jar basta con descargar y dar doble click para correrlo
en caso en su empresa no se pueda descargar puede generar el jar mediante los siguientes comandos

Abrir CMD ubicarse en la carpeta con los archivos java

//---Paso 1 copilar los archivos java
javac *.java
//---Paso 2 crear el jar y copiar el manifest dentro del jar mediante el siguiente comando
jar cmf MANIFEST.MF NOhibernar.jar Main.class
//---Paso 3 Modificar jar terminar de pasar los demas archivos class con el siguiente comando
jar -uf NOhibernar.jar ventana$1.class ventana$2.class ventana$3.class ventana$MouseMoveThread.class ventana.class

//---Se puede correr mediante este comando o dando doble click sobre el jar generado
java -jar NOhibernar.jar
