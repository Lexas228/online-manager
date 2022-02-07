--liquibase formatted sql

--changeset anon:base_product_info-1

CREATE TABLE online_manager.base_product_info(
            id BIGSERIAL NOT NULL primary key,
            product_id int8 not null references online_manager.product(id),
            base_id int8 not null references online_manager.base(id),
            price float4 not null,
            count int8 not null
);
