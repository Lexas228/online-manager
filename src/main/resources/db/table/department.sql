--liquibase formatted sql

--changeset anon:department-1

create table online_manager.department(
        id bigserial not null primary key,
        department_type_id int8 not null references online_manager.department_type(id),
        shop_id int8 not null references online_manager.shop(id),
        is_active boolean not null default true
);