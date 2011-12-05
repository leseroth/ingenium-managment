--Delete all info
delete from subasta_fabricante;
delete from subasta_oferta;
delete from subasta;
delete from itempo;
delete from producto;
delete from comercio;
delete from fabricante;
delete from oferta;
delete from purchaseorder;

--Crear comercios
insert into comercio(id,nit,nombre,direccion,email,codPais,codPostal)
  values (101,'800800888','Carulla','calle85 carrera 15','samigory@gmail.com','US','90210');
insert into comercio(id,nit,nombre) values (102,'com102','Comercio 102');
insert into comercio(id,nit,nombre) values (103,'com103','Comercio 103');
insert into comercio(id,nit,nombre) values (104,'com104','Comercio 104');
insert into comercio(id,nit,nombre) values (105,'com105','Comercio 105');

--Crear fabricantes
insert into fabricante(id,nit,nombre,direccion,email,codPais,codPostal)
  values (201,'700700777','Alpina','Calle 128','samigori15@hotmail.com','CO','110121');
insert into fabricante(id,nit,nombre,direccion,email,codPais,codPostal)
  values (202,'600600666','Zenu','Carrera 98 60-34','samigori15@hotmail.com','US','98103');
insert into fabricante(id,nit,nombre,direccion,email,codPais,codPostal)
  values (203,'500500555','Nestle', 'Carrera 15 100-25', 'ercos41@gmail.com','US','33157');
insert into fabricante(id,nit,nombre) values (204,'fab204','Fabricante 204');
insert into fabricante(id,nit,nombre) values (205,'fab205','Fabricante 205');

--Crear Productos
--No se como funciona la columna tiempoFabricacion en esta tabla
insert into producto(id,categoria,nombre,peso) values(2011,'Lacteos','Yogurt','2');
insert into producto(id,categoria,nombre,peso) values(2012,'Lacteos','Kumis','2');
insert into producto(id,categoria,nombre,peso) values(2013,'Lacteos','Leche','1');
insert into producto(id,categoria,nombre,peso) values(2014,'Lacteos','Queso','2');
insert into producto(id,categoria,nombre,peso) values(2021,'Papeleria','Cuaderno');
insert into producto(id,categoria,nombre,peso) values(2022,'Papeleria','Libreta','1');
insert into producto(id,categoria,nombre,peso) values(2023,'Papeleria','Lapicero','1');

--Crear PurchaseOrders y subastas
insert into itempo(id,cantidad,producto_id) values (1,100,2011);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(1,'EntregadoFabricante','num001',101,1);
insert into subasta(id, activa, numSeguimiento, po_id) values (1, true, 'num001', 1);

insert into itempo(id,cantidad,producto_id) values (2,110,2012);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(2,'SolicitadoComercio','num002',101,2);
insert into subasta(id, activa, numSeguimiento, po_id) values (2, true, 'num002', 2);

insert into itempo(id,cantidad,producto_id) values (3,200,2021);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(3,'EntregadoFabricante','num003',102,3);
insert into subasta(id, activa, numSeguimiento, po_id) values (3, true, 'num003', 3);

insert into itempo(id,cantidad,producto_id) values (4,210,2022);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(4,'SolicitadoComercio','num004',102,4);
insert into subasta(id, activa, numSeguimiento, po_id) values (4, false, 'num004', 4);

insert into itempo(id,cantidad,producto_id) values (5,210,2022);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(5,'SolicitadoComercio','num005',102,5);
insert into subasta(id, activa, numSeguimiento, po_id) values (5, true, 'num005', 5);

insert into itempo(id,cantidad,producto_id) values (6,210,2022);
insert into purchaseorder(id, estado, numSeguimiento, entrega, comercio_id, item_id)
  values(6, 'SolicitadoComercio', 'num006', '2011-10-20 11:00:00', 102, 6);
insert into subasta(id, activa, numSeguimiento, fechaCreacionSubasta, fechaMaxSubasta, po_id)
  values (6, true, 'num006', '2011-10-10 11:00:00', '2011-10-15 11:00:00', 6);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (6, 201);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (6, 202);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (6, 203);

insert into itempo(id,cantidad,producto_id) values (7,210,2022);
insert into purchaseorder(id, estado, numSeguimiento, entrega, comercio_id, item_id)
  values(7, 'SolicitadoComercio', 'num007', '2011-10-20 11:00:00', 102, 7);
insert into subasta(id, activa, numSeguimiento, fechaCreacionSubasta, fechaMaxSubasta, po_id)
  values (7, false, 'num007', '2011-10-10 11:00:00', '2011-10-15 11:00:00', 7);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (7, 201);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (7, 202);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (7, 203);

insert into itempo(id,cantidad,producto_id) values (8,100,2022);
insert into purchaseorder(id, estado, numSeguimiento, entrega, comercio_id, item_id)
  values(8, 'SolicitadoComercio', 'num008', '2011-10-20 11:00:00', 101, 8);
insert into subasta(id, activa, numSeguimiento, fechaCreacionSubasta, fechaMaxSubasta, po_id)
  values (8, true, 'num008', '2011-10-10 11:00:00', '2011-10-15 11:00:00', 8);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (8, 201);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (8, 202);
insert into subasta_fabricante(Subasta_id,fabricantes_id) values (8, 203);