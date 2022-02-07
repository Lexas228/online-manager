--liquibase formatted sql

--changeset anon:purchase_history-1

create table online_manager.purchase_history(
        id bigserial not null primary key,
        user_id int8 not null references online_manager.user(id),
        department_id int8 not null references online_manager.department(id),
        total_cost float8 not null default 0 check ( total_cost >= 0 ),
        description text default 'cool!',
        date date not null
);
