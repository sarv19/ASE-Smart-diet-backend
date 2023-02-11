CREATE DATABASE smartDiet DEFAULT CHARSET=utf8mb4 DEFAULT  COLLATE=utf8mb4_0900_ai_ci ;

USE smartDiet;

SET default_storage_engine = InnoDB;


CREATE USER smartDietDev IDENTIFIED BY 'smartDietDev';
create user smartDietDev@localhost identified by 'smartDietDev';

GRANT ALL PRIVILEGES ON smartDietDev.* TO dpmsdev@localhost ;