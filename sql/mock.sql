INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 target_calories_min, target_calories_max, user_uid)
    value (2023021021401001, 'tester00', '5gb8WEBlcW8xDhQqhshY1A==', 'Aa Testa', 'male', 'testa@example.com',
           '+10000000000', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200, 2000, '1');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 target_calories_min, target_calories_max, user_uid)
    value (2023021021401002, 'tester01', '1IGm5YkfWwQnWEkFgolGOA==', 'Bb Testb', 'female', 'testb@example.com',
           '+21111111111', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200, 2000, '2');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, target_calories_min,
                 target_calories_max, user_uid)
    value (2023021021401003, 'tester02', 'xBRWvDx6vF2Y8NBD1Jcebw==', 'Cc Testc', 'universal', 'testc@example.com',
           '+32222222222', 900, 1500, '3');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, target_calories_min,
                 target_calories_max, user_uid)
    value (2023021021401004, 'tester03', 'oQuEl19YljlQcRqDmi5GkA==', 'Dd Testd', 'unknown', 'testd@example.com',
           '+8612345678901', 900, 1500, '4');

# INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
#     value (2023020921401001, 2023021021401001, 'breakfast', 600000, 43800);
# INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
#     value (2023020921401002, 2023021021401001, 'lunch', 600000, 43700);
# INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
#     value (2023020921401003, 2023021021401002, 'dinner', 570, 650);
# INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
#     value (2023020921401004, 2023021021401002, 'snack', 300, 400);

INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401001, 2023021023502002, 'Apple', 'An apple is an edible fruit produced by an apple tree', 100);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401002, 2023021023502002, 'Banana', 'A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. ', 70);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401003, 2023021023502002, 'Coconut', 'The fruit of coconut tree  ', 66);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401004, 2023021023502001, 'Mutton', 'Mutton is the meat of a mature adult sheep, typically between two and three years old', 99);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401005, 2023021023502003, 'Spinach', 'a leafy green flowering plant native to central and western Asia', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401006, 2023021023502003, 'cabbage', 'It is a leafy green, red (purple), or white (pale green) biennial plant grown', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401007, 2023021023502003, 'lettuce', 'an annual plant of the family Asteraceae', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401008, 2023021023502004, 'milk', 'a white liquid food produced by the mammary glands of mammals.', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401009, 2023021023502004, 'skimmed milk', 'It is made when all the milk-fat is removed from whole milk.', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401010, 2023021023502005, 'green bean', 'Green beans are young, unripe fruits of various cultivars of the common bean.', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401011, 2023021023502005, 'soybean', 'a species of legume native to East Asia, widely grown for its edible bean', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401012, 2023021023502000, 'Maize', 'corn', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401013, 2023021023502000, 'rice', 'the seed of the grass species Oryza sativa (Asian rice) or less commonly O. glaberrima (African rice). ', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401014, 2023021023502000, 'pasta', 'a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401015, 2023021023502000, 'wheat', 'a grass widely cultivated for its seed, a cereal grain that is a worldwide staple food', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401016, 2023021023502000, 'bread', 'a staple food prepared from a dough of flour (usually wheat) and water, usually by baking.', 50);
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories)
    value (2023020821401017, 2023021023502001, 'beef', 'meat from cattle (Bos taurus)', 50);

INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411001, 2023020921401001, 2023020821401001, 2023021021401001, 100000, 10000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411002, 2023020921401001, 2023020821401002, 2023021021401001, 200000, 14000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411003, 2023020921401001, 2023020821401003, 2023021021401001, 300000, 19800);

INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411004, 2023020921401002, 2023020821401002, 2023021021401001, 200000, 14000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411005, 2023020921401002, 2023020821401003, 2023021021401001, 300000, 19800);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2023021021411006, 2023020921401002, 2023020821401004, 2023021021401001, 100000, 9900);

INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502000, 'grains', 'sugars');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502001, 'meat', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502002, 'fruit', 'vegetable'); # The fruit food group is sometimes combined with the vegetable food group
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502003, 'vegetable', 'vegetable');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502004, 'milk', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2023021023502005, 'beans', 'sugars');