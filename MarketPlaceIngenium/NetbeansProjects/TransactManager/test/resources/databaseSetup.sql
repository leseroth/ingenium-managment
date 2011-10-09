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
insert into comercio(id,nit,nombre) values (101,'com101','Comercio 101');
insert into comercio(id,nit,nombre) values (102,'com102','Comercio 102');
insert into comercio(id,nit,nombre) values (103,'com103','Comercio 103');
insert into comercio(id,nit,nombre) values (104,'com104','Comercio 104');
insert into comercio(id,nit,nombre) values (105,'com105','Comercio 105');

--Crear fabricantes
insert into fabricante(id,nit,nombre) values (201,'fab201','Fabricante 201');
insert into fabricante(id,nit,nombre) values (202,'fab202','Fabricante 202');
insert into fabricante(id,nit,nombre) values (203,'fab203','Fabricante 203');
insert into fabricante(id,nit,nombre) values (204,'fab204','Fabricante 204');
insert into fabricante(id,nit,nombre) values (205,'fab205','Fabricante 205');

--Crear Productos
--No se como funciona la columna tiempoFabricacion en esta tabla
insert into producto(id,categoria,nombre) values(2011,'Lacteos','Yogurt');
insert into producto(id,categoria,nombre) values(2012,'Lacteos','Kumis');
insert into producto(id,categoria,nombre) values(2013,'Lacteos','Leche');
insert into producto(id,categoria,nombre) values(2014,'Lacteos','Queso');
insert into producto(id,categoria,nombre) values(2021,'Papeleria','Cuaderno');
insert into producto(id,categoria,nombre) values(2022,'Papeleria','Libreta');
insert into producto(id,categoria,nombre) values(2023,'Papeleria','Lapicero');

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
insert into purchaseorder(id,estado,numSeguimiento,comercio_id, item_id) values(5,'SolicitadoComercio','num004',102,5);
insert into subasta(id, activa, numSeguimiento, po_id) values (5, true, 'num004', 5);