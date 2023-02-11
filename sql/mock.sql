INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address)
    value (2302092140111111, 'tester00', 'cPw1898Mrqie8Eem6GqwNw==', 'Aa Testa', 'male', 'testa@example.com',
           '+10000000000', '401 Sunset Ave, Windsor, ON N9B 3P4');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number, address)
    value (2302092140222222, 'tester01', 'cPw1898Mrqie8Eem6GqwNw==', 'Bb Testb', 'female', 'testb@example.com',
           '+21111111111', '401 Sunset Ave, Windsor, ON N9B 3P4');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number)
    value (2302092140333333, 'tester02', 'cPw1898Mrqie8Eem6GqwNw==', 'Cc Testc', 'universal', 'testc@example.com',
           '+32222222222');
INSERT INTO user(user_id, user_name, password, full_name, gender, email_address, phone_number)
    value (2302092140444444, 'tester03', 'cPw1898Mrqie8Eem6GqwNw==', 'Dd Testd', 'unknown', 'testd@example.com',
           '+8612345678901');

INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2302092140444445, 2302092140111111, 'breakfast', 780, 800);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2302092140444446, 2302092140111111, 'lunch', 800, 870);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2302092140444447, 2302092140222222, 'dinner', 570, 650);
INSERT INTO meal(meal_id, user_id, meal_type, total_weight, total_calories)
    value (2302092140444448, 2302092140222222, 'snack', 300, 400);

INSERT INTO ingredient(ingredient_id, ingredient_name, description, calories)
    value (2302092140477448, 'test_food_A', 'apple', 100);
INSERT INTO ingredient(ingredient_id, ingredient_name, description, calories)
    value (2302092140477421, 'test_food_B', 'Banana', 70);
INSERT INTO ingredient(ingredient_id, ingredient_name, description, calories)
    value (2302092140477445, 'test_food_C', 'coconut', 66);
INSERT INTO ingredient(ingredient_id, ingredient_name, description, calories)
    value (2302092140477423, 'test_food_D', 'Dog', 99);

INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2302092240444445, 2302092140444445, 2302092140477448, 2302092140111111, 100000, 10000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2302092240443345, 2302092140444445, 2302092140477421, 2302092140111111, 200000, 14000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2302092240442245, 2302092140444445, 2302092140477445, 2302092140111111, 300000, 19800);

INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2302082240442245, 2302092140444446, 2302092140477421, 2302092140111111, 200000, 14000);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2202082240442245, 2302092140444446, 2302092140477445, 2302092140111111, 300000, 19800);
INSERT INTO meal_detail(detail_id, meal_id, ingredient_id, user_id, weight, calories)
    value (2102082240442245, 2302092140444446, 2302092140477423, 2302092140111111, 100000, 9900);