INSERT INTO user(user_id,user_name,password,full_name,gender,email_address,phone_number,address)
value(2302092140111111,'tester00','','Aa Testa','male','testa@example.com','+10000000000','401 Sunset Ave, Windsor, ON N9B 3P4');
INSERT INTO user
value(2302092140222222,'tester01','','Bb Testb','female','testb@example.com','+21111111111','401 Sunset Ave, Windsor, ON N9B 3P4');
INSERT INTO user
value(2302092140333333,'tester02','','Cc Testc','universal','testc@example.com','+32222222222');
INSERT INTO user
value(2302092140444444,'tester03','','Dd Testd','unknown','testd@example.com','+8612345678901');

INSERT INTO recipe
value(2302092140444445,2302092140111111,'breakfast',null,780,800);
INSERT INTO recipe
value(2302092140444446,2302092140111111,'lunch',null,800,870);
INSERT INTO recipe
value(2302092140444447,2302092140222222,'dinner',null,570,650);
INSERT INTO recipe
value(2302092140444448,2302092140222222,'snack',null,300,400);

INSERT INTO ingredient
value(,'test_food_A','Apple',100);
INSERT INTO ingredient
value(,'test_food_B','Banana',70);
INSERT INTO ingredient
value(,'test_food_C','Coconut',66);
INSERT INTO ingredient
value(,'test_food_D','Dog',99);

INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,120,cal);
INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,210,cal);
INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,330,cal);

INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,240,cal);
INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,350,cal);
INSERT INTO recipe_detail
value(did,rid,iid,2302092140111111,140,cal);