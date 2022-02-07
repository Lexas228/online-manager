--liquibase formatted sql

--changeset anon:base-1

create table online_manager.base(
        id BIGSERIAL NOT NULL,
        CONSTRAINT pk_base primary key (id)
);