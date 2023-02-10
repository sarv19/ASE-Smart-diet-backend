create database smart_diet;
use smart_diet;

drop table if exists user;
create table user
(
    user_id       BIGINT primary key comment 'user Id',
    user_name     varchar(100) not null,
    password      char(50)     not null,
    full_name     varchar(100) not null,
    gender        char(10)     not null comment 'male, female, universal, unknown' default 'unknown',
    email_address varchar(50)  null,
    phone_number  char(15)     null,
    address       varchar(255) null,
    created_at    timestamp    not null                                            default current_timestamp,
    updated_at    timestamp    not null                                            default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists recipe;
create table recipe
(
    recipe_id     BIGINT primary key comment 'recipe Id',
    user_id        BIGINT    not null,
    recipe_type   char(10)  not null comment 'breakfast, lunch, dinner, snack',
    recipe_time   datetime  null,
    total_weight   int       not null comment 'total weight of one meal',
    total_calories int       not null comment 'total calories of one meal',
    created_at     timestamp not null default current_timestamp,
    updated_at     timestamp not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists ingredient;
create table ingredient
(
    ingredient_id BIGINT primary key comment 'ingredient Id',
    food_name    varchar(50)  not null,
    description   varchar(100) not null comment 'english name of food',
    calories     int          not null comment 'mg/1000g',
    fat          int          null comment 'mg/1000g',
    carbohydrate int          null comment 'mg/1000g',
    protein      int          null comment 'mg/1000g',
    sodium       int          null comment 'mg/1000g',
    created_at   timestamp    not null default current_timestamp,
    updated_at   timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists recipe_detail;
create table recipe_detail
(
    detail_id    BIGINT primary key comment 'detail id',
    recipe_id   BIGINT    not null,
    ingredient_id BIGINT    not null,
    user_id      BIGINT    not null,
    weight       int       not null comment 'weight of this ingredient in this recipe',
    calories     int       not null comment 'calories of this ingredient in this recipe',
    created_at   timestamp not null default current_timestamp,
    updated_at   timestamp not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;