/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nalog_ot01
 * Created: 01.02.2021
 */
create table role_table
(
    id   serial      not null
        constraint role_table_pk
        primary key,
    name varchar(20) not null
);

alter table role_table
    owner to postgres;

create table user_table
(
    id       serial not null
        constraint user_table_pk
        primary key,
    login    varchar(50),
    password varchar(500),
    role_id  integer
        constraint user_table_role_table_id_fk
        references role_table
);

alter table user_table
    owner to postgres;

create unique index user_table_login_uindex
    on user_table (login);

insert into role_table(name) values ('ROLE_ADMIN');
insert into role_table(name) values ('ROLE_USER');

