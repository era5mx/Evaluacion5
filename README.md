# Evaluacion5
Sistema Basico de Evaluacion

Requisitos:

Crear base de datos con el script create_table.sql
Cargar los examenes en el catalogo
Configurar el acceso a la base de datos
Colocar los archivos .xml de los examenes

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


