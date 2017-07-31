# Evaluacion5
Sistema B&aacute;sico de Evaluaci&oacute;n

Basado en algunos ejercicios del sitio de capacitaci&oacute;n en l&iacute;nea [edureka!](https://www.edureka.co/) he desarrollado una aplicaci&oacute;n que funciona como un sistema muy b&aacute;sico de evaluaci&oacute;n.

El objetivo, más all&aacute; del sentido acad&eacute;mico, era satisfacer una necesidad especifica de un &oacute;rgano gubernamental que hasta el presente ha carecido por completo de apoyo y guía apropiada en lo que respecta al área de sistemas.

Las principales limitantes que he tenido que afrontar en esta labor (la mayor&iacute;a insustentables) han sido:
- Utilizar Netbeans como IDE.
- Desplegar sobre el servidor de aplicaciones Glassfish.
- Utilizar una versión no  actualizada de MySQL.

## Requisitos:

- Crear la base de datos.
- Cargar los ex&aacute;menes en el catalogo.
- Configurar el acceso a la base de datos.
- Colocar los archivos .xml correspondiente a la primera sección de los ex&aacute;menes.
- Editar el archivo exam2.jsp correspondiente a la segunda sección (Preguntas de Ordenamiento y Relaci&oacute;n) de los ex&aacute;menes.
- Editar el archivo exam3.jsp correspondiente a la tercera sección (Preguntas Abiertas) de los ex&aacute;menes.

### Creando la base de datos

Uno de los prerequisitos para el funcionamiento de la aplicaci&oacute;n es la creaci&oacute;n de la base de datos
Hay que ejecutar el script "create_table.sql" localizado en la carpeta "sql" del proyecto.

### Verificando catalogo de examenes

Otro de los prerequisitos para el funcionamiento de la aplicaci&oacute;n es la carga del catalogo de examenes.
En el script "create_table.sql" localizado en la carpeta "sql" del proyecto contamos con un ejemplo para realizar dicha tarea.
Para verificar que el catalogo se encuentra cargado podemos realizar una consulta sobre la tabla "quiz.examenes".

SELECT * FROM quiz.examenes;

NOTA: Los nombres de los ex&aacute;menes deben corresponderse con los nombres (sin sufijo) de los xml.

### Configurando el acceso a la base de datos

Para configurar el acceso a la base de datos debemos editar el archivo "dbConnection.properties",
originalmente ubicado en WEB-INF pero que puede ubicarse en alguna ruta externa al proyecto,  
y colocar los datos apropiados:

- jdbc.driver=com.mysql.jdbc.Driver
- jdbc.server=****
- jdbc.port=****
- jdbc.schema=quiz
- jdbc.username=****
- jdbc.password=****
- jdbc.useUnicode=true
- jdbc.useJDBCCompliantTimezoneShift=true
- jdbc.useLegacyDatetimeCode=false
- jdbc.serverTimezone=UTC

#### Verificando el acceso a la base de datos

Para comprobar que hayamos configurado apropiadamente el acceso a la base de datos contamos con un JUnit 
DatabaseConnectionFactoryTest. Al ejecutarlo deber&iacute;a de ejecutar satisfactoriamente.

### Archivos de examenes

Para el funcionamiento de la aplicacion debemos preparar los archivos de ex&aacute;menes (XML) y colocarlos en la ruta definida en la clase mx.rengifo.evaluacion.util.Constante.
En la carpeta sample-evaluaciones se incluyen algunos archivos que pueden utilizarse como plantilla para esta labor.

NOTA: Hay que cuidar de mantener la estructura correcta en los XMLs, 
    adem&aacute;s de recordar que el &iacute;ndice que indica la respuesta correcta es el numero de la respuesta menos uno (-1).

### Editar el archivo exam2.jsp

La segunda secci&oacute;n de los ex&aacute;menes son preguntas de ordenamiento y relaci&oacute;n las cuales est&aacute;n escritas en el archivo exam2.jsp
Hay que editar el archivo para ajustar las preguntas y opciones de respuesta antes de realizar la compilaci&oacute;n, empaquetado y despliegue del WAR.

### Editar el archivo exam3.jsp

La tercera secci&oacute;n de los ex&aacute;menes son preguntas abiertas las cuales est&aacute;n escritas en el archivo exam3.jsp
Hay que editar el archivo para ajustar las preguntas y opciones de respuesta antes de realizar la compilaci&oacute;n, empaquetado y despliegue del WAR.

## Configurando la aplicacion

La aplicacion NO est&aacute; preparada para ser configurada de manera din&aacute;mica. 
Las configuraciones deben realizarse previas a la compilaci&oacute;n, empaquetado y despliegue,
ajustando los valores en la clase: mx.rengifo.evaluacion.util.Constante

### Configurando el Inicio

La aplicaci&oacute;n permite configurar el URL o enlace que deseamos utilizar como inicio.
Solo hay que ajustar el valor de la constante URL

### Configurando el Background

La aplicaci&oacute;n permite configurar el background a utilizar. 
Puede elegir entre dos opciones: white | gray

Solo hay que ajustar el valor de la constante BACKGROUND

NOTA: Para incorporar otra opci&oacute;n debe contarse con una imagen background-{color}.jpg
     en la carpeta images/background

### Configurando el T&iacute;tulo

La aplicaci&oacute;n permite configurar el t&iacute;tulo a utilizar. 

Solo hay que ajustar el valor de la constante TITLE_GRAL

### Configurando el Sufijo a utilizar

La aplicaci&oacute;n permite configurar el sufijo utilizado en el nombrado de las evaluaciones
Los archivos xml de las evaluciones deben nombrarse con este sufijo

Solo hay que ajustar el valor de la constante SUFFIX

### Configurando la ubicacion del archivo properties

La aplicaci&oacute;n permite configurar la ubicacion del archivo properties donde se configura el acceso a la base de datos

Solo hay que ajustar el valor de la constante PATH_PROPERTIES

Nota: Debe incluir '\\' al final

### Configurando la ubicaci&oacute;n de los archivos de las evaluaciones

La aplicaci&oacute;n permite configurar la ubicaci&oacute;n de los archivos de las evaluaciones

Solo hay que ajustar el valor de la constante PATH_EVALUATIONS

Nota: Debe incluir '\\' al final

### Habilitando / Deshabilitando el log de las excepciones manejadas

La aplicaci&oacute;n permite habilitar el log de las excepciones manejadas para labores de revisi&oacute;n,
o deshabilitarlo para ambientes productivos.

Solo hay que ajustar el valor de la constante DEBUG_ENABLED


## NOTAS

### Retirando calificaci&oacute;n

Una vez que un usuario ha realizado un examen, 
se le asigna una calificaci&oacute;n y no podr&aacute; tomar nuevamente el examen.
Si por alg&uacute;n motivo se requiere que el usuario tome nuevamente el examen,
o si acaso estamos realizando labores de desarrollo o pruebas, 
requeriremos retirar la calificaci&oacute;n del usuario. Para ello, 
realizaremos un update sobre la tabla quiz.users filtrado por el email del usuario.

-- Update quiz.users SET calificacion=NULL where email='david@rengifo.mx';

SELECT * FROM quiz.users;

### Cambiando el rol

Es posible que por alg&uacute;n motivo se requiera cambiar el rol de un usuario. Para ello, 
realizaremos un update sobre la tabla quiz.users filtrado por el email del usuario.

-- Update quiz.users SET exam='rol4' where email='david@rengifo.mx';

---
[David Rengifo](http://david.rengifo.mx/) 2017 &#169; Derechos Reservados &middot; Orgullosamente respaldado por: [eRa5](http://era5.mx/).
