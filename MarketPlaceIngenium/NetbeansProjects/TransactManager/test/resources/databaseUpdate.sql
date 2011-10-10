-- Ejecutar este script solo una vez
ALTER TABLE subasta_fabricante DROP KEY fabricantes_id;
ALTER TABLE  subasta_fabricante  ADD UNIQUE KEY (Subasta_id, fabricantes_id);

ALTER TABLE subasta_oferta DROP KEY ofertas_id;
ALTER TABLE  subasta_oferta  ADD UNIQUE KEY (Subasta_id, ofertas_id);