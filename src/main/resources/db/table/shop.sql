--liquibase formatted sql

--changeset anon:role-1

create table online_manager.shop(
    id bigserial not null primary key,
    name varchar(255) not null unique
);