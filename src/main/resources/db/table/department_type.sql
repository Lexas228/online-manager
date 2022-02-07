--liquibase formatted sql

--changeset anon:department_type-1

create table online_manager.department_type(
        id bigserial not null primary key,
        name varchar(50) not null unique
);