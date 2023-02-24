drop database if exists smart_diet;
create database smart_diet;
use smart_diet;

drop table if exists user;
create table user
(
    user_id             BIGINT primary key comment 'user Id',
    user_name           varchar(100) not null,
    password            char(50)     not null,
    full_name           varchar(100) not null,
    gender              char(10)     not null comment 'male, female, universal, unknown' default 'unknown',
    target_calories_min int          not null,
    target_calories_max int          not null,
    email_address       varchar(50)  not null,
    user_uid            char(50)     not null comment 'user unique id from Google, Facebook, etc.',
    phone_number        char(15)     null,
    address             varchar(255) null,
    created_at          timestamp    not null                                            default current_timestamp,
    updated_at          timestamp    not null                                            default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists meal;
create table meal
(
    meal_id        BIGINT primary key comment 'meal Id',
    user_id        BIGINT    not null,
    meal_type      char(10)  not null comment 'breakfast, lunch, dinner, snack',
    meal_date      datetime  null,
    total_weight   int       not null comment 'total weight(g) of one meal',
    total_calories int       not null comment 'total calories(mg) of one meal',
    created_at     timestamp not null default current_timestamp,
    updated_at     timestamp not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists ingredient;
create table ingredient
(
    ingredient_id   BIGINT primary key comment 'ingredient Id',
    type_id         BIGINT comment 'type_id',
    ingredient_name varchar(50)  not null,
    description     varchar(100) not null comment 'english name/precise information about the ingredient',
    calories        int          not null comment 'mg/1000g',
    fat             int          null comment 'mg/1000g',
    carbohydrate    int          null comment 'mg/1000g',
    protein         int          null comment 'mg/1000g',
    sodium          int          null comment 'mg/1000g',
    created_at      timestamp    not null default current_timestamp,
    updated_at      timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists meal_detail;
create table meal_detail
(
    detail_id     BIGINT primary key comment 'meal detail id',
    meal_id       BIGINT    not null,
    ingredient_id BIGINT    not null,
    user_id       BIGINT    not null,
    weight        int       not null comment 'weight(g) of this ingredient in this recipe * 1000',
    calories      int       not null comment 'calories(mg) of this ingredient in this recipe',
    created_at    timestamp not null default current_timestamp,
    updated_at    timestamp not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists ingredient_type;
create table ingredient_type
(
    type_id        BIGINT primary key comment 'type Id',
    type_name      varchar(50)  not null,
    base_type_name varchar(50)  not null,
    type_comment   varchar(255) null,
    created_at     timestamp    not null default current_timestamp,
    updated_at     timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;