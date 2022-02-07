--liquibase formatted sql

--changeset anon:purchase_part_history-1

create table online_manager.purchase_part_history(
        id bigserial not null primary key,
        product_id int8 not null references online_manager.product(id),
        count int8 not null check ( count >= 0 ) default 0,
        purchase_history_id int8 not null references online_manager.purchase_history(id)
);

