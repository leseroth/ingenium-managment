ALTER TABLE purchaseorder ADD fabricante_id BIGINT(20);

alter table purchaseorder drop column item_id;

commit;