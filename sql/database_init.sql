CREATE DATABASE smartDiet DEFAULT CHARSET=utf8mb4 DEFAULT  COLLATE=utf8mb4_0900_ai_ci ;

USE smartDiet;

SET default_storage_engine = InnoDB;


CREATE USER smartDietDev IDENTIFIED BY 'smartDietDev@123';
create user smartDietDev@localhost identified by 'smartDietDev@123';

GRANT ALL PRIVILEGES ON smartDiet.* TO smartDietDev@'%';
GRANT ALL PRIVILEGES ON smartDiet.* TO smartDietDev@localhost;
flush privileges;