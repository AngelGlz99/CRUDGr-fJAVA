-- Crear base 
CREATE DATABASE IF NOT EXISTS des3;

USE des3;
-- Borrar tabla
DROP TABLE alumnos;

-- crear tabla alumnos
CREATE TABLE IF NOT EXISTS alumnos(
	exp INT(3) NOT NULL AUTO_INCREMENT, 
	nombre VARCHAR(60) NOT NULL,
	sexo VARCHAR(1),
	PRIMARY KEY(exp)
	);
DROP TABLE materias;

CREATE TABLE IF NOT EXISTS materias(
	clave INT(5) NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	semestre VARCHAR(15) NOT NULL,
	nocreditos INT(3) NOT NULL,
	PRIMARY KEY(clave)
	);
DROP TABLE inscritos;

CREATE TABLE IF NOT EXISTS inscritos(
	id INT(3) NOT NULL AUTO_INCREMENT,
	exp INT(3) NOT NULL,
	clave INT(5) NOT NULL,
	PRIMARY KEY(id)
);

-- Agregar datos a alumnos
INSERT INTO alumnos(nombre,sexo)
values("Juan Lopez","M");
INSERT INTO alumnos(nombre,sexo)
values("Marcos Perez","M");
INSERT INTO alumnos(nombre,sexo)
values("Marcos Perez","M"),
	  ("Alejandra Villa","F"),
	  ("Manuel Morales","M");

-- Agregar a materias
INSERT INTO materias(clave,nombre,semestre,nocreditos)
values(1233,"Calculo","Primero",12),
	  (1564,"Quimica","Primero",10),
	  (2018,"Desarrollo 2","Segundo",20),
	  (2659,"Estructura de Datos","Tercero",22),
	  (2506,"Ingles para TI","Quinto",25);

-- Agregar a inscritos
INSERT INTO inscritos(exp,clave)
values(2,1233),
	  (2,1564),
	  (3,2018),
	  (1,2018),
	  (5,2506);

-- consulta alumnos
select * from alumnos;
-- consulta materias
select * from materias;
-- consulta inscritos
select * from inscritos;

-- modificar datos
-- UPDATE alumnos
	-- SET nombre="Jose Lopez"
	-- WHERE exp=1;

-- Borrar datos
-- DELETE FROM alumnos 
	-- WHERE exp = 4;


