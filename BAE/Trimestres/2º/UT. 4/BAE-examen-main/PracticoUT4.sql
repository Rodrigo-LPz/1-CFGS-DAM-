-- Apartado (Consultas sobre una tabla). 


-- 3. Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.
SELECT apellido1, apellido2, nombre FROM alumno
    ORDER BY apellido1, apellido2, nombre ASC;

-- 4. Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
SELECT apellido1, apellido2, nombre, telefono FROM alumno
    WHERE telefono IS NULL;

-- 5. Devuelve el listado de los alumnos que nacieron en 1999.
SELECT apellido1, apellido2, nombre, fecha_nacimiento FROM alumno
    WHERE fecha_nacimiento BETWEEN '1999-01-01' AND '1999-12-31';

-- 6. Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en ‘K’.
SELECT apellido1, apellido2, nombre, nif, telefono FROM profesor
    WHERE telefono IS NULL AND nif LIKE '%K';





-- Apartado (Consultas sobre una tabla). 


-- 7. Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado 'Grado en Ingeniería Informática (Plan 2015)'.
SELECT asignatura.id, asignatura.nombre, asignatura.cuatrimestre, grado.nombre AS 'nombre grado' FROM asignatura
    INNER JOIN grado ON asignatura.id_grado = grado.id
    WHERE cuatrimestre = 1 AND curso = 3 AND grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 8. Devuelve un listado con los datos de todos los alumnos que se han matriculado alguna vez en el ‘Grado en Ingeniería Informática (Plan 2015)’.
SELECT alumno.apellido1, alumno.apellido2, alumno.nombre, grado.nombre AS 'nombre grado' FROM alumno
    INNER JOIN alumno_se_matricula_asignatura ON alumno.id = alumno_se_matricula_asignatura.id_alumno
    INNER JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id
    INNER JOIN grado ON asignatura.id_grado = grado.id
    WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 9. Devuelve un listado con todas las asignaturas ofertadas en el ‘Grado en Ingeniería Informática (Plan 2015)’.
SELECT asignatura.id, asignatura.nombre, grado.nombre AS 'nombre grado' FROM asignatura
    INNER JOIN grado ON asignatura.id_grado = grado.id
    WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 10. Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
SELECT profesor.apellido1, profesor.apellido2, profesor.nombre, departamento.nombre AS 'nombre departamento' FROM profesor
    INNER JOIN departamento ON profesor.id_departamento = departamento.id
    ORDER BY apellido1, apellido2, nombre ASC;

-- 11. Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con NIF ‘26902806M’.
SELECT asignatura.id, asignatura.nombre, curso_escolar.anyo_inicio AS 'año inicio', curso_escolar.anyo_fin AS 'año fin', alumno.nif, alumno_se_matricula_asignatura.id_alumno FROM alumno
    INNER JOIN alumno_se_matricula_asignatura ON alumno.id = alumno_se_matricula_asignatura.id_alumno
    INNER JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id
    INNER JOIN curso_escolar ON asignatura.id = curso_escolar.id
    WHERE alumno.nif = '26902806M';

-- 12. Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el ‘Grado en Ingeniería Informática (Plan 2015)’.
SELECT departamento.id, departamento.nombre AS 'nombre departamento' FROM departamento
    INNER JOIN profesor ON departamento.id = profesor.id_departamento
    INNER JOIN asignatura ON profesor.id = asignatura.id_profesor
    INNER JOIN grado ON asignatura.id_grado = grado.id
    WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 13. Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2015/2016.
SELECT alumno.id, alumno.nombre, alumno_se_matricula_asignatura.id_alumno, curso_escolar.anyo_inicio, curso_escolar.anyo_fin FROM alumno
    INNER JOIN alumno_se_matricula_asignatura ON alumno.id = alumno_se_matricula_asignatura.id_alumno
    INNER JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id
    INNER JOIN curso_escolar ON asignatura.id = curso_escolar.id
    WHERE curso_escolar.anyo_inicio = 2015 AND curso_escolar.anyo_fin = 2016;




-- Apartado (Consultas multitabla (composición externa). 


-- 14. Devuelve un listado con los departamentos que no tienen profesores asociados, ordenado alfabéticamente por nombre.
SELECT departamento.id, departamento.nombre AS 'nombre departamento' FROM departamento
    LEFT JOIN profesor ON departamento.id = profesor.id_departamento
    WHERE profesor.id_departamento IS NULL
    ORDER BY departamento.nombre ASC;

-- 15. Devuelve un listado con los profesores que no imparten ninguna asignatura, ordenado alfabéticamente por apellidos y nombre.
SELECT profesor.id, profesor.apellido1, profesor.apellido2, profesor.nombre FROM profesor
    LEFT JOIN asignatura ON profesor.id = asignatura.id_profesor
    WHERE asignatura.id_profesor IS NULL
    ORDER BY apellido1, apellido2, nombre ASC;

-- 16. Devuelve un listado con las asignaturas que no tienen un profesor asignado.
SELECT asignatura.id, asignatura.nombre FROM asignatura
    LEFT JOIN profesor ON asignatura.id_profesor = profesor.id
    WHERE profesor.id IS NULL;

-- 17. Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
SELECT departamento.id, departamento.nombre AS 'nombre departamento', asignatura.id, asignatura.nombre AS 'nombre asignatura' FROM departamento
    INNER JOIN profesor ON departamento.id = profesor.id_departamento
    INNER JOIN asignatura ON profesor.id = asignatura.id_profesor
    LEFT JOIN curso_escolar ON asignatura.id = curso_escolar.id
    WHERE curso_escolar.id IS NULL;





-- Apartado (Consultas resumen). 


-- 18. Devuelve el número total de alumnas que hay.
SELECT COUNT(*) AS 'numero total alumnas' FROM alumno
    WHERE sexo = 'M';

-- 19. Calcula cuántos alumnos nacieron en 1999.
SELECT COUNT(*) AS 'numero total alumnos nacidos en 1999' FROM alumno
    WHERE fecha_nacimiento BETWEEN '1999-01-01' AND '1999-12-31';

-- 20. .Calcula cuántos profesores hay en cada departamento. El resultado sólo debe mostrar dos columnas, una con el nombre del departamento y otra con el número de profesores que hay en ese departamento. El resultado sólo debe incluir los departamentos que tienen profesores asociados y deberá estar ordenado de mayor a menor por el número de profesores.
SELECT departamento.id, departamento.nombre AS 'nombre departamento', COUNT(profesor.id) AS 'numero profesores' FROM departamento
    INNER JOIN profesor ON departamento.id = profesor.id_departamento
    GROUP BY departamento.id
    ORDER BY COUNT(profesor.id) DESC;

-- 21. Devuelve un listado con todos los departamentos y el número de profesores que hay en cada uno de ellos. Tenga en cuenta que pueden existir departamentos que no tienen profesores asociados. Estos departamentos también tienen que aparecer en el listado.
SELECT departamento.id, departamento.nombre AS 'nombre departamento', COUNT(profesor.id) AS 'numero profesores' FROM departamento
    LEFT JOIN profesor ON departamento.id = profesor.id_departamento
    GROUP BY departamento.id;

-- 22. Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno. Tenga en cuenta que pueden existir grados que no tienen asignaturas asociadas. Estos grados también tienen que aparecer en el listado. El resultado deberá estar ordenado de mayor a menor por el número de asignaturas.
SELECT grado.id, grado.nombre AS 'nombre grado', COUNT(asignatura.id) AS 'numero asignaturas' FROM grado
    LEFT JOIN asignatura ON grado.id = asignatura.id_grado
    GROUP BY grado.id
    ORDER BY COUNT(asignatura.id) DESC;

-- 23. Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno, de los grados que tengan más de 40 asignaturas asociadas.
SELECT grado.id, grado.nombre AS 'nombre grado', COUNT(asignatura.id) AS 'numero asignaturas' FROM grado
    LEFT JOIN asignatura ON grado.id = asignatura.id_grado
    GROUP BY grado.id
    HAVING COUNT(asignatura.id) > 40;

-- 24. Devuelve un listado que muestre el nombre de los grados y la suma del número total de créditos que hay para cada tipo de asignatura. El resultado debe tener tres columnas: nombre del grado, tipo de asignatura y la suma de los créditos de todas las asignaturas que hay de ese tipo. Ordene el resultado de mayor a menor por el número total de créditos.
SELECT grado.id, grado.nombre AS 'nombre grado', asignatura.tipo, SUM(asignatura.creditos) AS 'suma creditos' FROM grado
    INNER JOIN asignatura ON grado.id = asignatura.id_grado
    GROUP BY grado.id, asignatura.tipo
    ORDER BY SUM(asignatura.creditos) DESC;

-- 25. Devuelve un listado que muestre cuántos alumnos se han matriculado de alguna asignatura en cada uno de los cursos escolares. El resultado deberá mostrar dos columnas, una columna con el año de inicio del curso escolar y otra con el número de alumnos matriculados.
SELECT curso_escolar.anyo_inicio AS 'año inicio', COUNT(alumno_se_matricula_asignatura.id_alumno) AS 'numero alumnos matriculados' FROM curso_escolar
    INNER JOIN asignatura ON curso_escolar.id = asignatura.id
    INNER JOIN alumno_se_matricula_asignatura ON asignatura.id = alumno_se_matricula_asignatura.id_asignatura
    GROUP BY curso_escolar.anyo_inicio;

-- 26. Devuelve un listado con el número de asignaturas que imparte cada profesor. El listado debe tener en cuenta aquellos profesores que no imparten ninguna asignatura. El resultado mostrará cinco columnas: id, nombre, primer apellido, segundo apellido y número de asignaturas. El resultado estará ordenado de mayor a menor por el número de asignaturas.
SELECT profesor.id, profesor.nombre, profesor.apellido1, profesor.apellido2, COUNT(asignatura.id) AS 'numero asignaturas' FROM profesor
    LEFT JOIN asignatura ON profesor.id = asignatura.id_profesor
    GROUP BY profesor.id
    ORDER BY COUNT(asignatura.id) DESC;





-- Apartado (Subconsultas). 


-- 27. Devuelve todos los datos del alumno más joven.
SELECT * FROM alumno
    WHERE fecha_nacimiento = (SELECT MIN(fecha_nacimiento) FROM alumno);

-- 28. Devuelve un listado con los departamentos que no tienen profesores asociados.
SELECT * FROM departamento
    WHERE id NOT IN (SELECT id_departamento FROM profesor);

-- 29. Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten ninguna asignatura.
SELECT * FROM profesor
    WHERE id_departamento IS NOT NULL AND id NOT IN (SELECT id_profesor FROM asignatura);

-- 30. Devuelve un listado con los departamentos que no tienen profesores asociados.
SELECT * FROM departamento
    WHERE id NOT IN (SELECT id_departamento FROM profesor);