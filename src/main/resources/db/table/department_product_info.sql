--liquibase formatted sql

--changeset anon:department_product_info-1

create table online_manager.department_product_info(
        id bigserial not null primary key,
        product_id int8 not null references online_manager.product(id),
        department_id int8 not null references online_manager.department(id),
        percent float8 not null default 130 check (percent >= 0),
        actual_count int8 not null check (actual_count >= 0),
        required_count int8 not null check (required_count >= 0),
        auto_buying boolean not null default true,
        chosen_base_product_info_id int8 not null references online_manager.base_product_info(id)
);