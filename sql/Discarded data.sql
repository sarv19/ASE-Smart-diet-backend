# drop table if exists recipe;
# create table recipe
# (
#     recipe_id           BIGINT primary key comment 'recipe Id',
#     recipe_name         varchar(50)  not null,
#     recipe_calories     int          null,
#     recipe_cooking_time int          null comment 'minutes',
#     recipe_portion      int          not null comment 'numbers of people for recipe',
#     recipe_pic_url      varchar(100) not null comment 'picture for recipe',
#     recipe_detail_url   varchar(100) not null comment 'detail of recipe',
#     description         varchar(255) null comment 'allergen',
#     created_at          timestamp    not null default current_timestamp,
#     updated_at          timestamp    not null default current_timestamp on update current_timestamp
# ) engine = innodb
#   default charset = utf8mb4;

# drop table if exists seasoner;
# create table seasoner
# (
#     seasoner_id   BIGINT primary key comment 'seasoner id',
#     seasoner_name varchar(50)  not null,
#     description   varchar(100) not null comment 'english name/precise information about the seasoner',
#     created_at    timestamp    not null default current_timestamp,
#     updated_at    timestamp    not null default current_timestamp on update current_timestamp
# ) engine = innodb
#   default charset = utf8mb4;

# drop table if exists recipe_content;
# create table recipe_content
# (
#     recipe_content_id         BIGINT primary key comment 'recipe ingredient relationship id',
#     recipe_id                 BIGINT comment 'recipe id',
#     ingredient_id             BIGINT comment 'ingredient id',
# #     seasoner_id               BIGINT comment 'seasoner id',
#     recipe_content_ingredient boolean comment 'true for have, false for none',
#     recipe_content_seasoner   boolean comment 'true for have, false for none',
#     description               varchar(100) null comment 'comment for relationship',
#     created_at                timestamp    not null default current_timestamp,
#     updated_at                timestamp    not null default current_timestamp on update current_timestamp
# ) engine = innodb
#   default charset = utf8mb4;

# Note: The following data is old and has been discarded.

/*truncate table ingredient;
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401001, 4, 'Apple', 'An apple is an edible fruit produced by an apple tree', 53);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401002, 4, 'Banana', 'A banana is an elongated, edible fruit. ', 93);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401003, 4, 'Coconut', 'The fruit of coconut tree  ', 241);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401004, 1, 'Mutton',
           'Mutton is the meat of a mature adult sheep, typically between two and three years old', 118);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401005, 3, 'Spinach', 'a leafy green flowering plant native to central and western Asia', 28);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401006, 3, 'cabbage',
           'It is a leafy green, red (purple), or white (pale green) biennial plant grown', 24);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401007, 3, 'lettuce', 'an annual plant of the family Asteraceae', 18);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401008, 5, 'milk', 'a white liquid food produced by the mammary glands of mammals.', 66);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401009, 5, 'skimmed milk', 'It is made when all the milk-fat is removed from whole milk.', 33);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401010, 6, 'green bean',
           'Green beans are young, unripe fruits of various cultivars of the common bean.', 329);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401011, 6, 'soybean', 'a species of legume native to East Asia, widely grown for its edible bean',
           390);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401012, 2, 'Maize', 'corn', 112);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401013, 2, 'rice', 'the seed of the grass species. ', 346);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401014, 2, 'pasta',
           'a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs', 351);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401015, 2, 'wheat',
           'a grass widely cultivated for its seed, a cereal grain that is a worldwide staple food', 338);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401016, 2, 'bread',
           'a staple food prepared from a dough of flour (usually wheat) and water, usually by baking.', 313);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401017, 1, 'beef', 'meat from cattle (Bos taurus)', 125);*/