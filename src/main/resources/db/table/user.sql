--liquibase formatted sql

--changeset anon:user-1

create table online_manager.user(
    id bigserial not null primary key,
    login varchar(255) not null unique,
    password varchar(255) not null
);