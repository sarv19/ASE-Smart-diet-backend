INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 user_uid)
    value (2023021021401001, 'tester00', '5gb8WEBlcW8xDhQqhshY1A==', 'Aa Testa', 'male', 'testa@example.com',
           '+10000000000', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200, 2000, '1');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 user_uid)
    value (2023021021401002, 'tester01', '1IGm5YkfWwQnWEkFgolGOA==', 'Bb Testb', 'female', 'testb@example.com',
           '+21111111111', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200, 2000, '2');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, user_uid)
    value (2023021021401003, 'tester02', 'xBRWvDx6vF2Y8NBD1Jcebw==', 'Cc Testc', 'universal', 'testc@example.com',
           '+32222222222', 900, 1500, '3');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, user_uid)
    value (2023021021401004, 'tester03', 'oQuEl19YljlQcRqDmi5GkA==', 'Dd Testd', 'unknown', 'testd@example.com',
           '+8612345678901', 900, 1500, '4');

INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max)
    value (2023030621401004, 2023021021401001, '1', 1200, 2000);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max)
    value (2023030621401005, 2023021021401002, '2', 1200, 2000);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max)
    value (2023030621401006, 2023021021401003, '3', 900, 1500);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max)
    value (2023030621401007, 2023021021401004, '4', 900, 1500);

truncate table ingredient;
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
    value (2023020821401017, 1, 'beef', 'meat from cattle (Bos taurus)', 125);

truncate table ingredient_type;
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2, 'grains', 'sugars');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (1, 'meat', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (4, 'fruit', 'vegetable'); # The fruit food group is sometimes combined with the vegetable food group
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (3, 'vegetable', 'vegetable');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (5, 'milk', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (6, 'beans', 'sugars');