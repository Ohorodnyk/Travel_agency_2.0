USE travel_agency;

# 1. Країни (міста), з якими співпрацює фірма
SELECT 
	cn.name AS city_name, 
    ct.name AS country_name
FROM cities ct
INNER JOIN countries cn ON ct.country_id=cn.country_id;

# 2.  Знайти готелі по назві міста
SET @city_name='Краків';

SELECT 
	ht.hotel_id, 
    ht.name hotel_name, 
    ht.rooms_count
FROM hotels ht
INNER JOIN cities ct ON ht.city_id=ct.city_id
WHERE ct.name=@city_name;

# 3. Чи можна забронювати готель на певну дату (чи є вільні номери на певну дату)

SET @hotelName='Hotel Metropol';
SET @requred_date='2017-02-20';

SELECT 
	COUNT(br.room_id) free_room_count 
FROM hotel_rooms hr
JOIN hotels ht ON hr.hotel_id=ht.hotel_id
LEFT JOIN booked_rooms br ON hr.room_id=br.room_id
WHERE ht.name=@hotelName
AND (@requred_date NOT BETWEEN br.start_date AND br.end_date
AND br.end_date < @requred_date)
OR (br.start_date IS NULL AND br.end_date IS NULL);


# 4. Подивитись всі доступні готелі у певному місті на певну дату

SET @city='Warsaw';
SET @requred_date='2016-02-20';

SELECT H.name, COUNT(*)
FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=@city) C
ON H.city_id=C.city_id
LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id
LEFT JOIN booking BR ON HR.room_id=BR.room_id
WHERE ((BR.start_date IS NULL AND BR.end_date IS NULL)
OR @requred_date NOT BETWEEN BR.start_date AND BR.end_date)
AND @requred_date>=CURDATE();
group by H.name;

#5 Кількість віз для конкретного клієнта
USE travel_agency;
SET @firstName='Іван';
SET @lastName='Петренко';

SELECT c.first_name, c.last_name, COUNT(v.visa_id) 'Кількість віз' 
FROM visas v
JOIN clients c ON v.client_id=c.client_id
WHERE @firstName=c.first_name and @lastName=c.last_name;

#6 Скільки віз видано в певну країну
SET @countryName='Польща';

SELECT c.name 'Назва країни', COUNT(v.visa_id) 'Кількість віз' 
FROM countries c 
JOIN visas v ON c.country_id=v.country_id
WHERE c.name=@countryName;

# 7 Чи можна забронювати для конкретного клієнта (як п.2-3)
# чи є віза 
SET @firstName='Іван';
SET @lastName='Петренко';
SET @country='Польща';

SELECT w.name, v.start_date, v.end_date FROM visas v
JOIN clients c on v.visa_id=c.client_id
JOIN countries w on v.country_id=w.country_id
WHERE c.first_name=@firstName
AND c.last_name=@lastName
AND v.end_date>CURDATE()
AND w.name=@country;

# чи є вільні місця в готелях заданого міста
use travel_agency2;
SET @city='Варшава';
SET @requred_date='2017-02-20';

SELECT H.name, COUNT(*)
FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=@city) C
ON H.city_id=C.city_id
LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id
LEFT JOIN booked_rooms BR ON HR.room_id=BR.room_id
WHERE BR.end_date IS NULL 
OR @requred_date NOT BETWEEN BR.start_date AND BR.end_date
group by H.name;

# 8 Отримати статистику по клієнту (які країни відвідував, які має візи)

SET @firstName='Іван';
SET @lastName='Петренко';

# каїни які відвідувавa
SELECT DISTINCT w.name 
FROM clients c
JOIN client_tours ct on c.client_id=ct.client_id
JOIN tours t on ct.client_tour_id=t.tour_id 
JOIN countries w on t.country_id=w.country_id
WHERE @firstName=c.first_name and @lastName=c.last_name;



# інформація про візи клієнта
SELECT DISTINCT w.name 'Назва країни', v.start_date, v.end_date 
FROM clients c 
JOIN visas v on c.client_id=v.client_id
JOIN countries w on v.country_id=w.country_id
WHERE @firstName=c.first_name and @lastName=c.last_name;

#9 Завантаженість кімнат (кількість днів) на протязі певного періоду
SET @hotelName='Hotel Metropol';
SET @startPeriod=CAST('2016-12-20' AS DATE);
SET @endPeriod=CAST('2017-01-25' AS DATE);

USE travel_agency;
SELECT h.name, br.room_id, hr.name, br.start_date, br.end_date
FROM hotels h
JOIN hotel_rooms hr on h.hotel_id=hr.hotel_id
LEFT JOIN booked_rooms br on hr.room_id=br.room_id
WHERE ((h.name=@hotelName) AND (br.start_date IS NOT NULL AND br.end_date IS NOT NULL))
AND (((CAST(br.start_date AS DATE) BETWEEN @startPeriod AND  @endPeriod)
OR ( br.end_date BETWEEN @startPeriod AND @endPeriod))
OR ((@startPeriod<br.start_date AND @endPeriod> br.end_date)
OR ((@startPeriod>br.start_date AND @endPeriod< br.end_date))));

#10 Статистику по готелях (кількість клієнтів, середній час бронювання)

# кількість унікальних клієнтів готелю заданого готелю
SET @hotelName='Hotel Metropol';

SELECT COUNT(DISTINCT (ct.client_id)) FROM booked_rooms br
JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id
JOIN hotel_rooms r on br.room_id=r.room_id
JOIN hotels h on r.hotel_id=h.hotel_id
WHERE h.name=@hotelName;

# Середній час бронювання у заданому готелі

SET @hotelName='Hotel Metropol';

SELECT AVG( DATEDIFF(br.end_date, br.start_date) )FROM booked_rooms br
JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id
JOIN hotel_rooms r on br.room_id=r.room_id
JOIN hotels h on r.hotel_id=h.hotel_id
WHERE h.name=@hotelName;


