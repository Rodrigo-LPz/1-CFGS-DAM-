DROP DATABASE IF EXISTS alquilercoches;

CREATE DATABASE IF NOT EXISTS alquilercoches;
USE alquilercoches;


CREATE TABLE Cliente
(
  DNI INT NOT NULL,
  Nombre INT NOT NULL,
  Dirección INT NOT NULL,
  Teléfono INT NOT NULL,
  ID INT NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE Coche_alquilado
(
  Litros_de_gasolina_depósito INT NOT NULL,
  Nº_de_coches INT NOT NULL,
  €/h INT NOT NULL,
  Matrícula INT NOT NULL,
  PRIMARY KEY (Matrícula)
);

CREATE TABLE Avala/Grantiza
(
  ID_1 INT NOT NULL,
  ID_2 INT NOT NULL,
  PRIMARY KEY (ID_1, ID_2),
  FOREIGN KEY (ID_1) REFERENCES Cliente(ID),
  FOREIGN KEY (ID_2) REFERENCES Cliente(ID)
);

CREATE TABLE Coche
(
  Color INT NOT NULL,
  Modelo INT NOT NULL,
  Matrícula INT NOT NULL,
  Marca INT NOT NULL,
  PRIMARY KEY (Matrícula)
);

CREATE TABLE Reserva
(
  Nº_de_identificación INT NOT NULL,
  Fecha_inicial INT NOT NULL,
  Fecha_final INT NOT NULL,
  Precio_total INT NOT NULL,
  ID INT NOT NULL,
  Matrícula INT NOT NULL,
  FOREIGN KEY (ID) REFERENCES Cliente(ID),
  FOREIGN KEY (Matrícula) REFERENCES Coche_alquilado(Matrícula)
);

CREATE TABLE Corresponde
(
  Matrícula INT NOT NULL,
  Matrícula INT NOT NULL,
  FOREIGN KEY (Matrícula) REFERENCES Coche_alquilado(Matrícula),
  FOREIGN KEY (Matrícula) REFERENCES Coche(Matrícula)
);