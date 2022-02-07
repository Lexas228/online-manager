--liquibase formatted sql

--changeset anon:product-1

create table online_manager.product(
        id bigserial not null primary key,
        name varchar(255) not null unique,
        product_type_id int8 not null references online_manager.product_type(id)
);
