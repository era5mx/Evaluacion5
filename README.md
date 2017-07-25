# Evaluacion5
Sistema Basico de Evaluacion

## Requisitos:

- Crear base de datos con el script create_table.sql
- Cargar los examenes en el catalogo
- Configurar el acceso a la base de datos
- Colocar los archivos .xml de los examenes

## Verificando catalogo de examenes

Uno de los prerequisitos para el funcionamiento de la aplicacion es la carga del catalogo de examenes
Para verificar que el catalogo se encuentra cargado podemos realizar una consulta sobre la tabla quiz.examenes

SELECT * FROM quiz.examenes;

NOTA: Los nombres de los examenes deben corresponderse con los nombres (sin sufijo) de los xml

## Retirando calificacion

Una vez que un usuario ha realizado un examen, 
se le asigna una calificación y no podrá tomar nuevamente el examen.
Si por algún motivo se requiere que el usuario tome nuevamente el examen,
o si acaso estamos realizando labores de desarrollo o pruebas, 
requeriremos retirar la calificación del usuario. Para ello, 
realizaremos un update sobre la tabla quiz.users filtrado por el email del usuario.

-- Update quiz.users SET calificacion=NULL where email='david@rengifo.mx';

SELECT * FROM quiz.users;


## Configurando la aplicacion

La aplicacion no esta preparada para ser configurada de manera dinamica. 
Las configuraciones deben realizarse previas a la compilacion, empaquetado y despliegue,
ajustando los valores en la clase: mx.rengifo.evaluacion.util.Constante

### Configurando el Inicio

La aplicacion permite configurar el URL o enlace que deseamos utilizar como inicio.
Solo hay que ajustar el valor de la constante URL

### Configurando el Background

La aplicacion permite configurar el background a utilizar. 
Puede elegir entre dos opciones: white | gray

Solo hay que ajustar el valor de la constante BACKGROUND

### Configurando el Titulo

La aplicacion permite configurar el titulo a utilizar. 

Solo hay que ajustar el valor de la constante TITLE_GRAL

### Configurando el Sufijo a utilizar

La aplicacion permite configurar el sufijo utilizado en el nombrado de las evaluaciones
Los archivos xml de las evaluciones deben nombrarse con este sufijo

Solo hay que ajustar el valor de la constante SUFFIX

### Configurando la ubicacion del archivo properties

La aplicacion permite configurar la ubicacion del archivo properties donde se configura el acceso a la base de datos

Solo hay que ajustar el valor de la constante PATH_PROPERTIES

Nota: Debe incluir '\\' al final

### Configurando la ubicacion de los archivos de las evaluaciones

La aplicacion permite configurar la ubicacion de los archivos de las evaluaciones

Solo hay que ajustar el valor de la constante PATH_EVALUATIONS

Nota: No debe incluir '\\' al final

### Habilitando / Deshabilita el log de las excepciones manejadas

La aplicacion permite habilitar el log de las excepciones manejadas para labores de revisión,
o deshabilitarlo para ambientes productivos.

Solo hay que ajustar el valor de la constante DEBUG_ENABLED


