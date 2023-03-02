drop database if exists smartDiet;
create database smartDiet;
use smartDiet;

drop table if exists user;
create table user
(
    user_id                 BIGINT primary key comment 'user Id',
    user_name               varchar(100) not null,
    password                char(50)     not null,
    full_name               varchar(100) not null,
    gender                  char(10)     not null comment 'male, female, universal, unknown' default 'unknown',
    target_calories_min     int          not null,
    target_calories_max     int          not null,
    target_protein_min      int          null,
    target_protein_max      int          null,
    target_carbohydrate_max int          null,
    target_carbohydrate_min int          null,
    target_fat_min          int          null,
    target_fat_max          int          null,
    target_minerals_min     int          null,
    target_minerals_max     int          null,
    email_address           varchar(50)  not null,
    user_uid                char(50)     not null comment 'user unique id from Google, Facebook, etc.',
    phone_number            char(15)     null,
    address                 varchar(255) null,
    created_at              timestamp    not null                                            default current_timestamp,
    updated_at              timestamp    not null                                            default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists meal;
create table meal
(
    meal_id        BIGINT primary key comment 'meal Id',
    user_id        BIGINT    not null,
    user_uid       char(50)  not null comment 'user unique id from Google, Facebook, etc.',
    meal_type      char(10)  not null comment 'breakfast, lunch, dinner, snack',
    meal_date      datetime  null,
    total_weight   int       not null comment 'total weight(g) of one meal, it store target_calories_min before confirmed',
    total_calories int       not null comment 'total calories(mg) of one meal, it store target_calories_max before confirmed',
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
    calories        int          not null comment 'calories/100g',
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
    user_uid      char(50)  not null comment 'user unique id from Google, Facebook, etc.',
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

drop table if exists recipe;
create table recipe
(
    recipe_id           BIGINT primary key comment 'recipe Id',
    recipe_name         varchar(50)  not null,
    recipe_calories     int          null,
    recipe_cooking_time int          null comment 'minutes',
    recipe_portion      int          not null comment 'numbers of people for recipe',
    recipe_pic_url      varchar(100) not null comment 'picture for recipe',
    recipe_detail_url   varchar(100) not null comment 'detail of recipe',
    description         varchar(255) null comment 'allergen',
    created_at          timestamp    not null default current_timestamp,
    updated_at          timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists seasoner;
create table seasoner
(
    seasoner_id   BIGINT primary key comment 'seasoner id',
    seasoner_name varchar(50)  not null,
    description   varchar(100) not null comment 'english name/precise information about the seasoner',
    created_at    timestamp    not null default current_timestamp,
    updated_at    timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists recipe_content;
create table recipe_content
(
    recipe_content_id         BIGINT primary key comment 'recipe ingredient relationship id',
    recipe_id                 BIGINT comment 'recipe id',
    ingredient_id             BIGINT comment 'ingredient id',
    seasoner_id               BIGINT comment 'seasoner id',
    recipe_content_ingredient boolean comment 'true for have, false for none',
    recipe_content_seasoner   boolean comment 'true for have, false for none',
    description               varchar(100) null comment 'comment for relationship',
    created_at                timestamp    not null default current_timestamp,
    updated_at                timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;

drop table if exists eating_preference;
create table eating_preference
(
    preference_id BIGINT primary key comment 'preference id',
    user_id       BIGINT       not null comment 'user id',
    user_uid      BIGINT       not null comment 'user uid',
    ingredient_id BIGINT comment 'ingredient id',
    seasoner_id   BIGINT comment 'seasoner id',
    is_like       boolean comment 'true for like, false for dislike',
    is_allergen   boolean comment 'true for allergy, false for not',
    description   varchar(100) null comment 'reason why like or not',
    created_at    timestamp    not null default current_timestamp,
    updated_at    timestamp    not null default current_timestamp on update current_timestamp
) engine = innodb
  default charset = utf8mb4;