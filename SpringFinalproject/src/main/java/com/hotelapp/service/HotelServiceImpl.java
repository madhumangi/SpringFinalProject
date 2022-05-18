package com.hotelapp.service;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelapp.respository.IHotelRepository;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService{

    private IHotelRepository hotelRepository;
    @Autowired
    public void setHotelRepository(IHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
            hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel getHotelById(int hotelId) throws HotelNotFoundException{
        Hotel hotel= hotelRepository.findById(hotelId).get();
        if(hotel!=null)
            return hotel;
        else
            throw new HotelNotFoundException("Hotel Id not found");
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getByPropertyType(String propertyType) {
        return hotelRepository.findByPropertyType(propertyType);
    }

    @Override
    public List<Hotel> getByStarRatings(String starRatings) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByStarRatings(starRatings);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels of this star rating not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByHotelNameStartingWith(String hotelName) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByHotelNameStartingWith(hotelName);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

//    @Override
//    public List<Hotel> getByFacilityChoice(String facility) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findByFacilityChoice(facility);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels with this facility not found");
//        else
//            return hotels;
//    }
//
//    @Override
//    public List<Hotel> getByPriceLessThan(double price) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findByPriceLessThan(price);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels price in this range not found");
//        else
//            return hotels;
//    }

//    @Override
//    public List<Hotel> getByRatingsAndStarRatings(float ratings, String starRatings) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findByRatingsAndStarRatings(ratings, starRatings);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels not found");
//        else
//            return hotels;
//    }
//
//    @Override
//    public List<Hotel> getHotelByRatingsAndPropertyType(float ratings, String propertyType) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findHotelByRatingsAndPropertyType(ratings, propertyType);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels not found");
//        else
//            return hotels;
//    }
//
//    @Override
//    public List<Hotel> getHotelByCityAndRatings(String city, float ratings) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findHotelByCityAndRatings(city, ratings);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels not found");
//        else
//            return hotels;
//    }
//
//    @Override
//    public List<Hotel> getByRoomType(String roomType) throws HotelNotFoundException {
//        List<Hotel> hotels=hotelRepository.findByRoomType(roomType);
//        if(hotels.isEmpty())
//            throw new HotelNotFoundException("Hotels not found");
//        else
//            return hotels;
//    }
}
