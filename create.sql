CREATE DATABASE travel_agency;

USE travel_agency;

CREATE TABLE countries(
	country_id INT PRIMARY KEY,
	name VARCHAR(30) NOT NULL UNIQUE,
	need_visa BOOLEAN NOT NULL); 
    
CREATE TABLE cities(
	city_id INT AUTO_INCREMENT PRIMARY KEY,
	country_id INT NOT NULL,
    name VARCHAR (100) NOT NULL UNIQUE, 
	CONSTRAINT fk_cities_countries FOREIGN KEY (country_id) REFERENCES countries(country_id));
    
CREATE TABLE hotels (
	hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    city_id INT NOT NULL,
    name VARCHAR(150) NOT NULL,
    rooms_count INT NOT NULL,
    CONSTRAINT fk_hotels_cities FOREIGN KEY (city_id) REFERENCES cities(city_id));
    
CREATE TABLE clients(
	client_id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL);
    
    
CREATE TABLE visas (
	visa_id INT AUTO_INCREMENT PRIMARY KEY,
	client_id  INT NOT NULL,
    country_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT fk_visas_clients FOREIGN KEY (client_id) REFERENCES clients(client_id),
    CONSTRAINT fk_visas_countries FOREIGN KEY (country_id) REFERENCES countries(country_id));
    
CREATE TABLE tours(
	tour_id INT AUTO_INCREMENT PRIMARY KEY,
	country_id INT NOT NULL,
	city_id INT NOT NULL,
	#hotel_id INT NOT NULL,
    name VARCHAR(150) NULL,
    description VARCHAR(1000) NULL,
	#CONSTRAINT fk_tours_hotels FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id),
    CONSTRAINT fk_tours_cities FOREIGN KEY (city_id) REFERENCES cities(city_id),
    CONSTRAINT fk_tours_countries FOREIGN KEY (country_id) REFERENCES countries(country_id));
    
CREATE TABLE client_tours(
	client_tour_id INT AUTO_INCREMENT PRIMARY KEY,
	client_id INT NOT NULL,
    tour_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL, 
   # rooms_count INT NOT NULL,
    CONSTRAINT fk_client_tours_clients FOREIGN KEY (client_id) REFERENCES clients(client_id),
    CONSTRAINT fk_client_tours_tours FOREIGN KEY (tour_id) REFERENCES tours(tour_id));
    

CREATE TABLE hotel_rooms(
	room_id INT AUTO_INCREMENT PRIMARY KEY,
	hotel_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT fk_hotel_rooms_hotel FOREIGN KEY (hotel_id) REFERENCES hotels(hotel_id));
    

 CREATE TABLE booked_rooms(
	room_id INT NOT NULL,
    client_tour_id INT NOT NULL,
	start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT fk_booked_rooms_hotel_rooms FOREIGN KEY (room_id) REFERENCES hotel_rooms(room_id),
    CONSTRAINT fk_booked_rooms_client_tour FOREIGN KEY (client_tour_id) REFERENCES client_tours(client_tour_id));   
    
    
