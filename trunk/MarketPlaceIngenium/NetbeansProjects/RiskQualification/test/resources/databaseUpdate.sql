CREATE TABLE listainternacional (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  estado boolean DEFAULT NULL,
  fecha date DEFAULT NULL,
  nit varchar(255) DEFAULT NULL,
  codPais varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);