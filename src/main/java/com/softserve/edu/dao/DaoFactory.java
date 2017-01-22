package com.softserve.edu.dao;

public class DaoFactory {
    private BookingDao bookingDao = null;
    private CityDao cityDao = null;
    private ClientDao clientDao = null;
    private ClientTourDao clientTourDao = null;
    private CountryDao countryDao = null;
    private HotelDao hotelDao = null;
    private HotelRoomDao hotelRoomDao = null;
    private TourDao tourDao = null;
    private VisaDao visaDao = null;

    private static DaoFactory instance = null;

    private DaoFactory() {
        bookingDao = new BookingDao();
        cityDao = new CityDao();
        clientDao = new ClientDao();
        clientTourDao = new ClientTourDao();
        countryDao = new CountryDao();
        hotelDao = new HotelDao();
        hotelRoomDao = new HotelRoomDao();
        tourDao = new TourDao();
        visaDao = new VisaDao();
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public BookingDao getBookingDao() {
        return bookingDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public ClientTourDao getClientTourDao() {
        return clientTourDao;
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public HotelDao getHotelDao() {
        return hotelDao;
    }

    public HotelRoomDao getHotelRoomDao() {
        return hotelRoomDao;
    }

    public TourDao getTourDao() {
        return tourDao;
    }

    public VisaDao getVisaDao() {
        return visaDao;
    }

}
