--liquibase formatted sql

--changeset anon:user_roles-1

create table online_manager.user_roles(
    user_id int8 not null references online_manager.user(id),
    role_id int8 not null references online_manager.role(id),
    constraint pk_user_roles primary key (user_id, role_id)
);