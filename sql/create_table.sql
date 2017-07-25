create table users(username varchar(50) NOT NULL,email varchar(50) NOT NULL,password varchar(50),exam varchar(50) NOT NULL,calificacion varchar(50),fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP); 
ALTER TABLE `quiz`.`users`
ADD UNIQUE INDEX `username_UNIQUE` (`email` ASC)  COMMENT 'Los nombres de usuario deben ser unicos';
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT 'Los email deben ser unicos';

create table resultados(username varchar(50) NOT NULL,pregunta INT(3) NOT NULL,resultado TEXT,fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

create table examenes(exam varchar(50) NOT NULL,activo INT(1) NOT NULL,fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
ALTER TABLE `quiz`.`examenes` 
ADD PRIMARY KEY (`exam`)  COMMENT 'Los nombres de las examenes deben ser unicos';

/* 

-- Ejemplo de carga del catalogo de examenes
-- Los nombres de los examenes deben corresponderse con los nombres (sin sufijo) de los xml

INSERT INTO `quiz`.`examenes` (`exam`,`activo`) VALUES ('rol1', 1);
INSERT INTO `quiz`.`examenes` (`exam`,`activo`) VALUES ('rol2', 1);
INSERT INTO `quiz`.`examenes` (`exam`,`activo`) VALUES ('rol3', 1);
INSERT INTO `quiz`.`examenes` (`exam`,`activo`) VALUES ('rol4', 1);
INSERT INTO `quiz`.`examenes` (`exam`,`activo`) VALUES ('rol5', 1);

*/
