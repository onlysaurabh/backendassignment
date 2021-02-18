CREATE TABLE warehouse (
  warehouse_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) DEFAULT NULL,
  location_lat VARCHAR(250) NOT NULL,
  location_long VARCHAR(250) NOT NULL,
  car_location VARCHAR(250) NOT NULL,
  car_id INT NOT NULL,
  car_make VARCHAR(250) NOT NULL,
  car_model VARCHAR(250) NOT NULL,
  car_year INT NOT NULL,
  car_price double NOT NULL,
  licensed boolean NOT NULL,
  car_date_added  VARCHAR(250) NOT NULL
  
);

CREATE TABLE cart (
  car_id INT PRIMARY KEY,
  car_make VARCHAR(250) NOT NULL,
  car_model VARCHAR(250) NOT NULL,
  car_year INT NOT NULL,
  car_price double NOT NULL, 
  licensed boolean NOT NULL,
  car_date_added  VARCHAR(250) NOT NULL
);
