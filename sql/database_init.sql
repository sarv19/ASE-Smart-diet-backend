CREATE DATABASE smartDiet DEFAULT CHARSET=utf8mb4 DEFAULT  COLLATE=utf8mb4_0900_ai_ci ;

USE smartDiet;

SET default_storage_engine = InnoDB;


CREATE USER smartDietdev IDENTIFIED BY 'smartDietdev';
create user smartDietdev@localhost identified by 'smartDietdev';

GRANT ALL PRIVILEGES ON smartDietdev.* TO dpmsdev@localhost ;