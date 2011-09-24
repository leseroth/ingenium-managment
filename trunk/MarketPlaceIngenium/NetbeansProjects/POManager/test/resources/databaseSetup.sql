--Delete all info
delete from dispatchadvice_itempo;
delete from dispatchadvice;
delete from purchaseorder_itempo;
delete from purchaseorder;
delete from returnmaterialadvice_itempo;
delete from returnmaterialadvice;
delete from itempo;
delete from producto;
delete from comercio;
delete from fabricante;

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
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2011,'Lacteos','Yogurt',1000,201);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2012,'Lacteos','Kumis',1200,201);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2013,'Lacteos','Leche',1400,201);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2014,'Lacteos','Queso',1600,201);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2021,'Papeleria','Cuaderno',2000,202);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2022,'Papeleria','Libreta',1800,202);
insert into producto(id,categoria,nombre,precio,fabricanteAtiende_id)
  values(2023,'Papeleria','Lapicero',1600,202);

--Crear PurchaseOrders Directo
insert into itempo(id,cantidad,producto_id) values (1,100,2011);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id,fabricante_id)
  values(1,'EntregadoFabricante','num001',101,201);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (1,1);

insert into itempo(id,cantidad,producto_id) values (2,110,2012);
insert into itempo(id,cantidad,producto_id) values (3,120,2013);
insert into itempo(id,cantidad,producto_id) values (4,130,2014);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id,fabricante_id)
  values(2,'SolicitadoComercio','num002',101,201);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (2,2);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (2,3);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (2,4);

-- Crear purchaseOrder normal
insert into itempo(id,cantidad,producto_id) values (5,200,2021);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id)
  values(3,'EntregadoFabricante','num003',102);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (3,5);

insert into itempo(id,cantidad,producto_id) values (6,210,2022);
insert into itempo(id,cantidad,producto_id) values (7,220,2023);
insert into purchaseorder(id,estado,numSeguimiento,comercio_id)
  values(4,'SolicitadoComercio','num004',102);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (4,6);
insert into purchaseorder_itempo(PurchaseOrder_id,items_id) values (4,7);