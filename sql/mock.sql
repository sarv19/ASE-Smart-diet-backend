INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address, target_calories_min,target_calories_max)
    value (2023021021401001, 'tester00', 'cPw1898Mrqie8Eem6GqwNw==', 'Aa Testa', 'male', 'testa@example.com',
           '+10000000000', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200,2000);
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address, target_calories_min,target_calories_max)
    value (2023021021401002, 'tester01', 'cPw1898Mrqie8Eem6GqwNw==', 'Bb Testb', 'female', 'testb@example.com',
           '+21111111111', '401 Sunset Ave, Windsor, ON N9B 3P4', 1200,2000);
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, target_calories_min,target_calories_max)
    value (2023021021401003, 'tester02', 'cPw1898Mrqie8Eem6GqwNw==', 'Cc Testc', 'universal', 'testc@example.com',
           '+32222222222', 900,1500);
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, target_calories_min,target_calories_max)
    value (2023021021401004, 'tester03', 'cPw1898Mrqie8Eem6GqwNw==', 'Dd Testd', 'unknown', 'testd@example.com',
           '+8612345678901', 900,1500);

INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2023020921401001, 2023021021401001, 'breakfast', 600000, 43800);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2023020921401002, 2023021021401001, 'lunch', 600000, 43700);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2023020921401003, 2023021021401002, 'dinner', 570, 650);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2023020921401004, 2023021021401002, 'snack', 300, 400);

INSERT INTO ingredient(ingredient_id,type_id, ingredient_name, description, calories)
    value (2023020821401001,2023021023502002, 'test_food_A', 'apple', 100);
INSERT INTO ingredient(ingredient_id,type_id, ingredient_name, description, calories)
    value (2023020821401002,2023021023502002, 'test_food_B', 'Banana', 70);
INSERT INTO ingredient(ingredient_id,type_id, ingredient_name, description, calories)
    value (2023020821401003,2023021023502002, 'test_food_C', 'coconut', 66);
INSERT INTO ingredient(ingredient_id,type_id, ingredient_name, description, calories)
    value (2023020821401004,2023021023502001, 'test_food_D', 'Dog', 99);

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
    
INSERT INTO ingredient_type(type_id,type_name)
	value (2023021023502001,'meet');
INSERT INTO ingredient_type(type_id,type_name)
	value (2023021023502002,'fruit');