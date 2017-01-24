package com.softserve.edu.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.softserve.edu.dao.HibernateUtil;
import com.softserve.edu.entity.*;
import com.softserve.edu.service.*;

public class Application {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try {

            // loadData();
            Date date = null;
            try {
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormatter.parse("2017-02-20");
            } catch (ParseException e) {
                System.out.println("Parsing error");
            }

            findCountriesAndCities();
            System.out.println("--------------------------------------");
            findHotels("Warsaw");
            System.out.println("--------------------------------------");
            findCountOfFreeRooms("Hotel Metropol", date);
            System.out.println("--------------------------------------");
            findFreeHotels("Warsaw", date);
            System.out.println("--------------------------------------");
            findVisasByClient("Ivan", "Petrenko");
            System.out.println("--------------------------------------");
            countOfVisas("Hungary");
            System.out.println("--------------------------------------");
            reserveHotel("Ivan","Petrenko" ,"Poland","Warsaw",date);
            System.out.println("--------------------------------------");
            showClientStatistics("Ivan", "Petrenko");
            System.out.println("--------------------------------------");

        } finally {
            factory.close();

        }

    }

    // Query1
    public static void findCountriesAndCities() {

        CountryService countryService = new CountryService();
        Set<Country> countries = new HashSet<>(countryService.getAllCountries());
        System.out.println("All countries:");
        for (Country country : countries) {
            System.out.println(country.getName());
        }

        System.out.println("All cities:");
        CityService cityService = new CityService();
        Set<City> cities = new HashSet<>(cityService.getAllCities());
        for (City city : cities) {
            System.out.println(city.getName());
        }

    }

    // Query2
    public static void findHotels(String city) {
        System.out.println("Hotels in " + city + ":");
        HotelService hotelService = new HotelService();
        Set<Hotel> hotels = hotelService.findHotels(city);
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getName());
        }
    }

    // Query3
    public static void findCountOfFreeRooms(String hotel, Date date) {
        HotelService hotelService = new HotelService();
        int count = hotelService.findCountOfFreeRooms(hotel, date);
        System.out.println(hotel + ": Count of Free Rooms on " + date + " :" + count);
    }

    // Query4
    public static void findFreeHotels(String city, Date date) {
        HotelService hotelService = new HotelService();
        List<Object[]> list = hotelService.findFreeHotels(city, date);
        System.out.println("City:" + city + " on " + date);
        for (Object[] aRow : list) {

            System.out.println("Hotel:" + aRow[0] + " Free rooms:" + aRow[1]);
        }
    }

    // Query 5
    public static void findVisasByClient(String firstName, String lastName) {
        VisaService visaService = new VisaService();
        Set<Visa> visas = visaService.findVisas(firstName, lastName);
        System.out.println("Client " + firstName + " " + lastName + " has " + visas.size() + " visas");
        for (Visa visa : visas) {
            System.out.println("Country:" + visa.getCountry().getName());
            System.out.println("Start Date:" + visa.getStartDate());
            System.out.println("End Date:" + visa.getEndDate());
        }
    }

    // Query 6

    public static void countOfVisas(String country) {
        VisaService visaService = new VisaService();
        int count = visaService.countOfVisas(country);
        System.out.println("Count of visas to " + country + ":" + count);

    }

    // Query 7
    public static void reserveHotel(String firstName, String lastName, String country, String city, Date date) {
        VisaService visaService = new VisaService();
        List<Visa> visas = visaService.findValidVisas(firstName, lastName, country);
        if (visas.isEmpty()) {
            System.out.println("Client can't reserve a Hotel because of not valid visa");
            return;
        }

        System.out.println("Information about visas:");
        for (Visa visa : visas) {
            System.out.println("Country:" + visa.getCountry().getName());
            System.out.println("Start Date:" + visa.getStartDate());
            System.out.println("End Date:" + visa.getEndDate());
        }

        HotelService hotelService = new HotelService();
        List<Object[]> list = hotelService.findFreeHotels(city, date);
        if (list.isEmpty()) {
            System.out.println("Sorry, but there are no free hotels");
            return;
        }
        System.out.println("Hotels for reservation:");
        System.out.println("City:" + city + " on " + date);
        for (Object[] aRow : list) {

            System.out.println("Hotel:" + aRow[0] + " Free rooms:" + aRow[1]);
        }

    }

    // Query 8
    public static void showClientStatistics(String firstName, String lastName) {
        ClientService clientService = new ClientService();
        Client client = clientService.findClient(firstName, lastName);
        System.out.println("Client " + firstName + " " + lastName);
        System.out.println("Information about visas:");
        Set<Visa> visas = client.getVisas();
        for (Visa visa : visas) {
            System.out.println("Country:" + visa.getCountry().getName());
            System.out.println("Start Date:" + visa.getStartDate());
            System.out.println("End Date:" + visa.getEndDate());
        }
        CountryService countryService = new CountryService();
        List<Country> countries = countryService.findVisitedCountries(firstName, lastName);
        System.out.println("Client visited those countries:");
        for (Country country : countries) {
            System.out.println(country.getName());
        }

    }

    public static void loadData() {

        addCountries();
        addCities();
        addHotels();
        addHotelRooms();
        addTours();
        addClients();
        addClientTours();
        addVisas();
        addBookings();
        System.out.println("Data has been loaded");

    }

    private static void addCountries() {
        CountryService countryService = new CountryService();
        Country country1 = new Country("Poland");
        Country country2 = new Country("Hungary");
        countryService.addCountry(country1);
        countryService.addCountry(country2);

    }

    private static void addCities() {
        CountryService countryService = new CountryService();
        Country country1 = countryService.getCountryById(1);
        Country country2 = countryService.getCountryById(2);

        CityService cityService = new CityService();
        City city1 = new City("Warsaw", country1);
        country1.getCities().add(city1);
        City city2 = new City("Krakow", country1);
        country1.getCities().add(city2);
        City city3 = new City("Budapest", country2);
        country2.getCities().add(city2);

        cityService.addCity(city1);
        cityService.addCity(city2);
        cityService.addCity(city3);

    }

    private static void addHotels() {
        CityService cityService = new CityService();
        City city1 = cityService.getCityById(1);
        City city2 = cityService.getCityById(2);
        City city3 = cityService.getCityById(3);

        Hotel[] hotels = new Hotel[7];
        HotelService hotelService = new HotelService();
        hotels[0] = new Hotel("Hotel Metropol", 5, city1);
        city1.getHotels().add(hotels[0]);
        hotels[1] = new Hotel("Catalina Apartment", 5, city1);
        city1.getHotels().add(hotels[1]);
        hotels[2] = new Hotel("Apartamenty Parkside Krakow", 5, city2);
        city2.getHotels().add(hotels[2]);
        hotels[3] = new Hotel("Student-House Kazimierzowska", 5, city2);
        city2.getHotels().add(hotels[3]);
        hotels[4] = new Hotel("Elite Apartments Budapest", 5, city3);
        city3.getHotels().add(hotels[4]);
        hotels[5] = new Hotel("2night Hostel", 5, city3);
        city3.getHotels().add(hotels[5]);
        hotels[6] = new Hotel("Artist Residence", 5, city3);
        city3.getHotels().add(hotels[6]);

        for (int i = 0; i < hotels.length; i++) {
            hotelService.addHotel(hotels[i]);
        }

    }

    private static void addHotelRooms() {
        Hotel[] hotels = new Hotel[7];
        HotelService hotelService = new HotelService();
        for (int i = 0; i < hotels.length; i++) {
            hotels[i] = hotelService.getHotelById(i + 1);
        }
        HotelRoomService hotelRoomService = new HotelRoomService();
        HotelRoom[][] hotelRooms = new HotelRoom[7][5];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                hotelRooms[i][j] = new HotelRoom("Room" + (j + 1), hotels[i]);
                hotels[i].getHotelRooms().add(hotelRooms[i][j]);
                hotelRoomService.addHotelRoom(hotelRooms[i][j]);
            }
        }
    }

    private static void addTours() {
        TourService tourService = new TourService();
        CityService cityService = new CityService();
        City city1 = cityService.getCityById(1);
        City city2 = cityService.getCityById(2);
        City city3 = cityService.getCityById(3);

        CountryService countryService = new CountryService();
        Country country1 = countryService.getCountryById(1);
        Country country2 = countryService.getCountryById(2);

        Tour tour1 = new Tour("Tour in Warsaw", null, country1, city1);
        country1.getTours().add(tour1);
        city1.getTours().add(tour1);
        Tour tour2 = new Tour("Tour in Krakow", null, country1, city2);
        country1.getTours().add(tour1);
        city2.getTours().add(tour1);
        Tour tour3 = new Tour("Tour in Budapest", null, country2, city3);
        country2.getTours().add(tour1);
        city3.getTours().add(tour1);
        tourService.addTour(tour1);
        tourService.addTour(tour2);
        tourService.addTour(tour3);
    }

    private static void addClients() {
        ClientService clientService = new ClientService();
        Client[] clients = new Client[5];
        clients[0] = new Client("Ivan", "Petrenko");
        clients[1] = new Client("Evhen", "Kohut");
        clients[2] = new Client("Luk", "SkyWoker");
        clients[3] = new Client("Jony", "Kesh");
        clients[4] = new Client("Yura", "Bilyui");
        for (int i = 0; i < 5; i++) {
            clientService.addClient(clients[i]);
        }
    }

    private static void addClientTours() {
        ClientTourService clientTourService = new ClientTourService();
        ClientService clientService = new ClientService();
        TourService tourService = new TourService();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Client client1 = clientService.getClientById(1);
        Client client2 = clientService.getClientById(2);

        Tour tour1 = tourService.getTourById(1);
        Tour tour2 = tourService.getTourById(3);
        ClientTour clientTour1 = null;
        ClientTour clientTour2 = null;
        try {

            clientTour1 = new ClientTour(client1, tour1, formatter.parse("2017-01-01"), formatter.parse("2017-01-31"));
            clientTour2 = new ClientTour(client2, tour2, formatter.parse("2017-02-01"), formatter.parse("2017-02-28"));
        } catch (ParseException e) {
            System.out.println("Date parse error" + e);
        }
        tour1.getClientTours().add(clientTour1);
        client1.getClientTours().add(clientTour1);
        tour2.getClientTours().add(clientTour2);
        client2.getClientTours().add(clientTour2);
        clientTourService.addClientTour(clientTour1);
        clientTourService.addClientTour(clientTour2);

    }

    private static void addVisas() {

        VisaService visaService = new VisaService();
        ClientService clientService = new ClientService();
        CountryService countryService = new CountryService();
        Country country1 = countryService.getCountryById(1);
        Country country2 = countryService.getCountryById(2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Client[] clients = new Client[5];
        for (int i = 0; i < 5; i++) {
            clients[i] = clientService.getClientById(i + 1);
        }

        Visa[] visas = new Visa[5];
        try {
            visas[0] = new Visa(clients[0], country1, formatter.parse("2017-01-01"), formatter.parse("2017-12-31"));
            visas[1] = new Visa(clients[1], country1, formatter.parse("2017-01-31"), formatter.parse("2017-08-21"));
            visas[2] = new Visa(clients[2], country1, formatter.parse("2016-01-31"), formatter.parse("2018-12-31"));
            visas[3] = new Visa(clients[3], country2, formatter.parse("2017-01-31"), formatter.parse("2018-12-31"));
            visas[4] = new Visa(clients[4], country2, formatter.parse("2017-01-31"), formatter.parse("2018-12-31"));
        } catch (ParseException e) {
            System.out.println("Date parse error" + e);
        }

        for (int i = 0; i < 3; i++) {
            clients[i].getVisas().add(visas[i]);
            country1.getVisas().add(visas[i]);
        }

        for (int i = 3; i < 5; i++) {
            clients[i].getVisas().add(visas[i]);
            country2.getVisas().add(visas[i]);
        }

        for (int i = 0; i < 5; i++) {
            visaService.addVisa(visas[i]);
        }

    }

    private static void addBookings() {
        ClientTourService clientTourService = new ClientTourService();
        HotelRoomService hrService = new HotelRoomService();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HotelRoom[] rooms = new HotelRoom[5];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = hrService.getHotelRoomById(i + 1);
        }

        ClientTour tour1 = clientTourService.getClientTourById(1);
        ClientTour tour2 = clientTourService.getClientTourById(2);
        BookingService bookingService = new BookingService();

        Booking booking[] = new Booking[5];
        for (int i = 0; i < booking.length; i++) {
            try {
                booking[i] = new Booking(rooms[i], tour1, formatter.parse("2017-01-01"), formatter.parse("2017-01-31"));
                tour1.getBooking().add(booking[i]);
                rooms[i].getBooking().add(booking[i]);
                bookingService.addBooking(booking[i]);
            } catch (ParseException e) {

                System.out.println("Date parse error" + e);
            }
        }

    }

}
