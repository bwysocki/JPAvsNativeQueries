DROP ALL OBJECTS;

SET SCHEMA PUBLIC;

CREATE TABLE CarType
(
  id SERIAL NOT NULL,
  doors INT NOT NULL,
  model VARCHAR(255) NOT NULL,
  available_year DATE,
  PRIMARY KEY (id)
);

CREATE TABLE Client
(
  id SERIAL NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Car
(
  id SERIAL NOT NULL,
  car_type INT NOT NULL,
  registration_nr VARCHAR(255) NOT NULL,
  production_year DATE,
  PRIMARY KEY (id),
  FOREIGN KEY (car_type) REFERENCES CarType(id)
);

CREATE TABLE CarClient
(
  id SERIAL NOT NULL,
  car_id INT NOT NULL,
  client_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (car_id) REFERENCES Car(id),
  FOREIGN KEY (client_id) REFERENCES Client(id)
);