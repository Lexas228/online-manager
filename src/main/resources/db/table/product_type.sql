--liquibase formatted sql

--changeset anon:product_type-1

create table online_manager.product_type(
        id bigserial not null primary key,
        name varchar(255) not null unique,
        department_type_id int8 not null references online_manager.department_type(id)
);
