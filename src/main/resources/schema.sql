CREATE TABLE CarType
(
  id SERIAL NOT NULL,
  doors INT NOT NULL,
  model VARCHAR(255) NOT NULL,
  available_year DATE,
  PRIMARY KEY (id)
);