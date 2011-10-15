-- Ejecutar este script solo una vez
ALTER TABLE subasta_fabricante DROP KEY fabricantes_id;
ALTER TABLE  subasta_fabricante  ADD UNIQUE KEY (Subasta_id, fabricantes_id);

ALTER TABLE subasta_oferta DROP KEY ofertas_id;
ALTER TABLE  subasta_oferta  ADD UNIQUE KEY (Subasta_id, ofertas_id);

alter table comercio add email varchar(255);
alter table comercio add codPostal varchar(255);
alter table comercio add codPais varchar(255);

alter table fabricante add direccion varchar(255);
alter table fabricante add codPostal varchar(255);
alter table fabricante add codPais varchar(255);