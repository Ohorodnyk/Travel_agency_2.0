# add contry
INSERT INTO countries (country_id,name, need_visa) VALUES (1,"Польща", 1);
INSERT INTO countries (country_id,name, need_visa) VALUES (2,"Угорщина", 1); 
# add city
INSERT INTO cities (country_id, name) 
VALUES (1,"Варшава"),
		(1,"Краків"); 
INSERT INTO cities (country_id, name) 
VALUES (2,"Будапешт");

#add hotel
INSERT INTO hotels (city_id, name, rooms_count)
VALUES (1,"Hotel Metropol",5),
		(1,"Catalina Apartment",5),
		(2,"Apartamenty Parkside Kraków",5),
        (2,"Student-House Kazimierzowska",5);
        
INSERT INTO hotels (city_id, name, rooms_count)
VALUES (3,"Elite Apartments Budapest",5),
		(3,"2night Hostel",5),
        (3,"Artist Residence",5);

#ADD ROOMS
INSERT INTO hotel_rooms (hotel_id, name)
VALUES (1, "Room #1"),(1, "Room #2"),(1, "Room #3"),(1, "Room #4"),(1, "Room #5"),
		(2, "Room #1"),(2, "Room #2"),(2, "Room #3"),(2, "Room #4"),(2, "Room #5"),
        (3, "Room #1"),(3, "Room #2"),(3, "Room #3"),(3, "Room #4"),(3, "Room #5"),
        (4, "Room #1"),(4, "Room #2"),(4, "Room #3"),(4, "Room #4"),(4, "Room #5");
INSERT INTO hotel_rooms (hotel_id, name)
VALUES (5, "Room #1"),(5, "Room #2"),(5, "Room #3"),(5, "Room #4"),(5, "Room #5"),
		(6, "Room #1"),(6, "Room #2"),(6, "Room #3"),(6, "Room #4"),(6, "Room #5"),
        (7, "Room #1"),(7, "Room #2"),(7, "Room #3"),(7, "Room #4"),(7, "Room #5");      

# add clients
INSERT INTO clients (first_name, last_name)
VALUES ("Іван", "Петренко"),
		("Євген", "Когут"), 
        ("Петрик", "Пятачкін"), 
        ("Люк", "Скайвокер"), 
        ("Джоні", "Кеш");


# add visas to Poland
INSERT INTO visas (client_id, country_id, start_date, end_date)
VALUES (1, 1,'2017-01-01', '2017-12-31'),
		(2, 1, '2017-01-31', '2017-08-21'),
		(3, 1, '2016-01-31', '2018-12-31'),
        (4, 2, '2017-01-31', '2018-12-31'),
        (5, 2, '2017-01-31', '2018-12-31');
# add tours        
INSERT INTO tours (country_id, city_id, name)
VALUES (1, 1, 'Тур у Варшаву'),  
		(1, 2, 'Тур у Краків'),
        (2, 3, 'Тур у Будапешт');
        
# add client tours
INSERT INTO client_tours (client_id, tour_id, start_date, end_date)
VALUES (1,1,'2017-01-01', '2017-01-31');
INSERT INTO client_tours (client_id, tour_id, start_date, end_date)
VALUES (2,3,'2017-02-01', '2017-02-28');

# add booking hotel rooms
INSERT INTO booked_rooms (room_id, client_tour_id, start_date, end_date)
VALUES (1,1,'2017-01-01', '2017-01-31'),
		(2,1,'2017-01-01', '2017-01-31'),
		(3,1,'2017-01-01', '2017-01-31'),
		(4,1,'2017-01-01', '2017-01-31'),
		(5,1,'2017-01-01', '2017-01-31');
INSERT INTO booked_rooms (room_id, client_tour_id, start_date, end_date)
VALUES (21,2,'2017-02-01', '2017-02-28'),
		(22,2,'2017-02-01', '2017-02-28'),
		(23,2,'2017-02-01', '2017-02-28'),
		(24,2,'2017-02-01', '2017-02-28'),
		(25,2,'2017-02-01', '2017-02-28');       
        
        