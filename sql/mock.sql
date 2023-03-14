INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 user_uid)
    value (2023021021401001, 'tester00', '5gb8WEBlcW8xDhQqhshY1A==', 'Aa Testa', 'male', 'testa@example.com',
           '+10000000000', '401 Sunset Ave, Windsor, ON N9B 3P4', '1');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address,
                 user_uid)
    value (2023021021401002, 'tester01', '1IGm5YkfWwQnWEkFgolGOA==', 'Bb Testb', 'female', 'testb@example.com',
           '+21111111111', '401 Sunset Ave, Windsor, ON N9B 3P4', '2');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, user_uid)
    value (2023021021401003, 'tester02', 'xBRWvDx6vF2Y8NBD1Jcebw==', 'Cc Testc', 'universal', 'testc@example.com',
           '+32222222222', '3');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, user_uid)
    value (2023021021401004, 'tester03', 'oQuEl19YljlQcRqDmi5GkA==', 'Dd Testd', 'unknown', 'testd@example.com',
           '+8612345678901', '4');

INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max, is_active)
    value (2023030621401004, 2023021021401001, '1', 1500, 2000, true);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max, is_active)
    value (2023030621401005, 2023021021401002, '2', 1800, 2000, true);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max, is_active)
    value (2023030621401006, 2023021021401003, '3', 2000, 2300, true);
INSERT INTO user_target(target_id, user_id, user_uid, target_calories_min, target_calories_max, is_active)
    value (2023030621401007, 2023021021401004, '4', 1700, 1800, true);



truncate table ingredient_type;
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (1, 'meat', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (2, 'grains', 'sugars');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (3, 'vegetable', 'vegetable');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (4, 'fruit', 'vegetable'); # The fruit food group is sometimes combined with the vegetable food group
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (5, 'milk', 'protein');
INSERT INTO ingredient_type(type_id, type_name, base_type_name)
    value (6, 'other', 'seasoner');

truncate table ingredient;
INSERT INTO ingredient(ingredient_id, type_id, ingredient_name, description, calories, fat, carbohydrate, protein,
                       sodium)
Values (2023031414301000, 1, 'chicken breast', 'chicken breast', 136, 30, null, 254, null),
       (2023031414301001, 1, 'chicken thigh', 'chicken thigh', 250, 188, 3, 187, null),
       (2023031414301002, 1, 'shrimp', 'shrimp', 80, 10, 10, 150, null),
       (2023031414301003, 1, 'bacon strip', 'bacon strip', 640, 560, null, 400, null),
       (2023031414301004, 1, 'tilapia fillet', 'tilapia fillet', 90, 15, null, 190, null),
       (2023031414301005, 1, 'beef shank', 'beef shank', 228, 72, null, 380, null),
       (2023031414301006, 1, 'beef rib', 'beef rib', 383, 309, null, 244, null),
       (2023031414301007, 1, 'pork loin', 'pork loin', 120, 40, 10, 230, null),
       (2023031414301008, 1, 'egg', 'egg', 140, 100, null, 120, null),
       (2023031414301009, 1, 'ground beef', 'ground beef', 200, 120, null, 230, null),
       (2023031414301010, 1, 'salmon', 'salmon', 100, 25, null, 190, null),
       (2023031414301011, 1, 'tuna', 'tuna', 50, 10, null, 100, null),
       (2023031414301012, 2, 'corn', 'corn', 65, 10, 140, 25, null),
       (2023031414301013, 2, 'linguine', 'linguine', 220, 80, 430, 81, null),
       (2023031414301014, 2, 'white rice', 'white rice', 702, 11, 1547, 129, null),
       (2023031414301015, 3, 'onion', 'onion', 220, 10, 60, 220, null),
       (2023031414301016, 3, 'chick pea', 'chick pea', 72, 14, 86, 43, null),
       (2023031414301017, 3, 'celery', 'celery', 14, 2, 30, 6, null),
       (2023031414301018, 3, 'carrot', 'carrot', 26, 2, 61, 6, null),
       (2023031414301019, 3, 'zucchini', 'zucchini', 20, 4, 39, 15, null),
       (2023031414301020, 3, 'baby spinach', 'baby spinach', 12, null, null, 28, null),
       (2023031414301021, 3, 'broccoli', 'broccoli', 30, 3, 58, 25, null),
       (2023031414301022, 3, 'mushroom', 'mushroom', 21, 3, 31, 30, null),
       (2023031414301023, 3, 'green bell pepper', 'green bell pepper', 30, 2, 70, 12, null),
       (2023031414401000, 2, 'tortilla', 'tortilla', 750, 240, 1200, 210, 14400),
       (2023031414401001, 6, 'butter unsalted', 'butter unsalted', 256, 2880, null, null, null),
       (2023031414401002, 2, 'bread crumb', 'bread crumb', 310, 1000, 6000, 420, null),
       (2023031414401003, 2, 'tortilla chip', 'tortilla chip', 140, 700, 1900, 200, null),
       (2023031414401004, 5, 'cheddar cheese', 'cheddar cheese', 178, 1150, 150, 160, null),
       (2023031414401005, 5, 'cow milk', 'cow milk', 63, 350, 500, 300, null),
       (2023031414401006, 5, 'soy milk', 'soy milk', 81, 360, 1200, 630, null),
       (2023031414401007, 5, 'heavy cream', 'heavy cream', 548, 600, null, 440, null),
       (2023031414401008, 5, 'parmesan cheese', 'parmesan cheese', 431, 2900, 410, 380, null),
       (2023031414401009, 4, 'avocado', 'avocado', 231, 2300, 180, 440, null),
       (2023031414401010, 4, 'orange', 'orange', 62, 20, 1540, 120, null),
       (2023031414401011, 4, 'grape', 'grape', 69, 20, 1800, 70, null),
       (2023031414401012, 4, 'banana', 'banana', 105, 40, 2700, 130, null),
       (2023031414401013, 3, 'cherry tomato', 'cherry tomato', 15, 30, 210, 30, null),
       (2023031414401014, 3, 'potato', 'potato', 283, 1010, 4400, 540, null),
       (2023031414401015, 3, 'squash', 'squash', 18, 20, 360, 160, null),
       (2023031414401016, 6, 'olive oil', 'olive oil', 884, 1000, null, null, 20),
       (2023031414401017, 6, 'vinegar', 'vinegar', 18, null, null, null, 20),
       (2023031414401017, 6, 'soy sauce', 'soy sauce', 53, 6, 49, 80, 54930);