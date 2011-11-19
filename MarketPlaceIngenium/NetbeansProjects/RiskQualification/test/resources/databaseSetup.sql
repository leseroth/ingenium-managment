--Delete all info
delete from confecamara;
delete from datacredito;
delete from listasnegras;
delete from listainternacional;

insert into confecamara(id, estado, fecha, nit) values (1, true, '2011-10-10 11:00:00', "1");
insert into datacredito(id, calificacion, fecha, nit) values (1, 'D', '2011-10-10 11:00:00', "1");